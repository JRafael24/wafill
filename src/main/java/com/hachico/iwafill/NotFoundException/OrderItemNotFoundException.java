package com.hachico.iwafill.NotFoundException;

public class OrderItemNotFoundException extends RuntimeException {
   public OrderItemNotFoundException(Long orderitemid){
        super("Could not found product with " + orderitemid);
    }

}

