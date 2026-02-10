// package com.fdapp.analysisbackend.model;

// import jakarta.persistence.*;
// import lombok.Data;
// import java.math.BigDecimal;
// import java.util.UUID;

// @Data
// @Entity
// @Table(name = "portfolio")
// public class Portfolio {

//     @Id
//     @GeneratedValue
//     private UUID id;

//     @ManyToOne
//     @JoinColumn(name = "userid" , nullable = false)
//     private User user;

//     @ManyToOne
//     @JoinColumn(name = "investmentproductid" , nullable = false)
//     private InvestmentProduct investmentProduct;

//     @Column(name = "unitsowned" , nullable = false)          // 🔥 REQUIRED
//     private BigDecimal unitsOwned;

//     @Column(name = "avgpurchaseprice" , nullable = false)    // 🔥 REQUIRED
//     private BigDecimal avgPurchasePrice;
// }


package com.fdapp.analysisbackend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "investmentproductid", nullable = false)
    private InvestmentProduct investmentProduct;

    @Column(name = "unitsowned", nullable = false)
    private BigDecimal unitsOwned;

    @Column(name = "avgpurchaseprice", nullable = false)
    private BigDecimal avgPurchasePrice;

    // ---------------- Getters and Setters ----------------

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public InvestmentProduct getInvestmentProduct() {
        return investmentProduct;
    }

    public void setInvestmentProduct(InvestmentProduct investmentProduct) {
        this.investmentProduct = investmentProduct;
    }

    public BigDecimal getUnitsOwned() {
        return unitsOwned;
    }

    public void setUnitsOwned(BigDecimal unitsOwned) {
        this.unitsOwned = unitsOwned;
    }

    public BigDecimal getAvgPurchasePrice() {
        return avgPurchasePrice;
    }

    public void setAvgPurchasePrice(BigDecimal avgPurchasePrice) {
        this.avgPurchasePrice = avgPurchasePrice;
    }
}
