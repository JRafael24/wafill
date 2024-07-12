package com.hachico.iwafill.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hachico.iwafill.Model.UserAuth;

public interface UserAuthRepository extends JpaRepository <UserAuth, Long>{
    Optional<UserAuth> findByEmail(String Email);
    Optional<UserAuth> findByUsername(String username);
    Optional<UserAuth> findByUsernameOrEmail(String email, String username);

    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);


}
