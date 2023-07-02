package com.example.developer.MovieProjectApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.developer.MovieProjectApi.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
