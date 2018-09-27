package pl.lukasz.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lukasz.shopping.model.Product;
import pl.lukasz.shopping.repository.ProductRepo;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/product/all")
    public List<Product> getAll(){
        return  productRepo.findAll();
    }

}
