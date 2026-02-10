package com.fdapp.analysisbackend.dto;

import java.math.BigDecimal;

public class PortfolioItemDTO {
    private String investmentName;
    private BigDecimal unitsOwned;
    private BigDecimal avgPurchasePrice;
    private BigDecimal currentNAV;
    private BigDecimal totalInvested;
    private BigDecimal currentValue;
    private BigDecimal gainLoss;
    private BigDecimal gainLossPercent;

    // Getters and Setters
    public String getInvestmentName() { return investmentName; }
    public void setInvestmentName(String investmentName) { this.investmentName = investmentName; }

    public BigDecimal getUnitsOwned() { return unitsOwned; }
    public void setUnitsOwned(BigDecimal unitsOwned) { this.unitsOwned = unitsOwned; }

    public BigDecimal getAvgPurchasePrice() { return avgPurchasePrice; }
    public void setAvgPurchasePrice(BigDecimal avgPurchasePrice) { this.avgPurchasePrice = avgPurchasePrice; }

    public BigDecimal getCurrentNAV() { return currentNAV; }
    public void setCurrentNAV(BigDecimal currentNAV) { this.currentNAV = currentNAV; }

    public BigDecimal getTotalInvested() { return totalInvested; }
    public void setTotalInvested(BigDecimal totalInvested) { this.totalInvested = totalInvested; }

    public BigDecimal getCurrentValue() { return currentValue; }
    public void setCurrentValue(BigDecimal currentValue) { this.currentValue = currentValue; }

    public BigDecimal getGainLoss() { return gainLoss; }
    public void setGainLoss(BigDecimal gainLoss) { this.gainLoss = gainLoss; }

    public BigDecimal getGainLossPercent() { return gainLossPercent; }
    public void setGainLossPercent(BigDecimal gainLossPercent) { this.gainLossPercent = gainLossPercent; }
}

