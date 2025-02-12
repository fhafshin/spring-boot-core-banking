package ir.setad.banking.service.dto;

import ir.setad.banking.domain.enums.SavingAccountStatusType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class SavingAccountDTO {
    @NotNull
    private String accountNumber;
    private String externalId;
    private SavingAccountStatusType status;

    private BigDecimal minRequiredOpeningBalance;


    private BigDecimal nominalAnnualInterestRate;
    private BigDecimal accountBalance;


    private Long clientId;




    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public SavingAccountStatusType getStatus() {
        return status;
    }

    public void setStatus(SavingAccountStatusType status) {
        this.status = status;
    }

    public BigDecimal getMinRequiredOpeningBalance() {
        return minRequiredOpeningBalance;
    }

    public void setMinRequiredOpeningBalance(BigDecimal minRequiredOpeningBalance) {
        this.minRequiredOpeningBalance = minRequiredOpeningBalance;
    }

    public BigDecimal getNominalAnnualInterestRate() {
        return nominalAnnualInterestRate;
    }

    public void setNominalAnnualInterestRate(BigDecimal nominalAnnualInterestRate) {
        this.nominalAnnualInterestRate = nominalAnnualInterestRate;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
