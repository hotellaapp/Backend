package com.hotella.backend.hotella.web.rest;

import com.hotella.backend.hotella.model.Services;
import com.hotella.backend.hotella.service.ServicesService;
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

    private static final String ENTITY_NAME = "service";

    private final ServicesService servicesService;

    public ServicesResource(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @PostMapping("/services")
    public ResponseEntity<Services> createService(@Valid @RequestBody Services services) throws URISyntaxException {
        log.info("REST request to save Services : {}", services);
        if (services.getId() != null) {
            return new ResponseEntity<>(services, HttpStatus.BAD_REQUEST);
        }
        Services result = servicesService.save(services);
        return ResponseEntity.created(new URI("/api/services/" + result.getId()))
                .body(result);
    }

    @PutMapping("/services")
    public ResponseEntity<Services> updateService(@Valid @RequestBody Services services) throws URISyntaxException {
        log.info("REST request to update Services : {}", services);
        if (services.getId() == null) {
            return new ResponseEntity<>(services, HttpStatus.BAD_REQUEST);
        }
        Services result = servicesService.save(services);
        return ResponseEntity.ok()
                .body(result);
    }

    @GetMapping("/services")
    public List<Services> getAllServices() {
        log.info("REST request to get all Services");
        return servicesService.findAll();
    }

    @GetMapping("/services/{id}")
    public ResponseEntity<Services> getService(@PathVariable Long id) {
        log.info("REST request to get Services : {}", id);
        Optional<Services> services = servicesService.findOne(id);
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
