package com.hotella.backend.hotella.web.rest;

import com.hotella.backend.hotella.model.Hotel;
import com.hotella.backend.hotella.service.HotelService;
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
public class HotelResource {
    private final Logger log = LoggerFactory.getLogger(HotelResource.class);

    private final HotelService HotelService;

    public HotelResource(HotelService HotelService) {
        this.HotelService = HotelService;
    }

    @PostMapping("/Hotel")
    public ResponseEntity<Hotel> createHotel(@Valid @RequestBody Hotel Hotel) throws URISyntaxException {
        log.info("REST request to save Hotel : {}", Hotel);
        if (Hotel.getId() != null) {
            return new ResponseEntity<>(Hotel, HttpStatus.BAD_REQUEST);
        }
        Hotel result = HotelService.save(Hotel);
        return ResponseEntity.created(new URI("/api/Hotel/" + result.getId()))
                .body(result);
    }

    @PutMapping("/Hotel")
    public ResponseEntity<Hotel> updateHotel(@Valid @RequestBody Hotel Hotel) {
        log.info("REST request to update Hotel : {}", Hotel);
        if (Hotel.getId() == null) {
            return new ResponseEntity<>(Hotel, HttpStatus.BAD_REQUEST);
        }
        Hotel result = HotelService.save(Hotel);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/Hotel")
    public List<Hotel> getAllHotel() {
        log.info("REST request to get all Hotel");
        return HotelService.findAll();
    }

    @GetMapping("/Hotel/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable Long id) {
        log.info("REST request to get Hotel : {}", id);
        Optional<Hotel> Hotel = HotelService.findOne(id);
        if (Hotel.isPresent()) {
            return ResponseEntity.ok().body(Hotel.get());
        } else {
            return ResponseEntity.ok().body(null);
        }
    }

    @DeleteMapping("/Hotel/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        log.info("REST request to delete Hotel : {}", id);
        HotelService.delete(id);
        return ResponseEntity.ok().build();
    }
}
