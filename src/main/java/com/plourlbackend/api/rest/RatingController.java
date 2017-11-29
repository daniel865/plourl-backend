package com.plourlbackend.api.rest;

import com.plourlbackend.domain.Rating;
import com.plourlbackend.domain.Tracking;
import com.plourlbackend.exceptions.DataFormatException;
import com.plourlbackend.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api/plourl/rating")
@CrossOrigin(origins = "*")
public class RatingController extends AbstractRestHandler {

    @Autowired
    private RatingService ratingService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes =  {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"}
    )
    public Rating createRating(@RequestBody Rating rating, HttpServletRequest request, HttpServletResponse response) {
        Rating ratingCreated = this.ratingService.createRating(rating);
        response.setHeader("Location", request.getRequestURL().append("/").append(ratingCreated.getId()).toString());
        return ratingCreated;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Rating getRating(@PathVariable("id") Long id,  HttpServletRequest request, HttpServletResponse response) throws Exception {
        Rating rating = this.ratingService.getRating(id);
        checkResourceFound(rating);
        return rating;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Rating updateRating(@PathVariable("id") Long id, @RequestBody Rating rating, HttpServletRequest request, HttpServletResponse response) {
        Rating currentRating = this.ratingService.getRating(id);
        if (id != currentRating.getId()) throw new DataFormatException("ID's no coinciden");
        return this.ratingService.updateRating(rating);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Rating deleteRating(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.ratingService.getRating(id));
        return this.ratingService.deleteRating(id);
    }

}
