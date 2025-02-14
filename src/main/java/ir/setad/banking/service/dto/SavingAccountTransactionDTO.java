package ir.setad.banking.service.dto;

import ir.setad.banking.domain.SavingAccountTransactionType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SavingAccountTransactionDTO implements Serializable {

    private SavingAccountTransactionType transactionType;

    private Date dateOf;

    private BigDecimal amount;


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
}
