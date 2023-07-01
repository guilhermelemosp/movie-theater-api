package com.example.developer.MovieProjectApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.developer.MovieProjectApi.model.Film;
import com.example.developer.MovieProjectApi.repository.FilmRepo;

@Service
public class FilmService {

        @Autowired
        private FilmRepo filmRepo;

        public List<Film> getAllFilms() {
                return filmRepo.findAll();
        }

        public Film getFilmById(Long id) {
                return filmRepo.findById(id).orElse(null);
        }

        public Film addFilm(Film film) {
                return filmRepo.save(film);
        }

        public Film updateFilm(Film film) {
                return filmRepo.save(film);
        }
}
