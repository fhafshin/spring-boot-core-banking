package ir.setad.banking.service;

import ir.setad.banking.domain.SavingAccount;
import ir.setad.banking.repository.SavingAccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SavingAccountService {

    private final SavingAccountRepository savingAccountRepository;


    public SavingAccountService(SavingAccountRepository savingAccountRepository) {
        this.savingAccountRepository = savingAccountRepository;
    }

    public List<SavingAccount> findAll() {
        return savingAccountRepository.findAll();
    }

    public Optional<SavingAccount> findById(Long id) {
        return savingAccountRepository.findById(id);



    }
}
