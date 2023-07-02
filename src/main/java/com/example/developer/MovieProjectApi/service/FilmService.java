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

        public FilmService(FilmRepo filmRepo) {
                this.filmRepo = filmRepo;
        }

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
                Film existingFilm = filmRepo.findById(film.getId()).orElse(null);
                if (existingFilm != null) {
                        existingFilm.setTitle(film.getTitle());
                        existingFilm.setGender(film.getGender());
                        existingFilm.setGender(film.getGender());
                        existingFilm.setMinimumAge(film.getMinimumAge());
                        existingFilm.setDuration(film.getDuration());
                        filmRepo.save(existingFilm);
                        return existingFilm;
                }
                return null;
        }
        public String deleteFilm(Long id) {
                filmRepo.deleteById(id);
                return "Filme removido com sucesso!" + id;
        }

}


