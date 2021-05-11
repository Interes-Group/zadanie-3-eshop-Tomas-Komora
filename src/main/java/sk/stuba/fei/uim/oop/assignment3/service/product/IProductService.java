package sk.stuba.fei.uim.oop.assignment3.service.product;

import sk.stuba.fei.uim.oop.assignment3.controller.products.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.controller.products.UpdateProductResponse;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotExists;
import sk.stuba.fei.uim.oop.assignment3.model.product.Products;

import java.util.List;

public interface IProductService {
    List<Products> getAll();
    Products create(ProductRequest request);
    Products getProductById(Long id) throws NotExists;
    void deleteProductById(Long id) throws NotExists;
    Products setAmount(Long id, Long amountRequest) throws  NotExists;
    Products update(Long id, String name, String description) throws NotExists;
}
