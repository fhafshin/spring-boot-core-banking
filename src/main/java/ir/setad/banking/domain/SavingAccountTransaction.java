package ir.setad.banking.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@SequenceGenerator(name = "sequence-generator", initialValue = 1, sequenceName = "saving_account_transaction_sequence")
@Entity
@Table(name = "m_saving_account_transaction")
public class SavingAccountTransaction extends AbstractBaseEntityCustom implements Serializable {
    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private SavingAccountTransactionType transactionType;

    @Column(name = "transaction_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOf;

    @Column(name = "amount", scale = 6, precision = 19, nullable = false)
    private BigDecimal amount;


    @Column(name = "running_balance_derived", scale = 6, precision = 19)
    private BigDecimal runningBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saving_account_id")
    private SavingAccount savingAccount;

    public SavingAccountTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(SavingAccountTransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Date getDateOf() {
        return dateOf;
    }

    public void setDateOf(Date dateOf) {
        this.dateOf = dateOf;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getRunningBalance() {
        return runningBalance;
    }

    public void setRunningBalance(BigDecimal runningBalance) {
        this.runningBalance = runningBalance;
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }
}
