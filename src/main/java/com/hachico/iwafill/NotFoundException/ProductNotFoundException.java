package com.hachico.iwafill.NotFoundException;

public class ProductNotFoundException extends RuntimeException {
   public ProductNotFoundException(Long id){
        super("Could not found product with " + id);
    }

}
