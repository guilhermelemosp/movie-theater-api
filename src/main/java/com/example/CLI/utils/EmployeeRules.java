package com.example.CLI.utils;

import com.example.developer.MovieProjectApi.model.Film;
import com.example.developer.MovieProjectApi.service.FilmService;


public class EmployeeRules {
    private FilmService filmService;
    private Film film;
    int totalTickets = 100;
    
    public void cadastrarFilme() {
    
        System.out.println("Adicionando filme...");
        System.out.println("Digite o nome do filme: ");            
    }

    public void excluirFilme() {
        if(totalTickets == 0) {
            System.out.println("Removendo filme...");
        } else {
            System.out.println("Não é possível remover o filme, pois já foram vendidos ingressos!");
        }
    }

    public void listarFilmes() {
        System.out.println("Listando todos os filmes...");

        filmService.getAllFilms();
    }
}
