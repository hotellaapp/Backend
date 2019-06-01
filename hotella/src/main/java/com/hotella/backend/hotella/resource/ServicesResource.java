package com.hotella.backend.hotella.resource;

import com.hotella.backend.hotella.service.ServicesService;
import com.hotella.backend.hotella.service.dto.ServicesDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ServicesResource {

    private final Logger log = LoggerFactory.getLogger(ServicesResource.class);

    private final ServicesService servicesService;

    public ServicesResource(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @PostMapping("/services")
    public ResponseEntity<ServicesDTO> createService(@Valid @RequestBody ServicesDTO servicesDTO) throws URISyntaxException {
        log.info("REST request to save Services : {}", servicesDTO);
        if (servicesDTO.getId() != null) {
            return new ResponseEntity<>(servicesDTO, HttpStatus.BAD_REQUEST);
        }
        ServicesDTO result = servicesService.save(servicesDTO);
        return ResponseEntity.created(new URI("/api/services/" + result.getId()))
                .body(result);
    }

    @PutMapping("/services")
    public ResponseEntity<ServicesDTO> updateService(@Valid @RequestBody ServicesDTO servicesDTO) throws URISyntaxException {
        log.info("REST request to update Services : {}", servicesDTO);
        if (servicesDTO.getId() == null) {
            return new ResponseEntity<>(servicesDTO, HttpStatus.BAD_REQUEST);
        }
        ServicesDTO result = servicesService.save(servicesDTO);
        return ResponseEntity.ok()
                .body(result);
    }

    @GetMapping("/services")
    public List<ServicesDTO> getAllServices() {
        log.info("REST request to get all Services");
        return servicesService.findAll();
    }

    @GetMapping("/services/{id}")
    public ResponseEntity<ServicesDTO> getService(@PathVariable Long id) {
        log.info("REST request to get Services : {}", id);
        Optional<ServicesDTO> services = servicesService.findOne(id);
        if (services.isPresent()) {
            return ResponseEntity.ok().body(services.get());
        } else {
            return ResponseEntity.ok().body(null);
        }
    }

    @DeleteMapping("/services/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        log.info("REST request to delete Services : {}", id);
        servicesService.delete(id);
        return ResponseEntity.ok().build();
    }
}
