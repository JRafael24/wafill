package com.hachico.iwafill.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hachico.iwafill.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);

    

}
