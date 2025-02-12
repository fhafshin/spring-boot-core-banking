package ir.setad.banking.service.mapper;

import ir.setad.banking.domain.Client;
import ir.setad.banking.domain.SavingAccount;
import ir.setad.banking.service.dto.SavingAccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {})
public interface SavingAccountMapper {

@Mapping(source = "clientId",target =  "client")
    SavingAccount toEntity(SavingAccountDTO savingAccountDTO);

@Mapping(source = "client.id",target = "clientId")
SavingAccountDTO toDTO(SavingAccount savingAccount);

default Client fromId(Long id){
    if(id == null) return null;
    Client client = new Client();
    client.setId(id);
    return client;
}
}
