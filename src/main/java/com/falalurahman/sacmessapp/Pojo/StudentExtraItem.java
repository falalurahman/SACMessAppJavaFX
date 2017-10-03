package com.falalurahman.sacmessapp.Pojo;

import java.util.Date;

public class StudentExtraItem {
    private String Name;
    private Date ItemDate;
    private Double Quantity;
    private Double Price;

    public StudentExtraItem() {
    }

    public StudentExtraItem(String name, Date itemDate, Double quantity, Double price) {
        Name = name;
        ItemDate = itemDate;
        Quantity = quantity;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getItemDate() {
        return ItemDate;
    }

    public void setItemDate(Date itemDate) {
        ItemDate = itemDate;
    }

    public Double getQuantity() {
        return Quantity;
    }

    public void setQuantity(Double quantity) {
        Quantity = quantity;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }
}
