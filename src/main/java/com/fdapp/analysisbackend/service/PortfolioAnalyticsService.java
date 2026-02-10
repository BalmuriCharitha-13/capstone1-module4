// package com.fdapp.analysisbackend.service;

// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;

// import java.util.*;
// import java.time.LocalDateTime;
// import java.math.BigDecimal;
// import java.math.RoundingMode;
// import java.time.Duration;

// import com.fdapp.analysisbackend.model.Transaction;
// import com.fdapp.analysisbackend.model.Portfolio;
// import com.fdapp.analysisbackend.dto.AllocationDTO;
// import com.fdapp.analysisbackend.dto.GainLossDTO;
// import com.fdapp.analysisbackend.dto.PortfolioSummaryDTO;
// import com.fdapp.analysisbackend.repository.PortfolioRepository;
// import com.fdapp.analysisbackend.repository.TransactionRepository;
// import com.fdapp.analysisbackend.repository.InvestmentProductRepository;

// @Service
// public class PortfolioAnalyticsService {

//     @Autowired
//     private PortfolioRepository portfolioRepo;

//     @Autowired
//     private TransactionRepository transactionRepo;

//     @Autowired
//     private InvestmentProductRepository productRepo;

//     // ------------------- PORTFOLIO SUMMARY -------------------
//     public PortfolioSummaryDTO getSummary(UUID userId) {
//         List<Portfolio> portfolios = portfolioRepo.findByUser_Id(userId);

//         BigDecimal totalInvested = BigDecimal.ZERO;
//         BigDecimal totalCurrent = BigDecimal.ZERO;

//         for (Portfolio p : portfolios) {
//             BigDecimal units = p.getUnitsOwned();
//             BigDecimal avgPrice = p.getAvgPurchasePrice();
//             BigDecimal currentNav = p.getInvestmentProduct().getCurrentNAV();

//             totalInvested = totalInvested.add(units.multiply(avgPrice));
//             totalCurrent = totalCurrent.add(units.multiply(currentNav));
//         }

//         BigDecimal gainLoss = totalCurrent.subtract(totalInvested);
//         double returnPercent = totalInvested.compareTo(BigDecimal.ZERO) == 0
//                                ? 0
//                                : gainLoss.divide(totalInvested, 4, RoundingMode.HALF_UP).doubleValue() * 100;

//         // First transaction date
//         List<Transaction> txns = transactionRepo.findByUser_Id(userId);
//         LocalDateTime firstDate = txns.stream()
//                 .map(Transaction::getTxnDate)
//                 .min(LocalDateTime::compareTo)
//                 .orElse(LocalDateTime.now());

//         double years = Duration.between(firstDate, LocalDateTime.now()).toDays() / 365.0;
//         double annualizedReturn = (years == 0 || totalInvested.compareTo(BigDecimal.ZERO) == 0) ? 0 :
//                 (Math.pow(totalCurrent.doubleValue() / totalInvested.doubleValue(), 1.0 / years) - 1) * 100;

//         PortfolioSummaryDTO dto = new PortfolioSummaryDTO();
//         dto.setTotalInvested(totalInvested.doubleValue());
//         dto.setCurrentValue(totalCurrent.doubleValue());
//         dto.setTotalGainLoss(gainLoss.doubleValue());
//         dto.setAbsoluteReturnPercent(returnPercent);
//         dto.setAnnualizedReturnPercent(annualizedReturn);

//         return dto;
//     }

//     // ------------------- ALLOCATION -------------------
//     public List<AllocationDTO> getAllocation(UUID userId) {
//         List<Portfolio> portfolios = portfolioRepo.findByUser_Id(userId);

//         Map<String, BigDecimal> typeMap = new HashMap<>();
//         BigDecimal totalValue = BigDecimal.ZERO;

//         for (Portfolio p : portfolios) {
//             String type = p.getInvestmentProduct().getType().name();
//             BigDecimal current = p.getUnitsOwned().multiply(p.getInvestmentProduct().getCurrentNAV());

//             typeMap.put(type, typeMap.getOrDefault(type, BigDecimal.ZERO).add(current));
//             totalValue = totalValue.add(current);
//         }

//         List<AllocationDTO> result = new ArrayList<>();
//         for (Map.Entry<String, BigDecimal> entry : typeMap.entrySet()) {
//             BigDecimal percent = totalValue.compareTo(BigDecimal.ZERO) == 0
//                                  ? BigDecimal.ZERO
//                                  : entry.getValue().divide(totalValue, 4, RoundingMode.HALF_UP)
//                                               .multiply(BigDecimal.valueOf(100));

//             AllocationDTO dto = new AllocationDTO();
//             dto.setInvestmentType(entry.getKey());
//             dto.setAmount(entry.getValue().doubleValue());
//             dto.setPercentage(percent.doubleValue());

//             result.add(dto);
//         }

//         return result;
//     }

//     // ------------------- GAINS/LOSSES -------------------
//     public List<GainLossDTO> getGains(UUID userId) {
//         List<Portfolio> portfolios = portfolioRepo.findByUser_Id(userId);
//         List<GainLossDTO> result = new ArrayList<>();

//         for (Portfolio p : portfolios) {
//             BigDecimal units = p.getUnitsOwned();
//             BigDecimal invested = units.multiply(p.getAvgPurchasePrice());
//             BigDecimal current = units.multiply(p.getInvestmentProduct().getCurrentNAV());

//             BigDecimal gainLoss = current.subtract(invested);
//             double percent = invested.compareTo(BigDecimal.ZERO) == 0
//                              ? 0
//                              : gainLoss.divide(invested, 4, RoundingMode.HALF_UP).doubleValue() * 100;

//             GainLossDTO dto = new GainLossDTO();
//             dto.setInvestmentName(p.getInvestmentProduct().getName());
//             dto.setInvestedAmount(invested.doubleValue());
//             dto.setCurrentValue(current.doubleValue());
//             dto.setGainLoss(gainLoss.doubleValue());
//             dto.setReturnPercent(percent);

//             result.add(dto);
//         }

//         return result;
//     }
// }
