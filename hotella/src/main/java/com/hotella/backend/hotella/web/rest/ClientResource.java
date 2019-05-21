package com.hotella.backend.hotella.web.rest;

import com.hotella.backend.hotella.model.Client;
import com.hotella.backend.hotella.service.ClientService;
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
public class ClientResource {
    private final Logger log = LoggerFactory.getLogger(ClientResource.class);

    private final com.hotella.backend.hotella.service.ClientService ClientService;

    public ClientResource(ClientService ClientService) {
        this.ClientService = ClientService;
    }

    @PostMapping("/Client")
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client Client) throws URISyntaxException {
        log.info("REST request to save Client : {}", Client);
        if (Client.getId() != null) {
            return new ResponseEntity<>(Client, HttpStatus.BAD_REQUEST);
        }
        Client result = ClientService.save(Client);
        return ResponseEntity.created(new URI("/api/Client/" + result.getId()))
                .body(result);
    }

    @PutMapping("/Client")
    public ResponseEntity<Client> updateClient(@Valid @RequestBody Client Client) {
        log.info("REST request to update Client : {}", Client);
        if (Client.getId() == null) {
            return new ResponseEntity<>(Client, HttpStatus.BAD_REQUEST);
        }
        Client result = ClientService.save(Client);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/Client")
    public List<Client> getAllClient() {
        log.info("REST request to get all Client");
        return ClientService.findAll();
    }

    @GetMapping("/Client/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        log.info("REST request to get Client : {}", id);
        Optional<Client> Client = ClientService.findOne(id);
        if (Client.isPresent()) {
            return ResponseEntity.ok().body(Client.get());
        } else {
            return ResponseEntity.ok().body(null);
        }
    }

    @DeleteMapping("/Client/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        log.info("REST request to delete Client : {}", id);
        ClientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
