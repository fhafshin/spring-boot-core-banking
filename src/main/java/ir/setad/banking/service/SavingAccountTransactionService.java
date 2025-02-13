package ir.setad.banking.service;

import ir.setad.banking.domain.SavingAccount;
import ir.setad.banking.domain.SavingAccountTransaction;
import ir.setad.banking.domain.SavingAccountTransactionType;
import ir.setad.banking.domain.enums.SavingAccountStatusType;
import ir.setad.banking.repository.SavingAccountRepository;
import ir.setad.banking.repository.SavingAccountTransactionRepository;
import ir.setad.banking.service.dto.SavingAccountTransactionDTO;
import ir.setad.banking.service.mapper.SavingAccountTransactionMapper;
import ir.setad.banking.web.rest.errors.SavingAccountBlockedException;
import ir.setad.banking.web.rest.errors.SavingAccountNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SavingAccountTransactionService {

    private final SavingAccountTransactionMapper savingAccountTransactionMapper;
    private final SavingAccountRepository savingAccountRepository;


    private final SavingAccountTransactionRepository savingAccountTransactionRepository;

    public SavingAccountTransactionService(SavingAccountTransactionMapper savingAccountTransactionMapper, SavingAccountRepository savingAccountRepository, SavingAccountTransactionRepository savingAccountTransactionRepository) {
        this.savingAccountTransactionMapper = savingAccountTransactionMapper;
        this.savingAccountRepository = savingAccountRepository;
        this.savingAccountTransactionRepository = savingAccountTransactionRepository;
    }

    public List<SavingAccountTransactionDTO> findAll() {

       return savingAccountTransactionRepository.findAll()
                .stream().map(savingAccountTransactionMapper::toDTO)
                .collect(Collectors.toCollection(LinkedList::new));
    }


    public SavingAccountTransactionDTO handleDeposit(Long savingId, SavingAccountTransactionDTO savingAccountTransactionDTO) {

        Optional<SavingAccount> retSavingAccount= savingAccountRepository.findById(savingId);

       if(retSavingAccount.isPresent()){
           SavingAccount savingAccount= retSavingAccount.get();
           validateForAccountBlock(savingAccount);

           SavingAccountTransaction savingAccountTransaction=savingAccountTransactionMapper.toEntity(savingAccountTransactionDTO);

           savingAccountTransaction.setSavingAccount(savingAccount);
          savingAccountTransaction= savingAccountTransactionRepository.save(savingAccountTransaction);
          savingAccountTransactionDTO= savingAccountTransactionMapper.toDTO(savingAccountTransaction);

          savingAccount.setAccountBalance(savingAccountTransaction.getAmount().add(savingAccount.getAccountBalance()));
          savingAccountRepository.save(savingAccount);


       }
       else
       {
           throw new SavingAccountNotFoundException("saving account not found",savingId.toString(),"account not found");

       }
       return savingAccountTransactionDTO;
    }

    private void validateForAccountBlock(SavingAccount savingAccount) {

        final SavingAccountStatusType currentStatus=savingAccount.getStatus();
        if(SavingAccountStatusType.BLOCK.equals(currentStatus)){
            throw new SavingAccountBlockedException("saving account blocked",savingAccount.getId().toString(),"account blocked");


        }

    }
}
