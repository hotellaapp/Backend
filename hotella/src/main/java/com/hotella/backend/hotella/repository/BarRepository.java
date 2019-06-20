package com.hotella.backend.hotella.repository;

import com.hotella.backend.hotella.model.Bar;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Bar entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BarRepository extends JpaRepository<Bar, Long>, JpaSpecificationExecutor<Bar> {

}
