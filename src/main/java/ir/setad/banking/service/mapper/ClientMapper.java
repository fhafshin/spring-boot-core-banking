package ir.setad.banking.service.mapper;

import ir.setad.banking.domain.Client;
import ir.setad.banking.domain.Office;
import ir.setad.banking.service.dto.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {})
public interface ClientMapper {

    @Mapping(source = "officeId",target = "office")
    Client toEntity(ClientDto clientDto);


    @Mapping(source = "office.id",target = "officeId")
    ClientDto toDTO(Client client);

   default Office fromId(Long id){
        if(id==null){
            return null;
        }
        Office office = new Office();
        office.setId(id);
        return office;
    }

}
