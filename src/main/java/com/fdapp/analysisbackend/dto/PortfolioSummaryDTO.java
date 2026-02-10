// package com.fdapp.analysisbackend.dto;

// public class PortfolioSummaryDTO {

//     private double totalInvested;
//     private double currentValue;
//     private double totalGainLoss;
//     private double absoluteReturnPercent;
//     private double annualizedReturnPercent;

//     // Getters and Setters
//     public double getTotalInvested() {
//         return totalInvested;
//     }

//     public void setTotalInvested(double totalInvested) {
//         this.totalInvested = totalInvested;
//     }

//     public double getCurrentValue() {
//         return currentValue;
//     }

//     public void setCurrentValue(double currentValue) {
//         this.currentValue = currentValue;
//     }

//     public double getTotalGainLoss() {
//         return totalGainLoss;
//     }

//     public void setTotalGainLoss(double totalGainLoss) {
//         this.totalGainLoss = totalGainLoss;
//     }

//     public double getAbsoluteReturnPercent() {
//         return absoluteReturnPercent;
//     }

//     public void setAbsoluteReturnPercent(double absoluteReturnPercent) {
//         this.absoluteReturnPercent = absoluteReturnPercent;
//     }

//     public double getAnnualizedReturnPercent() {
//         return annualizedReturnPercent;
//     }

//     public void setAnnualizedReturnPercent(double annualizedReturnPercent) {
//         this.annualizedReturnPercent = annualizedReturnPercent;
//     }
// }


package com.fdapp.analysisbackend.dto;

import java.util.List;

public class PortfolioSummaryDTO {

    private double totalInvested;
    private double currentValue;
    private double totalGainLoss;
    private double absoluteReturnPercent;
    private double annualizedReturnPercent;

    // New field for per-product breakdown
    private List<GainLossDTO> portfolioItems;

    // Getters and setters
    public double getTotalInvested() { return totalInvested; }
    public void setTotalInvested(double totalInvested) { this.totalInvested = totalInvested; }

    public double getCurrentValue() { return currentValue; }
    public void setCurrentValue(double currentValue) { this.currentValue = currentValue; }

    public double getTotalGainLoss() { return totalGainLoss; }
    public void setTotalGainLoss(double totalGainLoss) { this.totalGainLoss = totalGainLoss; }

    public double getAbsoluteReturnPercent() { return absoluteReturnPercent; }
    public void setAbsoluteReturnPercent(double absoluteReturnPercent) { this.absoluteReturnPercent = absoluteReturnPercent; }

    public double getAnnualizedReturnPercent() { return annualizedReturnPercent; }
    public void setAnnualizedReturnPercent(double annualizedReturnPercent) { this.annualizedReturnPercent = annualizedReturnPercent; }

    public List<GainLossDTO> getPortfolioItems() { return portfolioItems; }
    public void setPortfolioItems(List<GainLossDTO> portfolioItems) { this.portfolioItems = portfolioItems; }
}
