package com.example.developer.MovieProjectApi.model;

import lombok.Data;
import lombok.NonNull;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "username")
    private String username;

    @NonNull
    @Column(name = "password")
    private String password;
    
    @NonNull
    @Column(name = "role")
    private String role;
    
    @Column(name = "age")
    private int age;

    public User() {
    }

    public User(@NonNull String name, @NonNull String username, @NonNull String password, @NonNull String role, int age) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.age = age;
    }

}
