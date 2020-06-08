package com.example;

import jakarta.nosql.mapping.Repository;

import java.util.List;

public interface UserRepository 
        extends Repository<User, String> 
{

    List<User> findByName(String name);

    List<User> findByUsername(String username);
    
    List<User> findByUsernameAndPassword(String username, String password);

    List<User> findByDescription(String description);
}
