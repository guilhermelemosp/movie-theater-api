package com.example.developer.MovieProjectApi.controller.utils;
import com.example.developer.MovieProjectApi.controller.FilmCLI;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    public void clientMenu() {
        FilmCLI filmCLI = new FilmCLI();
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
                    filmCLI.loginPage();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            
        }

    public void employeeMenu() {
        FilmCLI filmCLI = new FilmCLI();
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

                    break;
                case 2:
                    System.out.println("Removendo filme...");
                    break;
                case 3:
                    System.out.println("Listando todos os filmes...");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    filmCLI.loginPage();
                    break;
            }
            
        }
    }
