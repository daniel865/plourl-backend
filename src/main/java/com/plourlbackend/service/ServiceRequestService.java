package com.plourlbackend.service;

import com.plourlbackend.dao.ServiceRequestRepository;
import com.plourlbackend.domain.Destination;
import com.plourlbackend.domain.ServiceRequest;
import com.plourlbackend.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceRequestService {

    private static final Logger log = LoggerFactory.getLogger(ServiceRequest.class);

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    public ServiceRequestService() {
    }

    public ServiceRequest createServiceRequest(ServiceRequest serviceRequest){
        return serviceRequestRepository.save(serviceRequest);
    }

    public ServiceRequest getServiceRequest(Long id) {
        return serviceRequestRepository.findOne(id);
    }

    public ServiceRequest updateServiceRequest(ServiceRequest serviceRequest) {
        return serviceRequestRepository.save(serviceRequest);
    }

    public ServiceRequest deleteServiceRequest(Long id) {
        Optional<ServiceRequest> serviceRequestOptional = Optional.ofNullable(serviceRequestRepository.findOne(id));
        if (serviceRequestOptional.isPresent()) {
            serviceRequestRepository.delete(id);
            return serviceRequestOptional.get();
        } else {
            throw new IllegalArgumentException("La petición de servicio no existe");
        }
    }

    public List<ServiceRequest> getRequestsByUser(Long idUser) {
        return serviceRequestRepository.findByUser(new User(idUser));
    }

}
