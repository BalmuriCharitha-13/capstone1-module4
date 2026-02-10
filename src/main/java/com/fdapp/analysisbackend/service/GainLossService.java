package com.fdapp.analysisbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fdapp.analysisbackend.model.Portfolio;
import com.fdapp.analysisbackend.repository.PortfolioRepository;
import com.fdapp.analysisbackend.dto.GainLossDTO;

@Service
public class GainLossService {

    @Autowired
    private PortfolioRepository portfolioRepo;

    public List<GainLossDTO> getGains(UUID userId) {
        List<Portfolio> portfolios = portfolioRepo.findByUser_Id(userId);
        List<GainLossDTO> result = new ArrayList<>();

        for (Portfolio p : portfolios) {
            // Safely get unitsOwned and NAV
            BigDecimal units = p.getUnitsOwned() != null ? p.getUnitsOwned() : BigDecimal.ZERO;
            BigDecimal avgPrice = p.getAvgPurchasePrice() != null ? p.getAvgPurchasePrice() : BigDecimal.ZERO;
            BigDecimal currentNav = (p.getInvestmentProduct() != null && p.getInvestmentProduct().getCurrentNAV() != null)
                                     ? p.getInvestmentProduct().getCurrentNAV()
                                     : BigDecimal.ZERO;

            BigDecimal invested = units.multiply(avgPrice);
            BigDecimal current = units.multiply(currentNav);

            BigDecimal gainLoss = current.subtract(invested);
            double percent = invested.compareTo(BigDecimal.ZERO) == 0
                             ? 0
                             : gainLoss.divide(invested, 4, RoundingMode.HALF_UP).doubleValue() * 100;

            GainLossDTO dto = new GainLossDTO();
            dto.setInvestmentName(p.getInvestmentProduct() != null ? p.getInvestmentProduct().getName() : "N/A");
            dto.setUnitsOwned(units.doubleValue());
            dto.setInvestedAmount(invested.doubleValue());
            dto.setCurrentValue(current.doubleValue());
            dto.setGainLoss(gainLoss.doubleValue());
            dto.setReturnPercent(percent);

            result.add(dto);
        }

        return result;
    }
}
