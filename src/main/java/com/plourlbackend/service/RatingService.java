package com.plourlbackend.service;

import com.plourlbackend.dao.RatingRepository;
import com.plourlbackend.domain.Rating;
import com.plourlbackend.domain.Tracking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService {

    private static final Logger log = LoggerFactory.getLogger(RatingService.class);

    @Autowired
    private RatingRepository ratingRepository;

    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating getRating(Long id) {
        return ratingRepository.findOne(id);
    }

    public Rating updateRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating  deleteRating(Long id) {
        Optional<Rating> ratingOptional = Optional.ofNullable(ratingRepository.findOne(id));
        if (ratingOptional.isPresent()) {
            ratingRepository.delete(ratingOptional.get().getId());
            return ratingOptional.get();
        } else {
            throw new IllegalArgumentException("El rating no existe");
        }
    }

}
