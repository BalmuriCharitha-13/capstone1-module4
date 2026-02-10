package com.fdapp.analysisbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fdapp.analysisbackend.dto.AllocationDTO;
import com.fdapp.analysisbackend.model.Portfolio;
import com.fdapp.analysisbackend.repository.PortfolioRepository;

@Service
public class AllocationService {

    @Autowired
    private PortfolioRepository portfolioRepo;

    public List<AllocationDTO> getAllocation(UUID userId) {
        List<Portfolio> portfolios = portfolioRepo.findByUser_Id(userId);

        Map<String, BigDecimal> typeMap = new HashMap<>();
        BigDecimal totalValue = BigDecimal.ZERO;

        for (Portfolio p : portfolios) {
            String type = p.getInvestmentProduct().getType().name();
            BigDecimal current = p.getUnitsOwned().multiply(p.getInvestmentProduct().getCurrentNAV());

            typeMap.put(type, typeMap.getOrDefault(type, BigDecimal.ZERO).add(current));
            totalValue = totalValue.add(current);
        }

        List<AllocationDTO> result = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> entry : typeMap.entrySet()) {
            BigDecimal percent = totalValue.compareTo(BigDecimal.ZERO) == 0
                                 ? BigDecimal.ZERO
                                 : entry.getValue().divide(totalValue, 4, RoundingMode.HALF_UP)
                                              .multiply(BigDecimal.valueOf(100));

            AllocationDTO dto = new AllocationDTO();
            dto.setInvestmentType(entry.getKey());
            dto.setAmount(entry.getValue().doubleValue());
            dto.setPercentage(percent.doubleValue());

            result.add(dto);
        }

        return result;
    }
}
