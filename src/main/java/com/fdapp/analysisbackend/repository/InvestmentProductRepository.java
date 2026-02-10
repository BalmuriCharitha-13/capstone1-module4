package com.fdapp.analysisbackend.repository;

import com.fdapp.analysisbackend.model.InvestmentProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface InvestmentProductRepository extends JpaRepository<InvestmentProduct, UUID> {
}

