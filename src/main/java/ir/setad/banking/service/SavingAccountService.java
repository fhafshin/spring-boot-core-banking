package ir.setad.banking.service;

import ir.setad.banking.domain.SavingAccount;
import ir.setad.banking.repository.SavingAccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SavingAccountService implements Serializable {

    private final SavingAccountRepository savingAccountRepository;


    public SavingAccountService(SavingAccountRepository savingAccountRepository) {
        this.savingAccountRepository = savingAccountRepository;
    }
    @Transactional
    public List<SavingAccount> findAll() {
        return savingAccountRepository.findAll();
    }

    public Optional<SavingAccount> findById(Long id) {
        return savingAccountRepository.findById(id);



    }
}
