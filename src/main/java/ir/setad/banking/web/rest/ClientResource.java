package ir.setad.banking.web.rest;

import ir.setad.banking.domain.Client;
import ir.setad.banking.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientResource {

    private final ClientService clientService;


    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/find-all")
    public List<Client> findAll(){

        return clientService.findAll();

    }
}
