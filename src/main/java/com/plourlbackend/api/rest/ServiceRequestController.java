package com.plourlbackend.api.rest;

import com.plourlbackend.domain.ServiceRequest;
import com.plourlbackend.domain.User;
import com.plourlbackend.exceptions.DataFormatException;
import com.plourlbackend.service.ServiceRequestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api/plourl/requests")
@CrossOrigin(origins = "*")
public class ServiceRequestController  extends AbstractRestHandler {

    @Autowired
    private ServiceRequestService serviceRequestService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes =  {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"}
    )
    public ServiceRequest createServiceRequest(@RequestBody ServiceRequest serviceRequest, HttpServletRequest request, HttpServletResponse response) {
        ServiceRequest serviceRequestCreated = this.serviceRequestService.createServiceRequest(serviceRequest);
        return serviceRequestCreated;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ServiceRequest getServiceRequest(@PathVariable("id") Long id,  HttpServletRequest request, HttpServletResponse response) throws Exception {
        ServiceRequest serviceRequest = this.serviceRequestService.getServiceRequest(id);
        checkResourceFound(serviceRequest);
        return serviceRequest;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ServiceRequest updateServiceRequest(@PathVariable("id") Long id, @RequestBody ServiceRequest serviceRequest, HttpServletRequest request, HttpServletResponse response) {
        ServiceRequest currentServiceRequest = this.serviceRequestService.getServiceRequest(id);
        if (id != currentServiceRequest.getId()) throw new DataFormatException("ID's no coinciden");
        return this.serviceRequestService.updateServiceRequest(serviceRequest);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ServiceRequest deleteServiceRequest(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.serviceRequestService.getServiceRequest(id));
        return this.serviceRequestService.deleteServiceRequest(id);
    }

}
