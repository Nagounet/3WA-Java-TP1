package com.example.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.model.Movie;

import lombok.extern.slf4j.Slf4j;

/**
 * Please add your description here.
 *
 * @author Pulse Innovations Ltd
 */

@Slf4j
@Controller
@RequestMapping("catalog")
public class MovieController
{

    @GetMapping("/movies")
    public String getMovies(Model model){

        Movie movie = new Movie();
        movie.setDescription( "Film d'action" );
        movie.setTitle( "Die Hard" );
        movie.setDuration( 120 );

        Movie movie2 = new Movie();
        movie2.setDescription( "Film fantastique" );
        movie2.setTitle( "Harry Potter" );
        movie2.setDuration( 180 );

        Movie movie3 = new Movie();
        movie3.setDescription( "Film thriller" );
        movie3.setTitle( "Usual Suspect" );
        movie3.setDuration( 100 );

        List<Movie> movies = new ArrayList<>();
        movies.add(movie);
        movies.add(movie2);
        movies.add(movie3);

        model.addAttribute( "movies", movies );

        return "home";
    }

    @GetMapping("/about")
    public String getAboutPage(){
        return "about";
    }

    @PostMapping("/movie")
    public String saveMovie(){

        return "about";
    }



}
