// package com.fdapp.analysisbackend.dto;

// import lombok.Data;

// @Data
// public class GainLossDTO {
//     private String investmentName;
//     private double investedAmount;
//     private double currentValue;
//     private double gainLoss;
//     private double returnPercent;
// }


package com.fdapp.analysisbackend.dto;

public class GainLossDTO {

    private String investmentName;
    private double investedAmount;
    private double currentValue;
    private double gainLoss;
    private double returnPercent;
    private double unitsOwned;  // add this

    // Getters and Setters
    public String getInvestmentName() { return investmentName; }
    public void setInvestmentName(String investmentName) {this.investmentName = investmentName;}

    public double getInvestedAmount() {return investedAmount;}
    public void setInvestedAmount(double investedAmount) {this.investedAmount = investedAmount;}

    public double getCurrentValue() {return currentValue;}
    public void setCurrentValue(double currentValue) {this.currentValue = currentValue;}

    public double getGainLoss() {return gainLoss;}
    public void setGainLoss(double gainLoss) {this.gainLoss = gainLoss;}

    public double getReturnPercent() {return returnPercent;}
    public void setReturnPercent(double returnPercent) {this.returnPercent = returnPercent;}

    public double getUnitsOwned() { return unitsOwned; }
    public void setUnitsOwned(double unitsOwned) { this.unitsOwned = unitsOwned; }
}
