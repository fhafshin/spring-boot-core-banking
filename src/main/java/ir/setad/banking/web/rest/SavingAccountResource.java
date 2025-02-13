package ir.setad.banking.web.rest;

import ir.setad.banking.domain.SavingAccount;
import ir.setad.banking.service.SavingAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api/saving-account")
public class SavingAccountResource  {

    private final SavingAccountService savingAccountService;


    public SavingAccountResource(SavingAccountService savingAccountService) {
        this.savingAccountService = savingAccountService;
    }

    @GetMapping("/find-all")
    public List<SavingAccount> findAll(){
        return savingAccountService.findAll();
    }
}
