package com.example.developer.MovieProjectApi.model;

import lombok.Data;
import lombok.NonNull;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Films")
public class Film {

    @Id
    @GeneratedValue
    @Column(name = "movie_id")
    private Long id;

    @NonNull
    @Column(name = "title")
    private String title;

    @Column(name = "gender")
    private String gender;

    @Column(name = "minimum_age")
    private int minimumAge;

    @Column(name = "duration")
    private int duration;

    @Column(name = "value")
    private int value;

    @NonNull
    @Column(name = "tecnology_applied")
    private String tecnologyApplied;

    @Column(name = "available_seats")
    private int availableSeats;

    public Film() {
    }

    public Film(@NonNull String title, String gender, int minimumAge, int duration, int value,
    @NonNull String tecnologyApplied, int availableSeats) {

        this.title = title;
        this.gender = gender;
        this.minimumAge = minimumAge;
        this.duration = duration;
        this.value = value;
        this.tecnologyApplied = tecnologyApplied;
        this.availableSeats = availableSeats;
    }


}