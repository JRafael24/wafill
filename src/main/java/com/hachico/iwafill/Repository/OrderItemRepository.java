package com.hachico.iwafill.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hachico.iwafill.Model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}