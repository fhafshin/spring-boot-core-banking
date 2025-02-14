package ir.setad.banking.service.mapper;


import ir.setad.banking.domain.SavingAccountTransaction;
import ir.setad.banking.domain.SavingAccountTransactionType;
import ir.setad.banking.service.dto.SavingAccountTransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SavingAccountTransactionMapper {

SavingAccountTransactionDTO toDTO(SavingAccountTransaction savingAccountTransaction);
  SavingAccountTransaction toEntity(SavingAccountTransactionDTO savingAccountTransactionDTO);
}
