package ir.setad.banking.service;

import ir.setad.banking.domain.Account;
import ir.setad.banking.repository.AccountRepository;
import ir.setad.banking.service.dto.TransferrequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(rollbackOn = Exception.class)
    public void transferMoney(TransferrequestDTO transferrequestDTO) throws FileNotFoundException {
        try {
        Long idSender = transferrequestDTO.getSenderAccountId();
      Long idReceiver = transferrequestDTO.getReceiverAccountId();
        BigDecimal amount = transferrequestDTO.getAmount();


        Account sender = accountRepository.findById(idSender).orElse(null);
       Account receiver = accountRepository.findById(idReceiver).orElse(null);
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
       BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
       accountRepository.changeAmount(idReceiver, receiverNewAmount);



throw new RuntimeException("ooooo");//در صورتی که خطای runtime   رخ دهد تراکنش برمی گردد



}catch (Exception ex)
        {
            throw new FileNotFoundException("rbgtrg");//در صورت خطای غیر runtime باید به transactional اضافه شود کلاس exception.class
        }
    }


    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
