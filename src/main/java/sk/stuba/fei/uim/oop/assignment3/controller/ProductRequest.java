package sk.stuba.fei.uim.oop.assignment3.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    private String name;
    private String description;
    private Long amount;
    private String unit;
    private Long price;
}
