package ir.setad.banking.web.rest;

import ir.setad.banking.domain.SavingAccountTransaction;
import ir.setad.banking.service.SavingAccountTransactionService;
import ir.setad.banking.service.dto.SavingAccountTransactionDTO;
import ir.setad.banking.utils.HeaderUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/saving_account_transaction")
public class SavingAccountTransactionResource {

    private static final String ENTITY_NAME = "saving_account_transaction";

    @Value("${spring.application.name}")
    private String applicationName;


    private final SavingAccountTransactionService savingAccountTransactionService;

    public SavingAccountTransactionResource(SavingAccountTransactionService savingAccountTransactionService) {
        this.savingAccountTransactionService = savingAccountTransactionService;
    }

    @GetMapping("/test")
    public String test() {
        return applicationName;
    }

    @GetMapping("/savings-account-transactions")
    public List<SavingAccountTransactionDTO> getAllSavingAccountTransactions(){
        return  savingAccountTransactionService.findAll();
    }

    @PostMapping("/saving-account-transactions/{savingsId}/deposit")

    public ResponseEntity<SavingAccountTransactionDTO> deposit(@PathVariable Long savingId,@RequestBody SavingAccountTransactionDTO savingAccountTransactionDTO) throws URISyntaxException {


        SavingAccountTransactionDTO result= savingAccountTransactionService.handleDeposit(savingId,savingAccountTransactionDTO);

        return ResponseEntity
                .created(new URI("/api/saving-account-transactions"+result))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName,true,ENTITY_NAME,result.toString()))
                .body(result);

    }
}
