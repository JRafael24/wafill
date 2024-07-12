package com.hachico.iwafill.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hachico.iwafill.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
