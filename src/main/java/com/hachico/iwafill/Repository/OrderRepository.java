package com.hachico.iwafill.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hachico.iwafill.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
