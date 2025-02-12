package ir.setad.banking.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SequenceGenerator(name = "sequence-generator", initialValue = 1, sequenceName = "office_sequence")
@Entity
@Table(name = "m_office", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"}, name = "name_uniq")})
public class Office extends AbstractBaseEntityCustom implements Serializable {


    @Column(name = "name", nullable = false, length = 50)
    private String name;


    @Column(name = "opening_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date openingDate;
    @Column(name = "external_id", length = 100)
    private String externalId;


    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private Set<Office> children = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Office parent;

    @OneToMany(mappedBy = "office",fetch = FetchType.LAZY)
    private Set<Client> clients = new HashSet<>();




    public Set<Office> getChildren() {
        return children;
    }

    public void setChildren(Set<Office> children) {
        this.children = children;
    }

    public Office getParent() {
        return parent;
    }

    public void setParent(Office parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder().append("name is :").append(name).append("date is :").append(openingDate);
        if (externalId != null) {
            str.append(" external id is :").append(externalId);
        }

        return str.toString();
    }
}
