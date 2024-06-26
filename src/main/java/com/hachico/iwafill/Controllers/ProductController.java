package com.hachico.iwafill.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hachico.iwafill.Model.Product;
import com.hachico.iwafill.NotFoundException.ProductNotFoundException;
import com.hachico.iwafill.Repository.ProductRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



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

    //http://127.0.0.1:8080/product/2
    @GetMapping("/product/{id}")
     public Product getProduct(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new ProductNotFoundException(id));
     }


    //http://127.0.0.1:8080/product/new
    @PostMapping("/product/new")   
    public String addProduct(@RequestBody Product newProduct){
        repo.save(newProduct);
        return "A new product is addeed. Yey!";
    }

    //UPDATE ENDPOINTS
    //http://127.0.0.1:8080/product/edit/1
    @PutMapping("/product/edit/{id}")
    public Product  updateProduct(@PathVariable Long id,
    @RequestBody Product newProduct){
        return repo.findById(id)
        .map(product ->{
            product.setProductName(newProduct.getProductName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            return repo.save(product);
        }).orElseGet(()->{
            return repo.save(newProduct);
        });
    }

    //DELETE ENDPOINTS
    //http://127.0.0.1:8080/product/delete/1
    @DeleteMapping("/product/delete/{id}")
    public String  deleteProduct(@PathVariable Long id){
        repo.deleteById(id);
        return "A product is deleted";
    }

}
