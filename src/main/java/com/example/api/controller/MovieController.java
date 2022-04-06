package com.example.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.api.model.Movie;
import com.example.api.repository.MovieRepository;

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
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public String getMovies(Model model){

        List<Movie> movies = movieRepository.findAll();
        model.addAttribute( "movies", movies );

        return "home";
    }


    @GetMapping("/about")
    public String getAboutPage(){
        return "about";
    }

    @PostMapping("/movie")
    public String saveMovie(@RequestParam String title , @RequestParam Integer duration , @RequestParam String desc ){
        Movie movie3 = new Movie();

        movie3.setDuration( duration );
        movie3.setTitle( title );
        movie3.setDescription( desc );

       movieRepository.save( movie3 );


        return "about";
    }



}
