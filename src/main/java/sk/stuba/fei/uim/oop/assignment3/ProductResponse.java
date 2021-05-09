package sk.stuba.fei.uim.oop.assignment3;

import lombok.Getter;

@Getter
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private int amount;
    private String unit;
    private int price;

    public ProductResponse(Products p) {
        this.id = p.getId();
        this.name=p.getName();
        this.description=p.getDescription();
        this.amount=p.getAmount();
        this.unit=p.getUnit();
        this.price=p.getPrice();
    }
}
