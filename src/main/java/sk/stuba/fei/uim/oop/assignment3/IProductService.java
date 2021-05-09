package sk.stuba.fei.uim.oop.assignment3;

import java.util.List;

public interface IProductService {
    List<Products> getAll();
    Products create(ProductRequest request);
}
