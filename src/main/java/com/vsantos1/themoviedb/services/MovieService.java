package com.vsantos1.themoviedb.services;

import com.vsantos1.themoviedb.mapper.ModelMapperUtils;
import com.vsantos1.themoviedb.models.Movie;
import com.vsantos1.themoviedb.repositories.MovieRepository;
import com.vsantos1.themoviedb.vo.MovieVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    private MovieVO convertToVO(Movie movie) {
        return ModelMapperUtils.parseObject(movie, MovieVO.class);
    }

    public MovieVO execute(Movie movie) {
        return convertToVO(movieRepository.save(movie));
    }

    public Page<MovieVO> findAll(Pageable pageable) {
        Page<Movie> page = movieRepository.findAll(pageable);
        return page.map(this::convertToVO);
    }

    public Optional<MovieVO> find(UUID id) {

        return movieRepository.findById(id).map(this::convertToVO);
    }

    public void deleteById(UUID id) {
        movieRepository.deleteById(id);
    }


}
