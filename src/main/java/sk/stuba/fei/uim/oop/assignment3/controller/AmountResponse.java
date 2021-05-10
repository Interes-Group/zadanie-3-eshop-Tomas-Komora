package sk.stuba.fei.uim.oop.assignment3.controller;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.model.Products;

@Getter
public class AmountResponse {
    private Long amount;

    public AmountResponse(Products p) {
        this.amount=p.getAmount();
    }
}
