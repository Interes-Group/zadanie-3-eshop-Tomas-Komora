package sk.stuba.fei.uim.oop.assignment3.controller.products;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.model.product.Products;

@Getter
public class UpdateProductResponse {
    private String name;
    private String description;

    public UpdateProductResponse(Products p){
        this.name=p.getName();
        this.description=p.getDescription();
    }
}
