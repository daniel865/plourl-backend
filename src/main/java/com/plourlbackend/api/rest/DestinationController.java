package com.plourlbackend.api.rest;

import com.plourlbackend.domain.Destination;
import com.plourlbackend.domain.User;
import com.plourlbackend.exceptions.DataFormatException;
import com.plourlbackend.service.DestinationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api/plourl/destinations")
@CrossOrigin(origins = "*")
public class DestinationController extends AbstractRestHandler {

    @Autowired
    private DestinationService destinationService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes =  {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"}
    )
    public Destination createDestination(@RequestBody Destination destination, HttpServletRequest request, HttpServletResponse response) {
        Destination destiantionCreated = this.destinationService.createDestination(destination);
        return destiantionCreated;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Destination getDestination(@PathVariable("id") Long id,  HttpServletRequest request, HttpServletResponse response) throws Exception {
        Destination destination = this.destinationService.getDestination(id);
        checkResourceFound(destination);
        return destination;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Destination updateDestination(@PathVariable("id") Long id, @RequestBody Destination destination, HttpServletRequest request, HttpServletResponse response) {
        Destination currentDestination = this.destinationService.getDestination(id);
        if (id != currentDestination.getId()) throw new DataFormatException("ID's no coinciden");
        return this.destinationService.updatedDestination(destination);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Destination deleteDestination(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.destinationService.getDestination(id));
        return this.destinationService.deleteDestination(id);
    }

}
