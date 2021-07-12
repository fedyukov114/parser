package com.companyy;

public class Trades {
    private String tradeId;
    private String date;
    private double price;
    private int quantity;

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString(){
        return "tradeId: " + getTradeId() + ", date: " + getDate() + ", price: " + getPrice() + ", quantity: " + getQuantity() + "; \n";
    }
}
