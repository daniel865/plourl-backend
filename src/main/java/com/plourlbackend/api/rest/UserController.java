package com.plourlbackend.api.rest;

import com.plourlbackend.domain.Destination;
import com.plourlbackend.domain.ServiceRequest;
import com.plourlbackend.domain.User;
import com.plourlbackend.exceptions.DataFormatException;
import com.plourlbackend.service.DestinationService;
import com.plourlbackend.service.ServiceRequestService;
import com.plourlbackend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api/plourl/users")
@Api(tags = {"users"})
public class UserController extends AbstractRestHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private DestinationService  destinationService;

    @Autowired
    private ServiceRequestService  serviceRequestService;

    @RequestMapping(value = "",
        method = RequestMethod.POST,
        consumes =  {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"}
    )
    @ApiOperation(value = "Create a user", notes = "Returns the URL of the new User")
    public User createUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        User userCreated = this.userService.createUser(user);
        response.setHeader("Location", request.getRequestURL().append("/").append(userCreated.getId()).toString());
        return user;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User getUser(@PathVariable("id") Long id,  HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = this.userService.getUser(id);
        checkResourceFound(user);
        return user;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        User currentUser = this.userService.getUser(id);
        if (id != currentUser.getId()) throw new DataFormatException("ID's no coinciden");
        return this.userService.updateUser(user);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public User deleteUser(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.userService.getUser(id));
        return this.userService.deleteUser(id);
    }

    @RequestMapping(value = "/{idUser}/destinations",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Destination> getDestinationByUser(@PathVariable("idUser") Long idUser, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.destinationService.getDestinationsByUser(idUser);
    }

    @RequestMapping(value = "/{idUser}/request",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<ServiceRequest> getServiceRequestByUser(@PathVariable("idUser") Long idUser, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return this.serviceRequestService.getRequestsByUser(idUser);
    }


}
