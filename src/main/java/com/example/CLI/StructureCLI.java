package com.example.CLI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.CLI.utils.FilmRules;
import com.example.CLI.utils.UserRules;
import com.example.developer.MovieProjectApi.model.Film;
import com.example.developer.MovieProjectApi.model.User;
import com.example.developer.MovieProjectApi.service.FilmService;
import com.example.developer.MovieProjectApi.service.UserService;

@Component
public class StructureCLI {
    private Scanner scanner;
    private FilmService filmService;
    private UserService userService;
    private FilmRules filmRules;
    private UserRules userRules;

    public StructureCLI(FilmService filmService, FilmRules filmRules, UserRules userRules, UserService userService) {
        this.filmService = filmService;
        this.userService = userService;
        this.filmRules = filmRules;
        this.userRules = userRules;
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

     public boolean authenticateUser(String username, String password) {
            List<User> users = userService.getAllUsers();
            for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            return true;
            }
            }
            return false;
        }

    public void login() {
        scanner.nextLine();
        System.out.println("Digite seu nome de usuário: ");
        String username = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String password = scanner.nextLine();
        
        User user = userService.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            if (user.getRole().equals("Administrador")) {
                employeeMenu();
                return;
            } else if (user.getRole().equals("Cliente")) {
                clientMenu();
                return;
            }
        }
        
        System.out.println("Usuário ou senha inválidos!");
    }
    

    public void cadastroPessoa() {
        scanner.nextLine();
        System.out.println("Digite seu nome: ");
        String name = scanner.nextLine();

        System.out.println("Digite seu nome de usuário: ");
        String username = scanner.nextLine();

        System.out.println("Digite sua senha: ");
        String password = scanner.nextLine();

        String passwordEncrypted = userRules.encryptPassword(password);

        System.out.println("Digite sua idade: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Selecione a opção de cadastro: ");
        System.out.println("1 - Administrador");
        System.out.println("2 - Cliente");
        int optionNumber = scanner.nextInt();
        scanner.nextLine();
        String option = "";
        switch (optionNumber) {
            case 1:
                option = "Cliente";
                System.out.println("Cadastrando usuário comum...");
                break;
            case 2:
                option = "Administrador";
                System.out.println("Cadastrando administrador...");
                break;
            default:
                System.out.println("Opção inválida!");
                this.cadastroPessoa();
                break;
        }
        User user = new User(name, username, passwordEncrypted, option, age);
        userService.addUser(user);
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
        String rulesGender[] = this.filmRules.getGender();
        String rulesTecnology[] = this.filmRules.getTecnologyApplied();
        int rulesMinimumAge[] = this.filmRules.getMinimumAge();
        int rulesAvailableSeats = this.filmRules.getAvailableSeats();
        int rulesValue[] = this.filmRules.getValue();

        scanner.nextLine();
        System.out.println("Digite o título do filme: ");
        String title = scanner.nextLine();

        System.out.println("Digite o gênero do filme: ");
        for(int i = 0; i < rulesGender.length; i++) {
            System.out.println((i + 1) + " - " + rulesGender[i]);
        }
        int genreOption = scanner.nextInt();
        String gender = rulesGender[genreOption - 1];

        System.out.println("Digite a faixa etária do filme: ");
         for(int i = 0; i < rulesMinimumAge.length; i++) {
            System.out.println((i + 1) + " - " + rulesMinimumAge[i]);
        }
        int ageOption = scanner.nextInt();
        int minimumAge = rulesMinimumAge[ageOption - 1];

        System.out.println("Digite a duração do filme: ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite valor do ingresso: ");
           for(int i = 0; i < rulesValue.length; i++) {
            System.out.println((i + 1) + " - " + rulesValue[i]);
        }
        int value = scanner.nextInt();
        int ticketPrice = rulesValue[value - 1];
        
        scanner.nextLine();

        System.out.println("Digite a tecnologia aplicada no filme: ");
           for(int i = 0; i < rulesTecnology.length; i++) {
            System.out.println((i + 1) + " - " + rulesTecnology[i]);
        }
        int tecnologyOption = scanner.nextInt();
        String technology = rulesTecnology[tecnologyOption - 1];

        System.out.println("Quantidade padrão de assentos: " + rulesAvailableSeats);
        int availableSeats = rulesAvailableSeats;
        scanner.nextLine();
        System.out.println("Pressione 1 para confirmar os 100 lugares. Caso queira voltar para o Menu principal, pressione 2");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                scanner.nextLine();
                break;
            case 2:
                System.out.println("Voltando para o Menu principal...");
                this.employeeMenu();
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        Film film = new Film(title, gender, minimumAge, duration, ticketPrice, technology, availableSeats);
        filmService.addFilm(film);
        System.out.println("Filme cadastrado com sucesso!");
        this.employeeMenu();
    }

    public void deleteFilm() {
        scanner.nextLine();
        System.out.println("Digite o nome do filme que deseja remover: ");
        String name = scanner.nextLine().toLowerCase();

        List<Film> films = filmService.getAllFilms();

        List<Film> matchingFilms = new ArrayList<>();
        for (Film film : films) {
            String filmTitle = film.getTitle().toLowerCase();
            if (filmTitle.contains(name)) {
                matchingFilms.add(film);
            }
        }

        if (matchingFilms.isEmpty()) {
            System.out.println("Nenhum filme encontrado com esse nome.");
        } else {
            System.out.println("Foram encontrados os seguintes filmes com esses atributos:");
            for (int i = 0; i < matchingFilms.size(); i++) {
                Film film = matchingFilms.get(i);
                System.out.println((i + 1) + " - " + film.getTitle());
            }

            System.out.println("Digite o número do filme que deseja remover: ");
            int filmIndex = scanner.nextInt();

            if (filmIndex >= 1 && filmIndex <= matchingFilms.size()) {
                Film selectedFilm = matchingFilms.get(filmIndex - 1);
                if (selectedFilm.getAvailableSeats() == 100) {
                    confirmDeleteFilm(selectedFilm);
                } else {
                    System.out.println("OPÇÃO INVÁLIDA - OS INGRESSOS JÁ COMEÇARAM A SER VENDIDOS!");
                }
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    private void confirmDeleteFilm(Film film) {
        System.out.println("Tem certeza que deseja remover o filme \"" + film.getTitle() + "\"?");
        System.out.println("Digite 1 para confirmar ou 2 para cancelar");
        int confirmation = scanner.nextInt();

        if (confirmation == 1) {
            long filmId = film.getId();
            filmService.deleteFilm(filmId);
            System.out.println("O filme foi removido com sucesso!");
        } else {
            System.out.println("Remoção do filme cancelada!");
        }
        this.employeeMenu();
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
            this.deleteFilm();
            this.employeeMenu();
            break;
            case 3:
                System.out.println("Buscando...");
                this.filmRules.filmList();
                this.employeeMenu();
                break;
            case 4:
                this.loginPage();
                break;
        }
            
    }
}
