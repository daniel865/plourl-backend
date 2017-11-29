package com.plourlbackend.dao;

import com.plourlbackend.domain.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RatingRepository extends CrudRepository<Rating, Long>, PagingAndSortingRepository<Rating, Long> {
}
