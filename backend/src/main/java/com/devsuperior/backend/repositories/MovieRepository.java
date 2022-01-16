package com.devsuperior.backend.repositories;

import com.devsuperior.backend.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
