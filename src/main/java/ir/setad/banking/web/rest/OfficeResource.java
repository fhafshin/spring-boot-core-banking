package ir.setad.banking.web.rest;

import ir.setad.banking.app.logging.CreateLogger;
import ir.setad.banking.service.OfficeService;
import ir.setad.banking.service.dto.CreateGroup;
import ir.setad.banking.service.dto.OfficeDTO;
import ir.setad.banking.utils.HeaderUtil;
import ir.setad.banking.utils.ResponseUtil;
import ir.setad.banking.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/office")
public class OfficeResource {


    private static final String ENTITY_NAME = "office";
    private final Logger log = CreateLogger.getLogger(OfficeResource.class);
    @Value("${spring.application.name}")
    private String applicationName;
    private final OfficeService officeService;

    public OfficeResource(OfficeService officeService) {
        this.officeService = officeService;
    }

    /**
     * {@code post / office :create a new office
     *
     * @param officeDto the ooficeDto to create
     * @return {@link ResponseEntity} with stores {@code 201 (created) and with body the new officeDTo},or with sores {@code 400 (bad request}
     * @throws URISyntaxException if the Location URI syntax is incorrect
     *                            }
     */
    //  consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    @PostMapping()


    public ResponseEntity<OfficeDTO> createOffice(@Validated(CreateGroup.class) @RequestBody OfficeDTO officeDTO) throws URISyntaxException {
        log.info("REST REQUEST TO SAVE OFFICE:{}", officeDTO);

        if (officeDTO.getId() != null) {
            //  throw new BadRequestAlertException2("a new office connot already hoave an id");
            throw new BadRequestAlertException("a new office connot already have an id", ENTITY_NAME, "idexists");

        }

        OfficeDTO newOffice = officeService.save(officeDTO);

        return ResponseEntity
                .created(new URI("/api/office/" + newOffice.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, newOffice.getId().toString()))
                .body(newOffice);

    }

    @PutMapping()
    public ResponseEntity<OfficeDTO> update(@RequestBody OfficeDTO officeDTO) {
        log.debug("REST REQUEST TO UPDATE OFFICE {}", officeDTO);

        if (officeDTO.getId() == null) {
            throw new BadRequestAlertException("invalid id", ENTITY_NAME, "idnull");
        }

        if (!officeService.existById(officeDTO.getId())) {
            throw new BadRequestAlertException("entity not found", ENTITY_NAME, "idnotfound");
        }

        OfficeDTO result = officeService.update(officeDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
                .body(result);
    }

    @GetMapping("/find-all")
    public List<OfficeDTO> getAllOffices() {

        log.debug("rest request to get all offices");

        return officeService.findAll();

    }

    @GetMapping("/find-one/{id}")
    public ResponseEntity<OfficeDTO> getOne(@PathVariable @NumberFormat Long id) {
        log.debug("rest request to get office details");

        Optional<OfficeDTO> officeDTO = officeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(officeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        officeService.delete(id);
        return ResponseEntity
                .noContent()
                .headers(HeaderUtil.createEntityDeletaionAlert(applicationName, false, ENTITY_NAME, id.toString()))
                .build();
    }


}
