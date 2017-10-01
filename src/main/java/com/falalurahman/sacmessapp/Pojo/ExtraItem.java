package com.falalurahman.sacmessapp.Pojo;

public class ExtraItem {
    private String ItemCode;
    private String Name;
    private Double Price;

    public ExtraItem() {
    }

    public ExtraItem(String itemCode, String name, Double price) {
        ItemCode = itemCode;
        Name = name;
        Price = price;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }
}
