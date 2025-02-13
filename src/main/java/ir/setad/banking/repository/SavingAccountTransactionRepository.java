package ir.setad.banking.repository;

import ir.setad.banking.domain.SavingAccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAccountTransactionRepository extends JpaRepository<SavingAccountTransaction, Long> {
}
