package com.example.CLI;
import java.util.Scanner;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.developer.MovieProjectApi.model.Film;
import com.example.developer.MovieProjectApi.service.FilmService;

@Component
public class StructureCLI {
    private Scanner scanner;
    private FilmService filmService;

    public StructureCLI(FilmService filmService) {
        this.filmService = filmService;
    }

    public void run() {
        loginPage();
    }

    public boolean loginPage() {
        this.scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao app de filmes!");
        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Login");
        System.out.println("2 - Cadastre-se");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("ÁREA DE LOGIN");
                this.login();
                break;
            case 2:
                System.out.println("ÁREA DE CADASTRO");
                this.cadastroPessoa();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        
        return true;
    }

    public void login() {
        scanner.nextLine();
        System.out.println("Digite seu nome de usuário: ");
        String username = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String password = scanner.nextLine();
        System.out.println("Logado com sucesso!");
        if(username.equals("e") || username.equals("c")) {
           switch (username) {
               case "c":
                   this.clientMenu();
                   break;
               case "e":
                   this.employeeMenu();
                   break;
               default:
                   System.out.println("Opção inválida!");
                   break;
           }
        }
    }
    

    public void cadastroPessoa() {
        scanner.nextLine();
        System.out.println("Digite seu nome: ");
        String name = scanner.nextLine();
        System.out.println("Digite seu nome de usuário: ");
        String username = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String password = scanner.nextLine();
        System.out.println("Digite sua idade: ");
        int age = scanner.nextInt();
        System.out.println("Digite 1 para cadastrar como usuário comum ou 2 para administrador: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Cadastrando usuário comum...");
                break;
            case 2:
                System.out.println("Cadastrando administrador...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        System.out.println("Usuário cadastrado com sucesso!");

        this.loginPage();
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
                this.loginPage();
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
                this.loginPage();
                break;
        }
            
    }
}
