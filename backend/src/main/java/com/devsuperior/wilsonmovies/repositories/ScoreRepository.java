package com.devsuperior.wilsonmovies.repositories;


import com.devsuperior.wilsonmovies.entities.Score;
import com.devsuperior.wilsonmovies.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
