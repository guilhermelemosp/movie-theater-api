package com.example.developer.MovieProjectApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.developer.MovieProjectApi.model.Film;

public interface FilmRepo extends JpaRepository<Film, Long> {
    
}
