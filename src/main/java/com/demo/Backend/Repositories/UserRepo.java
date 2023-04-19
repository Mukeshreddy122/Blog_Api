package com.demo.Backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Backend.Models.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
              