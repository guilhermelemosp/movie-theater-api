package com.example.developer.MovieProjectApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.developer.MovieProjectApi.model.Film;

@Repository
public interface FilmRepo extends JpaRepository<Film, Long> {
    
}
