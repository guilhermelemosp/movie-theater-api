package com.example.developer.MovieProjectApi.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.developer.MovieProjectApi.model.TicketsBoughtByUser;
import com.example.developer.MovieProjectApi.model.User;


@Repository
public interface TicketsRepo extends JpaRepository<TicketsBoughtByUser, Long> {
    List<TicketsBoughtByUser> findByUser(User user);
    List<TicketsBoughtByUser> findByFilmId(Long filmId);
}


