package sk.stuba.fei.uim.oop.assignment3.service;

import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import sk.stuba.fei.uim.oop.assignment3.controller.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotExists;
import sk.stuba.fei.uim.oop.assignment3.model.Products;

import java.util.List;

public interface IProductService {
    List<Products> getAll();
    Products create(ProductRequest request);
    Products getProductById(Long id) throws NotExists;
    void deleteProductById(Long id) throws NotExists;
    Products setAmount(Long id, Long amountRequest) throws  NotExists;
}
