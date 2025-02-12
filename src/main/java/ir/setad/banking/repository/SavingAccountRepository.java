package ir.setad.banking.repository;

import ir.setad.banking.domain.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingAccountRepository extends JpaRepository<SavingAccount,Long> {
}
