package com.hachico.iwafill.NotFoundException;

public class OrderNotFoundException extends RuntimeException {
   public OrderNotFoundException(Long orderid){
        super("Could not found product with " + orderid);
    }

}
