package sk.stuba.fei.uim.oop.assignment3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotExists;
import sk.stuba.fei.uim.oop.assignment3.model.Products;
import sk.stuba.fei.uim.oop.assignment3.service.IProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping()
    @ResponseBody
    public List<ProductResponse> getAllProducts() {
        return this.service.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseBody
    public ProductResponse addAnimal(@RequestBody ProductRequest request) {
        return new ProductResponse(this.service.create(request));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ProductResponse>  getProductById(@PathVariable("id") Long id){
        try{
            Products products = service.getProductById(id);
            return new ResponseEntity<>(new ProductResponse(products) , HttpStatus.OK);
        }catch(NotExists notExists){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id){
        try{
            service.deleteProductById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(NotExists notExists){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/amount")
    @ResponseBody
    public ResponseEntity<AmountResponse> getAmount(@PathVariable("id") Long id){
        try{
            Products products = service.getProductById(id);
            return new ResponseEntity<>(new AmountResponse(products), HttpStatus.OK);
        }catch(NotExists notExists){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/amount")
    @ResponseBody
    public ResponseEntity<AmountResponse> setAmount(@PathVariable("id") Long id,@RequestBody AmountRequest amount){
        try{
            Long amountValue = amount.getAmount();
            Products products= service.setAmount(id , amountValue);
            return new ResponseEntity<>(new AmountResponse(products), HttpStatus.OK);
        }catch(NotExists notExists){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
