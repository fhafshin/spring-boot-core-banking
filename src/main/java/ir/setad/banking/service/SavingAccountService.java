package ir.setad.banking.service;

import ir.setad.banking.domain.SavingAccount;
import ir.setad.banking.repository.SavingAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingAccountService {

    private final SavingAccountRepository savingAccountRepository;


    public SavingAccountService(SavingAccountRepository savingAccountRepository) {
        this.savingAccountRepository = savingAccountRepository;
    }

    public List<SavingAccount> findAll(){
        return savingAccountRepository.findAll();
    }
}
