package com.hotella.backend.hotella.resource;
import com.hotella.backend.hotella.service.BarService;
import com.hotella.backend.hotella.service.dto.BarDTO;
import org.apache.tomcat.util.http.ResponseUtil;
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

/**
 * REST controller for managing Bar.
 */
@RestController
@RequestMapping("/api")
public class BarResource {

    private final Logger log = LoggerFactory.getLogger(BarResource.class);

    private static final String ENTITY_NAME = "bar";

    private final BarService barService;


    public BarResource(BarService barService) {
        this.barService = barService;
    }

    /**
     * POST  /bars : Create a new bar.
     *
     * @param barDTO the barDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new barDTO, or with status 400 (Bad Request) if the bar has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/bars")
    public ResponseEntity<BarDTO> createBar(@Valid @RequestBody BarDTO barDTO) throws URISyntaxException {
        log.info("REST request to save Bar : {}", barDTO);
        if (barDTO.getId() != null) {
            return new ResponseEntity<>(barDTO, HttpStatus.BAD_REQUEST);
        }
        BarDTO result = barService.save(barDTO);
        return ResponseEntity.created(new URI("/api/bars/" + result.getId()))
            .body(result);
    }

    /**
     * PUT  /bars : Updates an existing bar.
     *
     * @param barDTO the barDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated barDTO,
     * or with status 400 (Bad Request) if the barDTO is not valid,
     * or with status 500 (Internal Server Error) if the barDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/bars")
    public ResponseEntity<BarDTO> updateBar(@Valid @RequestBody BarDTO barDTO) throws URISyntaxException {
        log.info("REST request to update Bar : {}", barDTO);
        if (barDTO.getId() == null) {
            return new ResponseEntity<>(barDTO, HttpStatus.BAD_REQUEST);
        }
        BarDTO result = barService.save(barDTO);
        return ResponseEntity.ok()
            .body(result);
    }

    /**
     * GET  /bars : get all the bars.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of bars in body
     */
    @GetMapping("/bars")
    public ResponseEntity<List<BarDTO>> getAllBars() {
        log.info("REST request to get Bars by criteria: {}");
        List<BarDTO> entityList = barService.findAll();

        return ResponseEntity.ok().body(entityList);
    }


    /**
     * GET  /bars/:id : get the "id" bar.
     *
     * @param id the id of the barDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the barDTO, or with status 404 (Not Found)
     */
    @GetMapping("/bars/{id}")
    public ResponseEntity<BarDTO> getBar(@PathVariable Long id) {
        log.info("REST request to get Bar : {}", id);
        Optional<BarDTO> barDTO = barService.findOne(id);

        if (barDTO.isPresent()) {
            return ResponseEntity.ok().body(barDTO.get());
        } else {
            return ResponseEntity.ok().body(null);
        }
    }

    /**
     * DELETE  /bars/:id : delete the "id" bar.
     *
     * @param id the id of the barDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/bars/{id}")
    public ResponseEntity<Void> deleteBar(@PathVariable Long id) {
        log.info("REST request to delete Bar : {}", id);
        barService.delete(id);
        return ResponseEntity.ok().build();
    }
}
