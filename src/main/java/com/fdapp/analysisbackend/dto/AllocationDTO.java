// package com.fdapp.analysisbackend.dto;

// import lombok.Data;

// @Data
// public class AllocationDTO {
//     private String investmentType;   // EQUITY / DEBT etc
//     private double amount;
//     private double percentage;
// }


package com.fdapp.analysisbackend.dto;

public class AllocationDTO {

    private String investmentType;
    private double amount;
    private double percentage;

    // Getters and Setters
    public String getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(String investmentType) {
        this.investmentType = investmentType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
