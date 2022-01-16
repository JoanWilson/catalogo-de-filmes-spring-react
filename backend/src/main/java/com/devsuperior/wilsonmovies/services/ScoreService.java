package com.devsuperior.wilsonmovies.services;

import com.devsuperior.wilsonmovies.dto.MovieDTO;

import com.devsuperior.wilsonmovies.dto.ScoreDTO;
import com.devsuperior.wilsonmovies.entities.Movie;
import com.devsuperior.wilsonmovies.entities.Score;
import com.devsuperior.wilsonmovies.entities.User;
import com.devsuperior.wilsonmovies.repositories.MovieRepository;
import com.devsuperior.wilsonmovies.repositories.ScoreRepository;
import com.devsuperior.wilsonmovies.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail());
        if(user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0;
        for(Score s : movie.getScores()) {
            sum = sum + s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}
