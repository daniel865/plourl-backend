package com.plourlbackend.api.rest;

import com.plourlbackend.domain.RestErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.zip.DataFormatException;

public class AbstractRestHandler implements ApplicationEventPublisherAware {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    protected ApplicationEventPublisher eventPublisher;

    protected static final String  DEFAULT_PAGE_SIZE = "100";
    protected static final String DEFAULT_PAGE_NUM = "0";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataFormatException.class)
    @ResponseBody
    public RestErrorInfo handleDataStoreException(DataFormatException ex, WebRequest request, HttpServletResponse response) {
        log.info("Converting Data Store exception to RestResponse : " + ex.getMessage());

        return new RestErrorInfo(ex, "La información enviada es errónea.");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public RestErrorInfo handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request, HttpServletResponse response) {
        log.info("ResourceNotFoundException handler:" + ex.getMessage());

        return new RestErrorInfo(ex, "No se pudo encontrar el recurso");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    //todo: replace with exception mapping
    public static <T> T checkResourceFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException("Recurso no encontrado", new Resource() {
                @Override
                public boolean exists() {
                    return false;
                }

                @Override
                public boolean isReadable() {
                    return false;
                }

                @Override
                public boolean isOpen() {
                    return false;
                }

                @Override
                public URL getURL() throws IOException {
                    return null;
                }

                @Override
                public URI getURI() throws IOException {
                    return null;
                }

                @Override
                public File getFile() throws IOException {
                    return null;
                }

                @Override
                public long contentLength() throws IOException {
                    return 0;
                }

                @Override
                public long lastModified() throws IOException {
                    return 0;
                }

                @Override
                public Resource createRelative(String s) throws IOException {
                    return null;
                }

                @Override
                public String getFilename() {
                    return null;
                }

                @Override
                public String getDescription() {
                    return null;
                }

                @Override
                public InputStream getInputStream() throws IOException {
                    return null;
                }
            });
        }
        return resource;
    }

}
