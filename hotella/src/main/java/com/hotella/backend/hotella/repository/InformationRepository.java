package com.hotella.backend.hotella.repository;

import com.hotella.backend.hotella.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InformationRepository extends JpaRepository<Information, Long> {

}
