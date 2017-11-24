package com.plourlbackend.api.rest;

import com.plourlbackend.domain.Offer;
import com.plourlbackend.domain.Service;
import com.plourlbackend.exceptions.DataFormatException;
import com.plourlbackend.service.OfferService;
import com.plourlbackend.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.plourlbackend.api.rest.AbstractRestHandler.checkResourceFound;

public class ServiceController {

    @Autowired
    private ServiceService service;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes =  {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"}
    )
    public Service createService(@RequestBody Service service, HttpServletRequest request, HttpServletResponse response) {
        Service serviceCreated = this.service.createService(service);
        response.setHeader("Location", request.getRequestURL().append("/").append(serviceCreated.getId()).toString());
        return serviceCreated;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Service getService(@PathVariable("id") Long id,  HttpServletRequest request, HttpServletResponse response) throws Exception {
        Service service = this.service.getService(id);
        checkResourceFound(service);
        return service;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateService(@PathVariable("id") Long id, @RequestBody Service service, HttpServletRequest request, HttpServletResponse response) {
        Service currentService = this.service.getService(id);
        if (id != currentService.getId()) throw new DataFormatException("ID's no coinciden");
        this.service.updateService(service);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteService(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.service.getService(id));
        this.service.deleteService(id);
    }
}
