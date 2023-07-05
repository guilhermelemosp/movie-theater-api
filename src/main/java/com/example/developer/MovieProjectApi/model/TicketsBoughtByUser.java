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
    private Film film;

    @Column(name = "tickets_quantity")
    private int ticketsQuantity;

    public TicketsBoughtByUser() {
    }

    public TicketsBoughtByUser(User user, Film film, int ticketsQuantity) {
        this.user = user;
        this.film = film;
        this.ticketsQuantity = ticketsQuantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getTicketsQuantity() {
        return ticketsQuantity;
    }

    public void setTicketsQuantity(int ticketsQuantity) {
        this.ticketsQuantity = ticketsQuantity;
    }
}