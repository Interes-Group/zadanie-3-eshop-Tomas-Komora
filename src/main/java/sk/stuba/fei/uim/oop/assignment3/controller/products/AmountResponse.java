package sk.stuba.fei.uim.oop.assignment3.controller.products;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.model.product.Products;

@Getter
public class AmountResponse {
    private Long amount;

    public AmountResponse(Products p) {
        this.amount=p.getAmount();
    }
}
