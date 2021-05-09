package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;

       /* Products a1 = new Products();
        a1.setSpecies("Dog");
        this.repository.save(a1);
        Animal a2 = new Animal();
        a2.setSpecies("Cat");
        this.repository.save(a2);*/
    }

    @Override
    public List<Products> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Products create(ProductRequest request) {
        Products newProduct = new Products();
        newProduct.setName(request.getName());
        newProduct.setDescription(request.getDescription());
        newProduct.setAmount(request.getAmount());
        newProduct.setUnit(request.getUnit());
        newProduct.setPrice(request.getPrice());
        return this.repository.save(newProduct);
    }
}
