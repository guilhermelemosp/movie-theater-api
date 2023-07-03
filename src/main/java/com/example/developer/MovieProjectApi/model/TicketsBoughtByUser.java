package com.example.developer.MovieProjectApi.model;
import jakarta.persistence.*;

@Entity
@Table(name = "TicketsBoughtByUser")
public class TicketsBoughtByUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Film movie;

    public TicketsBoughtByUser() {
    }

    public TicketsBoughtByUser(User user, Film movie) {
        this.user = user;
        this.movie = movie;
    }
}