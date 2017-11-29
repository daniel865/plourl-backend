package com.plourlbackend.api.rest;

import com.plourlbackend.domain.Availability;
import com.plourlbackend.domain.User;
import com.plourlbackend.exceptions.DataFormatException;
import com.plourlbackend.service.AvailabilityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api/plourl/availabilities")
@CrossOrigin(origins = "*")
public class AvailabilityController extends AbstractRestHandler  {
    
    @Autowired
    private AvailabilityService availabilityService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes =  {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"}
    )
    public Availability createAvailability(@RequestBody Availability availability, HttpServletRequest request, HttpServletResponse response) {
        Availability availabilityCreated = this.availabilityService.createAvailability(availability);
        response.setHeader("Location", request.getRequestURL().append("/").append(availabilityCreated.getId()).toString());
        return availabilityCreated;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Availability getAvailability(@PathVariable("id") Long id,  HttpServletRequest request, HttpServletResponse response) throws Exception {
        Availability availability = this.availabilityService.getAvailability(id);
        checkResourceFound(availability);
        return availability;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Availability  updateAvailability(@PathVariable("id") Long id, @RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        Availability currentAvailability= this.availabilityService.getAvailability(id);
        if (id != currentAvailability.getId()) throw new DataFormatException("ID's no coinciden");
        return this.availabilityService.updateAvailability(currentAvailability);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Availability  deleteAvailability(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.availabilityService.getAvailability(id));
        return this.availabilityService.deleteAvailability(id);
    }
}
