package sk.stuba.fei.uim.oop.assignment3.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotExists;
import sk.stuba.fei.uim.oop.assignment3.model.product.ProductRepository;
import sk.stuba.fei.uim.oop.assignment3.controller.products.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.model.product.Products;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
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

    @Override
    public Products getProductById(Long id) throws NotExists {
        Optional<Products> products= repository.findById(id);
        if(products.isEmpty()){
            throw new NotExists();
        }else{
            return products.get();
        }
    }

    @Override
    public void deleteProductById(Long id) throws NotExists {
        Optional<Products> products= repository.findById(id);
        if(products.isEmpty()){
            throw new NotExists();
        }else{
           repository.deleteById(id);
        }
    }

    @Override
    public Products setAmount(Long id, Long amountRequest)throws NotExists{
        Optional<Products> products= repository.findById(id);
        if(products.isEmpty()){
            throw new NotExists();
        }else{
            products.get().setAmount(products.get().getAmount()+ amountRequest);
            return products.get();
        }
    }

    @Override
    public Products update(Long id,  String name, String description) throws NotExists{
        Optional<Products> products= repository.findById(id);
        if(products.isEmpty()){
            throw new NotExists();
        }else {
            if(description==null && name==null){
            }
            else if(name==null){
                products.get().setDescription(description);
            }else if(description==null){
                products.get().setName(name);
            }
            else {
                products.get().setName(name);
                products.get().setDescription(description);
            }
            return products.get();

        }

    }

}
