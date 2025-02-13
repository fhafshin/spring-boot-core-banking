package ir.setad.banking.service.dto;

import ir.setad.banking.domain.SavingAccountTransactionType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SavingAccountTransactionDTO implements Serializable {

    private SavingAccountTransactionType transactionType;

    private Date dateOf;

    private BigDecimal amount;


}
