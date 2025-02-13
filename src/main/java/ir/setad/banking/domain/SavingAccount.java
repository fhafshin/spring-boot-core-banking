package ir.setad.banking.domain;

import ir.setad.banking.domain.enums.SavingAccountStatusType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SequenceGenerator(name = "sequence-generator", initialValue = 1, sequenceName = "savingAccount_sequence")
@Entity
@Table(name = "m_saving_account")

public class SavingAccount extends AbstractBaseEntityCustom implements Serializable {
    @Column(name = "account_no", length = 20, nullable = false, unique = true)
    private String accountNumber;
    @Column(name = "external_id")
    private String externalId;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private SavingAccountStatusType status;

    @Column(name = "min_required_opening_balance", scale = 6, precision = 19, nullable = true)
    private BigDecimal minRequiredOpeningBalance;


    @Column(name = "nominal_annual_interest_rate", scale = 6, precision = 19, nullable = false)
    private BigDecimal nominalAnnualInterestRate;
    @Column(name = "account_balance_derived")
    private BigDecimal accountBalance;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "savingAccount", fetch = FetchType.LAZY)
    private List<SavingAccountTransaction> transactions = new ArrayList<>();


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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
