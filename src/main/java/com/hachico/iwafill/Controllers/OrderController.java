package com.hachico.iwafill.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hachico.iwafill.Model.Order;
import com.hachico.iwafill.NotFoundException.OrderNotFoundException;
import com.hachico.iwafill.Repository.OrderRepository;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderRepository repo;

    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    public List<Order> getOrders() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return repo.findById(id)
                   .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @PostMapping("/new")
    public String addOrder(@RequestBody Order newOrder) {
        repo.save(newOrder);
        return "A new order has been added";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        repo.deleteById(id);
        return "An order has been deleted";
    }
}
