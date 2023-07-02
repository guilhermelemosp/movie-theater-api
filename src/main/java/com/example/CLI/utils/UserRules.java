package com.example.CLI.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class UserRules {

    public String encryptPassword(String password) {
        try {
            // Cria uma instância do MessageDigest com o algoritmo MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // Converte a senha para um array de bytes
            byte[] passwordBytes = password.getBytes();
            
            // Calcula o hash da senha
            byte[] passwordHash = md.digest(passwordBytes);
            
            // Converte o hash para uma representação hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : passwordHash) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            // Retorna a senha criptografada em formato hexadecimal
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Caso ocorra algum erro na criptografia da senha
            // trata a exceção apropriadamente
            e.printStackTrace();
            return null;
        }
    }
}
