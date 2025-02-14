package ir.setad.banking.web.rest;

import ir.setad.banking.domain.Account;
import ir.setad.banking.service.TransferService;
import ir.setad.banking.service.dto.TransferrequestDTO;
import jakarta.validation.constraints.Email;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/accountTransaction")
public class AccountResource {


    private final TransferService transferService;
    private final ProjectInfoAutoConfiguration projectInfoAutoConfiguration;

    public AccountResource(TransferService transferService, ProjectInfoAutoConfiguration projectInfoAutoConfiguration) {
        this.transferService = transferService;
        this.projectInfoAutoConfiguration = projectInfoAutoConfiguration;
    }


    @GetMapping("/find-all")
    public List<Account> findAll() {
        return transferService.findAll();
    }

    @PostMapping("/transfer")
    public ResponseEntity transferMoney(@RequestBody TransferrequestDTO transferrequestDTO) throws FileNotFoundException {

        transferService.transferMoney(transferrequestDTO);

       return ResponseEntity.ok("update amount");
    }
}
