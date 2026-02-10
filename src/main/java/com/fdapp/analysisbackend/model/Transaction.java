// package com.fdapp.analysisbackend.model;

// import com.fdapp.analysisbackend.enums.TxnType;
// import jakarta.persistence.*;
// import lombok.Data;
// import java.math.BigDecimal;
// import java.time.LocalDateTime;
// import java.util.UUID;

// @Data
// @Entity
// @Table(name = "transaction")
// public class Transaction {

//     @Id
//     @GeneratedValue
//     private UUID id;

//     @ManyToOne
//     @JoinColumn(name = "userid" , nullable = false)
//     private User user;

//     @ManyToOne
//     @JoinColumn(name = "investmentproductid" , nullable = false)
//     private InvestmentProduct investmentProduct;

//     @Enumerated(EnumType.STRING)
//     @Column(name = "txntype", nullable = false)       // 🔥 REQUIRED
//     private TxnType txnType;

//     @Column(name = "units" , nullable = false)
//     private BigDecimal units;

//     @Column(name = "navattxn" , nullable = false)       // 🔥 REQUIRED
//     private BigDecimal navAtTxn;

//     @Column(name = "txndate" , nullable = false)        // 🔥 REQUIRED
//     private LocalDateTime txnDate;
// }


package com.fdapp.analysisbackend.model;

import com.fdapp.analysisbackend.enums.TxnType;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "investmentproductid", nullable = false)
    private InvestmentProduct investmentProduct;

    @Enumerated(EnumType.STRING)
    @Column(name = "txntype", nullable = false)
    private TxnType txnType;

    @Column(name = "units", nullable = false)
    private BigDecimal units;

    @Column(name = "navattxn", nullable = false)
    private BigDecimal navAtTxn;

    @Column(name = "txndate", nullable = false)
    private LocalDateTime txnDate;

    // Getters and Setters
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

    public TxnType getTxnType() {
        return txnType;
    }

    public void setTxnType(TxnType txnType) {
        this.txnType = txnType;
    }

    public BigDecimal getUnits() {
        return units;
    }

    public void setUnits(BigDecimal units) {
        this.units = units;
    }

    public BigDecimal getNavAtTxn() {
        return navAtTxn;
    }

    public void setNavAtTxn(BigDecimal navAtTxn) {
        this.navAtTxn = navAtTxn;
    }

    public LocalDateTime getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(LocalDateTime txnDate) {
        this.txnDate = txnDate;
    }
}
