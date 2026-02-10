package com.fdapp.analysisbackend.service;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.Duration;

import com.fdapp.analysisbackend.dto.PortfolioSummaryDTO;
import com.fdapp.analysisbackend.model.Portfolio;
import com.fdapp.analysisbackend.model.Transaction;
import com.fdapp.analysisbackend.repository.PortfolioRepository;
import com.fdapp.analysisbackend.repository.TransactionRepository;
import java.util.ArrayList;
import com.fdapp.analysisbackend.dto.GainLossDTO;

@Service
public class PortfolioSummaryService {

    @Autowired
    private PortfolioRepository portfolioRepo;

    @Autowired
    private TransactionRepository transactionRepo;

    public PortfolioSummaryDTO getSummary(UUID userId) {
        List<Portfolio> portfolios = portfolioRepo.findByUser_Id(userId);

        BigDecimal totalInvested = BigDecimal.ZERO;
        BigDecimal totalCurrent = BigDecimal.ZERO;
        List<GainLossDTO> items = new ArrayList<>();

        for (Portfolio p : portfolios) {
            BigDecimal units = p.getUnitsOwned();
            BigDecimal avgPrice = p.getAvgPurchasePrice();
            BigDecimal currentNav = p.getInvestmentProduct().getCurrentNAV();

            BigDecimal invested = units.multiply(avgPrice);
            BigDecimal current = units.multiply(currentNav);

            totalInvested = totalInvested.add(invested);
            totalCurrent = totalCurrent.add(current);

            // Build per-product info
            GainLossDTO dto = new GainLossDTO();
            dto.setInvestmentName(p.getInvestmentProduct().getName());
            dto.setUnitsOwned(units.doubleValue());
            dto.setInvestedAmount(invested.doubleValue());
            dto.setCurrentValue(current.doubleValue());
            dto.setGainLoss(current.subtract(invested).doubleValue());
            dto.setReturnPercent(
                invested.compareTo(BigDecimal.ZERO) == 0
                ? 0
                : current.subtract(invested).divide(invested, 4, RoundingMode.HALF_UP).doubleValue() * 100
            );
            items.add(dto);
        }

        BigDecimal gainLoss = totalCurrent.subtract(totalInvested);
        double returnPercent = totalInvested.compareTo(BigDecimal.ZERO) == 0
                            ? 0
                            : gainLoss.divide(totalInvested, 4, RoundingMode.HALF_UP).doubleValue() * 100;

        PortfolioSummaryDTO summary = new PortfolioSummaryDTO();
        summary.setTotalInvested(totalInvested.doubleValue());
        summary.setCurrentValue(totalCurrent.doubleValue());
        summary.setTotalGainLoss(gainLoss.doubleValue());
        summary.setAbsoluteReturnPercent(returnPercent);
        summary.setAnnualizedReturnPercent(0); // Keep your current annualized calc
        summary.setPortfolioItems(items);       // ✅ set the breakdown

        return summary;
    }

}

