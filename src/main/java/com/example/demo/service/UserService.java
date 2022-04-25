package com.example.demo.service;


import com.example.demo.entity.Basket;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.enums.Roles;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        Role userRole = roleRepository.findByRoles(Roles.CUSTOMER);
        user.setRoles(Collections.singletonList(userRole));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Basket userBasket = new Basket();
        user.setBasket(userBasket);
        return userRepository.save(user);

    }

    public User findByLogin(String login) {
        return userRepository.findByMail(login);
    }

    public User findByLoginAndPassword(String login, String password) {
        User user = findByLogin(login);
        if(user != null){
            if (passwordEncoder.matches(password,user.getPassword())){
                return user;
            }
        }
        return null;
    }
}
