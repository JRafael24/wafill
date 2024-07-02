package com.hachico.iwafill.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hachico.iwafill.Model.OrderItem;
import com.hachico.iwafill.NotFoundException.OrderItemNotFoundException;
import com.hachico.iwafill.Repository.OrderItemRepository;

@RestController
public class OrderItemController {

    private final OrderItemRepository repo;

    public OrderItemController(OrderItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/orderitem")
    public List<OrderItem> getOrderItems() {
        return repo.findAll();
    }

    @GetMapping("/orderitem/{id}")
    public OrderItem getOrderItem(@PathVariable Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new OrderItemNotFoundException(id));
    }

    @PostMapping("/orderitem/new")
    public String addOrderItem(@RequestBody OrderItem newOrderItem) {
        repo.save(newOrderItem);
        return "A new order item has been added";
    }

    @DeleteMapping("/orderitem/delete/{id}")
    public String deleteOrderItem(@PathVariable Long id) {
        repo.deleteById(id);
        return "An order item has been deleted";
    }
}
