package com.example.CLI.utils;
import java.util.Scanner;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.CLI.StructureCLI;
import com.example.developer.MovieProjectApi.model.Film;
import com.example.developer.MovieProjectApi.service.FilmService;

@Component
public class Menu {

    private Scanner scanner;
    private FilmService filmService;
    private StructureCLI structureCLI;

    public Menu(FilmService filmService, StructureCLI structureCLI) {
        this.filmService = filmService;
        this.structureCLI = structureCLI;
    }



    public void clientMenu() {
        this.scanner = new Scanner(System.in);
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Comprar Ingressos");
        System.out.println("2 - Filmes em cartaz para você");
        System.out.println("3 - Ingressos comprados");
        System.out.println("6 - Sair para login");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Comprando ingressos...");                    
                break;
            case 2:
                System.out.println("Filmes em cartaz para você...");
                break;
            case 3:
                System.out.println("Ingressos comprados...");
                break;
            case 6:
                System.out.println("Saindo para login...");
                structureCLI.loginPage();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
            
    }

    public void cadastraFilme() {    
        scanner.nextLine();
        System.out.println("Digite o título do filme: ");
        String title = scanner.nextLine();
        System.out.println("Digite o gênero do filme: ");
        String gender = scanner.nextLine();
        System.out.println("Digite a faixa etária do filme: ");
        int ageRating = scanner.nextInt();
        System.out.println("Digite a duração do filme: ");
        int duration = scanner.nextInt();
        System.out.println("Digite valor do ingresso: ");
        int ticketPrice = scanner.nextInt();
        System.out.println("Digite a tecnologia aplicada no filme: ");
        String technology = scanner.nextLine();
        System.out.println("Digite a quantidade de assentos disponíveis: ");
        int availableSeats = scanner.nextInt();
        
        Film film = new Film(title, gender, ageRating, duration, ticketPrice, technology, availableSeats);
        filmService.addFilm(film);
  
    }


    public void employeeMenu() {
        this.scanner = new Scanner(System.in);
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Cadastrar filme");
        System.out.println("2 - Excluir filme");
        System.out.println("3 - Listar filmes");
        System.out.println("4 - Sair para login");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Adicionando filme...");
                cadastraFilme();
                break;
            case 2:
            System.out.println("Removendo filme...");
            break;
            case 3:
                System.out.println("Listando todos os filmes...");
                break;
            case 4:
                System.out.println("Saindo...");
                structureCLI.loginPage();
                break;
        }
            
    }
}
