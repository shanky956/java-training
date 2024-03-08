package com.org.altech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.altech.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
