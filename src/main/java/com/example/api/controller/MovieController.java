package com.example.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import com.example.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public String getMovies(Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "home";
    }

    @GetMapping("/manageMovies")
    public String getManageMovies(Model model){
        model.addAttribute("movies", movieService.findAll());
        return "manageMovies";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    @PostMapping("/addMovie")
    public String addMovie(@RequestParam String title, @RequestParam Integer duration, @RequestParam String description) {
        movieService.saveMovie(title,duration,description);
        return "redirect:/catalog/manageMovies";
    }

    @DeleteMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteById(id);
        return "redirect:/catalog/manageMovies";
    }

    @PatchMapping("/updateMovie/{id}")
    public String updateMovie(@PathVariable Long id, @RequestParam String param, @RequestParam String update) {
        movieService.updateMovie(id, param, update);
        return "redirect:/catalog/manageMovies";
    }


}
