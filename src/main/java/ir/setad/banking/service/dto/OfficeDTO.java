package ir.setad.banking.service.dto;


import ir.setad.banking.service.customValidator.CustomValidation;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;


public class OfficeDTO implements Serializable {

    private Long id;


@NotNull(groups = {CreateGroup.class})
//@Size(max=20)
@CustomValidation(groups = CreateGroup.class)
    private String name;
    private Date openingDate;
    private String externalId;
    private Long parentId;

    public Long getParentId() {
        return parentId;
    }


    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
