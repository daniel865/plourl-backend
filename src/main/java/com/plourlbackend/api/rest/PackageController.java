package com.plourlbackend.api.rest;

import com.plourlbackend.domain.Package;
import com.plourlbackend.exceptions.DataFormatException;
import com.plourlbackend.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.plourlbackend.api.rest.AbstractRestHandler.checkResourceFound;

@RestController
@RequestMapping(value = "/api/plourl/package")
@CrossOrigin(origins = "*")
public class PackageController {

    @Autowired
    private PackageService packageService;

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes =  {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"}
    )
    public Package createPackage(@RequestBody Package aPackage, HttpServletRequest request, HttpServletResponse response) {
        Package packageCreated = this.packageService.cretePackage(aPackage);
        response.setHeader("Location", request.getRequestURL().append("/").append(packageCreated.getId()).toString());
        return packageCreated;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Package getPackage(@PathVariable("id") Long id,  HttpServletRequest request, HttpServletResponse response) throws Exception {
        Package aPackage = this.packageService.getPackage(id);
        checkResourceFound(aPackage);
        return aPackage;
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePackage(@PathVariable("id") Long id, @RequestBody Package aPackage, HttpServletRequest request, HttpServletResponse response) {
        Package currentPackage = this.packageService.getPackage(id);
        if (id != currentPackage.getId()) throw new DataFormatException("ID's no coinciden");
        this.packageService.updatePackage(aPackage);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePackage(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.packageService.getPackage(id));
        this.packageService.deletePackage(id);
    }

}
