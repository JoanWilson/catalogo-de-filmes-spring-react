package com.devsuperior.wilsonmovies.repositories;

import com.devsuperior.wilsonmovies.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
