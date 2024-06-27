package com.hachico.iwafill.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hachico.iwafill.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
