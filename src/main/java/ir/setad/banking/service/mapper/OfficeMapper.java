package ir.setad.banking.service.mapper;

import ir.setad.banking.domain.Office;
import ir.setad.banking.service.dto.OfficeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface OfficeMapper {


    @Mapping(source = "parentId",target = "parent")
    Office toEntity(OfficeDTO officeDTO);

@Mapping(source = "parent.id",target = "parentId")
    OfficeDTO toDTO(Office office);

    default Office fromId(Long id) {

        if (id == null) {
            return null;
        }
        Office office = new Office();
        office.setId(id);
        return office;
    }

}





