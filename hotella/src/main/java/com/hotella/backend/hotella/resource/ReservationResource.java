package com.hotella.backend.hotella.resource;

import com.hotella.backend.hotella.model.Reservation;
import com.hotella.backend.hotella.service.ReservationService;
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
public class ReservationResource {

    private final Logger log = LoggerFactory.getLogger(ReservationResource.class);

    private final ReservationService ReservationService;

    public ReservationResource(ReservationService ReservationService) {
        this.ReservationService = ReservationService;
    }

    @PostMapping("/Reservation")
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation Reservation) throws URISyntaxException {
        log.info("REST request to save Reservation : {}", Reservation);
        if (Reservation.getId() != null) {
            return new ResponseEntity<>(Reservation, HttpStatus.BAD_REQUEST);
        }
        Reservation result = ReservationService.save(Reservation);
        return ResponseEntity.created(new URI("/api/Reservation/" + result.getId()))
                .body(result);
    }

    @PutMapping("/Reservation")
    public ResponseEntity<Reservation> updateReservation(@Valid @RequestBody Reservation Reservation) {
        log.info("REST request to update Reservation : {}", Reservation);
        if (Reservation.getId() == null) {
            return new ResponseEntity<>(Reservation, HttpStatus.BAD_REQUEST);
        }
        Reservation result = ReservationService.save(Reservation);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/Reservation")
    public List<Reservation> getAllReservation() {
        log.info("REST request to get all Reservation");
        return ReservationService.findAll();
    }

    @GetMapping("/Reservation/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        log.info("REST request to get Reservation : {}", id);
        Optional<Reservation> Reservation = ReservationService.findOne(id);
        if (Reservation.isPresent()) {
            return ResponseEntity.ok().body(Reservation.get());
        } else {
            return ResponseEntity.ok().body(null);
        }
    }

    @DeleteMapping("/Reservation/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        log.info("REST request to delete Reservation : {}", id);
        ReservationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
