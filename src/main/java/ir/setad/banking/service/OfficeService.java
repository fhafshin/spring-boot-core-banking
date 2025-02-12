package ir.setad.banking.service;

import ir.setad.banking.app.logging.CreateLogger;
import ir.setad.banking.domain.Office;
import ir.setad.banking.repository.OfficeRepository;
import ir.setad.banking.service.dto.OfficeDTO;
import ir.setad.banking.service.mapper.OfficeMapper;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfficeService {

    private final OfficeMapper officeMapper;
    private final OfficeRepository officeRepository;

    private final Logger log = CreateLogger.getLogger(OfficeService.class);

    public OfficeService(OfficeMapper officeMapper, OfficeRepository officeRepository) {
        this.officeMapper = officeMapper;
        this.officeRepository = officeRepository;
    }

    public OfficeDTO save(OfficeDTO officeDTO) {


        Office office = officeMapper.toEntity(officeDTO);


//
        log.debug("request to save office : {}", office);



        Office savedOffice = officeRepository.save(office);

        return officeMapper.toDTO(savedOffice);
    }

public List<OfficeDTO> findAll(){

        log.debug("return all offices");
        return officeRepository.findAll().stream().map(officeMapper::toDTO).collect(Collectors.toCollection(LinkedList::new));
}

public Optional<OfficeDTO> findOne(Long id){

        log.debug("return the one office");
        return officeRepository.findById(id).map(officeMapper::toDTO);
}
    public boolean existById(Long id) {

        return officeRepository.existsById(id);
    }

    public OfficeDTO update(OfficeDTO officeDTO){

        log.debug("request to update office:{}",officeDTO);

        Office office=officeMapper.toEntity(officeDTO);

        office=officeRepository.save(office);

        return officeMapper.toDTO(office);

    }

    public void delete(Long id) {

        officeRepository.deleteById(id);
    }
}
