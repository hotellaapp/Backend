package com.hotella.backend.hotella.resource;

import com.hotella.backend.hotella.service.InformationService;
import com.hotella.backend.hotella.service.dto.InformationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Information.
 */
@RestController
@RequestMapping("/api")
public class InformationResource {

    private final Logger log = LoggerFactory.getLogger(InformationResource.class);

    private final InformationService informationService;

    public InformationResource(InformationService informationService) {
        this.informationService = informationService;
    }

    @PostMapping("/information")
    public ResponseEntity<InformationDTO> createInformation(@RequestBody InformationDTO informationDTO) throws URISyntaxException {
        log.info("REST request to save Information : {}", informationDTO);
        if (informationDTO.getId() != null) {
            return new ResponseEntity<>(informationDTO, HttpStatus.BAD_REQUEST);
        }
        InformationDTO result = informationService.save(informationDTO);
        return ResponseEntity.created(new URI("/api/information/" + result.getId()))
                .body(result);
    }

    @PutMapping("/information")
    public ResponseEntity<InformationDTO> updateInformation(@RequestBody InformationDTO informationDTO) throws URISyntaxException {
        log.info("REST request to update Information : {}", informationDTO);
        if (informationDTO.getId() == null) {
            return new ResponseEntity<>(informationDTO, HttpStatus.BAD_REQUEST);
        }
        InformationDTO result = informationService.save(informationDTO);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/information")
    public List<InformationDTO> getAllInformation() {
        log.info("REST request to get all Information");
        return informationService.findAll();
    }

    @GetMapping("/information/{id}")
    public ResponseEntity<InformationDTO> getInformation(@PathVariable Long id) {
        log.info("REST request to get Information : {}", id);
        Optional<InformationDTO> informationDTO = informationService.findOne(id);
        if (informationDTO.isPresent()) {
            return ResponseEntity.ok().body(informationDTO.get());
        } else {
            return ResponseEntity.ok().body(null);
        }
    }

    @DeleteMapping("/information/{id}")
    public ResponseEntity<Void> deleteInformation(@PathVariable Long id) {
        log.info("REST request to delete Information : {}", id);
        informationService.delete(id);
        return ResponseEntity.ok().build();
    }


}
