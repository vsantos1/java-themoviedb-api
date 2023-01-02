package com.vsantos1.themoviedb.controllers;

import com.vsantos1.themoviedb.mapper.ModelMapperUtils;
import com.vsantos1.themoviedb.models.Movie;
import com.vsantos1.themoviedb.services.MovieService;
import com.vsantos1.themoviedb.vo.MovieVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/movies")
    public ResponseEntity<Page<MovieVO>> getAllPaginated(@PageableDefault(size = 10, page = 0, value = 10, direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(movieService.findAll(pageable));
    }

    @GetMapping(value = "/movies/{movie_id}")
    public ResponseEntity<MovieVO> getMovieById(@PathVariable("movie_id") UUID id) {
        Optional<MovieVO> movie = movieService.find(id);
        if (movie.isEmpty()) {
            throw new ResourceNotFoundException("No records found for this id");
        }

        return ResponseEntity.status(HttpStatus.OK).body(movie.get());
    }

    @PostMapping(value = "/movies")
    public ResponseEntity<MovieVO> createNewMovie(@RequestBody MovieVO movieVO) {
        movieVO.setCreatedAt(new Date());
        movieVO.setUpdatedAt(new Date());
        Movie movie = new Movie();

        ModelMapperUtils.copyProperties(movieVO, movie);

        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.execute(movie));
    }

}
