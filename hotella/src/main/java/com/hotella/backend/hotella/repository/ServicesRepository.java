package com.hotella.backend.hotella.repository;

import com.hotella.backend.hotella.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {

}
