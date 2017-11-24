package com.plourlbackend.api.rest;

import com.plourlbackend.domain.Offer;
import com.plourlbackend.domain.Package;
import com.plourlbackend.exceptions.DataFormatException;
import com.plourlbackend.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.plourlbackend.api.rest.AbstractRestHandler.checkResourceFound;

public class OfferController {

    @Autowired
    private OfferService offerService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes =  {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"}
    )
    public Offer createOffer(@RequestBody Offer offer, HttpServletRequest request, HttpServletResponse response) {
        Offer offerCreated = this.offerService.createOffer(offer);
        response.setHeader("Location", request.getRequestURL().append("/").append(offerCreated.getId()).toString());
        return offerCreated;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Offer getOffer(@PathVariable("id") Long id,  HttpServletRequest request, HttpServletResponse response) throws Exception {
        Offer offer = this.offerService.getOffer(id);
        checkResourceFound(offer);
        return offer;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOffer(@PathVariable("id") Long id, @RequestBody Offer offer, HttpServletRequest request, HttpServletResponse response) {
        Offer currentOffer = this.offerService.getOffer(id);
        if (id != currentOffer.getId()) throw new DataFormatException("ID's no coinciden");
        this.offerService.updateOffer(offer);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOffer(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.offerService.getOffer(id));
        this.offerService.deleteOffer(id);
    }


}
