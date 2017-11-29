package com.plourlbackend.api.rest;

import com.plourlbackend.domain.Destination;
import com.plourlbackend.domain.Tracking;
import com.plourlbackend.exceptions.DataFormatException;
import com.plourlbackend.service.DestinationService;
import com.plourlbackend.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api/plourl/tracking")
@CrossOrigin(origins = "*")
public class TrackingController extends AbstractRestHandler {

    @Autowired
    private TrackingService trackingService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes =  {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"}
    )
    public Tracking createTracking(@RequestBody Tracking tracking, HttpServletRequest request, HttpServletResponse response) {
        Tracking trackingCreated = this.trackingService.createTracking(tracking);
        response.setHeader("Location", request.getRequestURL().append("/").append(trackingCreated.getId()).toString());
        return trackingCreated;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Tracking getTracking(@PathVariable("id") Long id,  HttpServletRequest request, HttpServletResponse response) throws Exception {
        Tracking tracking= this.trackingService.getTracking(id);
        checkResourceFound(tracking);
        return tracking;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Tracking updateTracking(@PathVariable("id") Long id, @RequestBody Tracking tracking, HttpServletRequest request, HttpServletResponse response) {
        Tracking currentTracking = this.trackingService.getTracking(id);
        if (id != currentTracking.getId()) throw new DataFormatException("ID's no coinciden");
        return this.trackingService.updateTracking(tracking);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Tracking deleteTracking(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.trackingService.getTracking(id));
        return this.trackingService.deleteTracking(id);
    }

}
