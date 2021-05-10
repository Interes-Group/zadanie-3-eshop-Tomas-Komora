package sk.stuba.fei.uim.oop.assignment3.controller;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.model.Products;

@Getter
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Long amount;
    private String unit;
    private Long price;

    public ProductResponse(Products p) {
        this.id = p.getId();
        this.name=p.getName();
        this.description=p.getDescription();
        this.amount=p.getAmount();
        this.unit=p.getUnit();
        this.price=p.getPrice();
    }

}
