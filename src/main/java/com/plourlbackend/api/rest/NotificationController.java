package com.plourlbackend.api.rest;

import com.plourlbackend.domain.Notification;
import com.plourlbackend.domain.Rating;
import com.plourlbackend.exceptions.DataFormatException;
import com.plourlbackend.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/api/plourl/notification")
@CrossOrigin(origins = "*")
public class NotificationController extends AbstractRestHandler {

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes =  {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"}
    )
    public Notification createNotification(@RequestBody Notification notification, HttpServletRequest request, HttpServletResponse response) {
        Notification notificationCreated = this.notificationService.createNotification(notification);
        response.setHeader("Location", request.getRequestURL().append("/").append(notificationCreated.getId()).toString());
        return notificationCreated;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Notification getNotification(@PathVariable("id") Long id,  HttpServletRequest request, HttpServletResponse response) throws Exception {
        Notification notification = this.notificationService.getNotification(id);
        checkResourceFound(notification);
        return notification;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Notification updateNotification(@PathVariable("id") Long id, @RequestBody Notification notification, HttpServletRequest request, HttpServletResponse response) {
        Notification currentNotification = this.notificationService.getNotification(id);
        if (id != currentNotification.getId()) throw new DataFormatException("ID's no coinciden");
        return this.notificationService.updateNotification(notification);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Notification deleteNotification(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.notificationService.getNotification(id));
        return this.notificationService.deleteNotification(id);
    }

}
