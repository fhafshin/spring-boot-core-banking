package ir.setad.banking.service;

import ir.setad.banking.domain.Client;
import ir.setad.banking.repository.ClientRepository;
import ir.setad.banking.web.rest.ClientResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {


        return clientRepository.findAll();
    }
}
