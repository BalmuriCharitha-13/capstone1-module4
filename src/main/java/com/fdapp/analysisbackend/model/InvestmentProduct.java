// package com.fdapp.analysisbackend.model;

// import com.fdapp.analysisbackend.enums.InvestmentType;
// import com.fdapp.analysisbackend.enums.RiskLevel;
// import jakarta.persistence.*;
// import lombok.Data;
// import java.math.BigDecimal;
// import java.util.UUID;

// @Data
// @Entity
// @Table(name = "investmentproduct")
// public class InvestmentProduct {

//     @Id
//     @GeneratedValue
//     private UUID id;

//     @Column(name = "name", nullable = false)
//     private String name;

//     @Enumerated(EnumType.STRING)
//     @Column(name = "type", nullable = false)
//     private InvestmentType type;

//     @Enumerated(EnumType.STRING)
//     @Column(name = "risklevel", nullable = false)
//     private RiskLevel riskLevel;

//     @Column(name = "mininvestment", nullable = false)
//     private BigDecimal minInvestment;

//     @Column(name = "expectedreturnrate", nullable = false)
//     private BigDecimal expectedReturnRate;

//     @Column(name = "currentnav", nullable = false)   // 🔥 THIS FIXES YOUR ERROR
//     private BigDecimal currentNAV;

//     @Column(name = "isactive", nullable = false)
//     private Boolean isActive;
// }


package com.fdapp.analysisbackend.model;

import com.fdapp.analysisbackend.enums.InvestmentType;
import com.fdapp.analysisbackend.enums.RiskLevel;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "investmentproduct")
public class InvestmentProduct {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private InvestmentType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "risklevel", nullable = false)
    private RiskLevel riskLevel;

    @Column(name = "mininvestment", nullable = false)
    private BigDecimal minInvestment;

    @Column(name = "expectedreturnrate", nullable = false)
    private BigDecimal expectedReturnRate;

    @Column(name = "currentnav", nullable = false)
    private BigDecimal currentNAV;

    @Column(name = "isactive", nullable = false)
    private Boolean isActive;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InvestmentType getType() {
        return type;
    }

    public void setType(InvestmentType type) {
        this.type = type;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }

    public BigDecimal getMinInvestment() {
        return minInvestment;
    }

    public void setMinInvestment(BigDecimal minInvestment) {
        this.minInvestment = minInvestment;
    }

    public BigDecimal getExpectedReturnRate() {
        return expectedReturnRate;
    }

    public void setExpectedReturnRate(BigDecimal expectedReturnRate) {
        this.expectedReturnRate = expectedReturnRate;
    }

    public BigDecimal getCurrentNAV() {
        return currentNAV;
    }

    public void setCurrentNAV(BigDecimal currentNAV) {
        this.currentNAV = currentNAV;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
