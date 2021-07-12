package com.companyy;

import java.util.List;

public class JsonObj {
    private String id;
    private String status;
    private List<Trades> trades;
    private Commission commission;
    private String currency;
    private double payment;
    private double price;
    private int quantity;
    private String figi;
    private String instrumentType;
    private double date;

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    private String operationType;
    private boolean marginCall;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Trades> getTrades() {
        return trades;
    }

    public void setTrades(List<Trades> trades) {
        this.trades = trades;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public boolean isMarginCall() {
        return marginCall;
    }

    public void setMarginCall(boolean marginCall) {
        this.marginCall = marginCall;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("______Our Deal______\n");
        sb.append("id: " + getId() + "\n");
        sb.append("status: " + getStatus() + "\n");
        sb.append("trades: " + getTrades() + "\n");
        sb.append("commission: " + getCommission() + "\n");
        sb.append("currency: " + getCurrency() + "\n");
        sb.append("payment: " + getPayment() + "\n");
        sb.append("price: " + getPrice() + "\n");
        sb.append("quantity: " + getQuantity() + "\n");
        return sb.toString();
    }
}
