package com.hachico.iwafill.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hachico.iwafill.Model.Product;
import com.hachico.iwafill.Repository.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class ProductController {

    ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    //https://127.0.0.1/products
    //Get all products
    @GetMapping("/products")
    public List<Product> getProducts(){
        return repo.findAll();
    }

    // public Product getProduct(Long id){
    //     return repo.findById(id)
    // }


    //http://127.0.0.1:8080/product/new
    @PostMapping("/product/new")   
    public String addProduct(@RequestBody Product newProduct){
        repo.save(newProduct);
        return "A new product is addeed. Yey!";

    }
}
