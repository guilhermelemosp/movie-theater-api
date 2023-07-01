package com.example.developer.MovieProjectApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.developer.MovieProjectApi.model.Film;
import com.example.developer.MovieProjectApi.service.FilmService;

@RestController
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/films")
    public List<Film> getAllFilms(){
        return filmService.getAllFilms();
    }

    @GetMapping("/films/{id}")
    public Film getFilmById(@PathVariable Long id){
        return filmService.getFilmById(id);
    }

    @PostMapping("/addfilm")
    public Film addFilm(@RequestBody Film film){
        return filmService.addFilm(film);
    }

    
}
