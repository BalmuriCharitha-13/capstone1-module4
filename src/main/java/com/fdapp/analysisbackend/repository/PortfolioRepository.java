package com.fdapp.analysisbackend.repository;

import java.util.*;
import com.fdapp.analysisbackend.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, UUID> {
    // List<Portfolio> findByUserId(UUID userId);
    List<Portfolio> findByUser_Id(UUID userId);

}
