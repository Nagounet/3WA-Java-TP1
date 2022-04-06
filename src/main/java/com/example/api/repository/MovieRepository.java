package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.model.Movie;

/**
 * Please add your description here.
 *
 * @author Pulse Innovations Ltd
 */

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>
{

}
