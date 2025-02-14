package ir.setad.banking.domain;

import jakarta.persistence.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.Serializable;
import java.util.*;

@SequenceGenerator(name = "sequence-generator", initialValue = 1, sequenceName = "client_sequence")
@Entity
@Table(name = "m_client")
public class Client extends AbstractBaseEntityCustom implements Serializable {
    @Column(name = "firstname", length = 50)
    private String firstName;
    @Column(name = "lastname", length = 50)
    private String lastName;
    @Column(name = "middlename", length = 50)
    private String middleName;
    @Column(name = "mobile_no", unique = true, length = 50)
    private String mobileNo;
    @Column(name = "email_address", length = 50, unique = true)
    private String emailAddress;
    @Column(name = "external-id", unique = true, length = 100)
    private String externalId;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<SavingAccount> savingAccount=new ArrayList<>();





    public List<SavingAccount> getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(List<SavingAccount> savingAccount) {
        this.savingAccount = savingAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
