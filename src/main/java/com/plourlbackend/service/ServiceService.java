package com.plourlbackend.service;

import com.plourlbackend.dao.ServiceRepository;
import com.plourlbackend.domain.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    private static final Logger log = LoggerFactory.getLogger(ServiceService.class);

    @Autowired
    private ServiceRepository serviceRepository;

    public ServiceService() {
    }

    public Service createService(Service service) {
        return serviceRepository.save(service);
    }

    public Service getService(Long id) {
        return serviceRepository.findOne(id);
    }

    public Service updateService(Service service) {
        return serviceRepository.save(service);
    }

    public Service deleteService(Long id) {
        Optional<Service> serviceOptional = Optional.ofNullable(serviceRepository.findOne(id));
        if (serviceOptional.isPresent()) {
            serviceRepository.delete(serviceOptional.get().getId());
            return serviceOptional.get();
        } else {
            throw new IllegalArgumentException("El servicio no existe");
        }
    }

}
