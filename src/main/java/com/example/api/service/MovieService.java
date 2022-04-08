package com.example.api.service;

import com.example.api.model.Movie;
import com.example.api.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public void saveMovie(String title, Integer duration, String description) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDuration(duration);
        movie.setDescription(description);
        try {
            movieRepository.save(movie);
        } catch (Exception e){
            log.error(e.getLocalizedMessage());
        }
    }

    public void updateMovie(Long id, @RequestParam String param, @RequestParam String update){
        try{
            Movie movieToUpdate = this.getMovie(id);
            if (param == "Duration"){
                movieToUpdate.setDuration(Integer.valueOf(update));
            }
            else if (param == "Title"){
                movieToUpdate.setTitle(update);
            }
            else{
                movieToUpdate.setDescription(update);
            }
            movieRepository.save(movieToUpdate);
        } catch (Exception e){
            log.error(e.getLocalizedMessage());
        }
    }

    public void deleteById(Long id) {
        try {
            movieRepository.deleteById(id);
        } catch (Exception e){
            log.error(e.getLocalizedMessage());
        }
    }

    public Movie getMovie(Long id) {
        try{
            return movieRepository.findById(id).get();
        } catch (Exception e){
            log.error(e.getLocalizedMessage());
            return null;
        }
    }

}