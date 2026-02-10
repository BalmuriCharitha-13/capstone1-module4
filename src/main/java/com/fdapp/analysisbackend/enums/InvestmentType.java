package com.fdapp.analysisbackend.enums;

public enum InvestmentType {
    Stock("Stock"),
    Mutual_Fund("Mutual Fund"),
    Bond("Bond"),
    ETF("ETF"),
    REIT("REIT");

    private final String dbValue;

    InvestmentType(String dbValue) { this.dbValue = dbValue; }

    public String getDbValue() { return dbValue; }

    public static InvestmentType fromDbValue(String dbValue) {
        for (InvestmentType type : values()) {
            if (type.dbValue.equals(dbValue)) return type;
        }
        throw new IllegalArgumentException("Unknown value: " + dbValue);
    }
}

