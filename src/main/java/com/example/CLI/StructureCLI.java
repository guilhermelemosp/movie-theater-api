package com.example.CLI;
import java.util.Scanner;
import com.example.CLI.utils.Menu;

public class StructureCLI {
    private Scanner scanner;
    private Menu menu;

    public void run() {
        this.loginPage();
        this.menu = new Menu();

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
        menu = new Menu();
        scanner.nextLine();
        System.out.println("Digite seu nome de usuário: ");
        String username = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String password = scanner.nextLine();
        System.out.println("Logado com sucesso!");
        if(username.equals("e") || username.equals("c")) {
           switch (username) {
               case "c":
                   menu.clientMenu();
                   break;
               case "e":
                   menu.employeeMenu();
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
    
}
