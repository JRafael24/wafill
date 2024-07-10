package com.hachico.iwafill.Controllers;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hachico.iwafill.DTO.LoginRequest;
import com.hachico.iwafill.DTO.RegistrationRequest;
import com.hachico.iwafill.Model.Role;
import com.hachico.iwafill.Model.UserAuth;
import com.hachico.iwafill.Repository.RoleRepository;
import com.hachico.iwafill.Repository.UserAuthRepository;


@RestController
@RequestMapping("/api/v1/auth")
public class UserAuthController {
    
    @Autowired
    UserAuthRepository userAuthRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest){

        if(userAuthRepository.existsByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if(userAuthRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("An account is already registered in this email", HttpStatus.BAD_REQUEST);
        }

        UserAuth userAuth = new UserAuth(
            registrationRequest.getUsername(),
            registrationRequest.getEmail(),
            passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_ADMIN").get();
        userAuth.setRoles(Collections.singleton(role));

        userAuthRepository.save(userAuth);

        return new ResponseEntity<>("User registered sucessfully", HttpStatus.OK);

    }

    @PostMapping("/register/user")
    public ResponseEntity<?> registeruser(@RequestBody RegistrationRequest registrationRequest){

        if(userAuthRepository.existsByUsername(registrationRequest.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if(userAuthRepository.existsByEmail(registrationRequest.getEmail())){
            return new ResponseEntity<>("An account is already registered in this email", HttpStatus.BAD_REQUEST);
        }

        UserAuth userAuth = new UserAuth(
            registrationRequest.getUsername(),
            registrationRequest.getEmail(),
            passwordEncoder.encode(registrationRequest.getPassword())
        );

        Role role = roleRepository.findByName("ROLE_USER").get();
        userAuth.setRoles(Collections.singleton(role));

        userAuthRepository.save(userAuth);

        return new ResponseEntity<>("User registered sucessfully", HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        try{
            Authentication authentication = authenticationManager.authenticate(
             new UsernamePasswordAuthenticationToken(
                loginRequest.getUsernameOrEmail(),
                loginRequest.getPassword()
                )   
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
            }catch(Exception e){
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }
}
