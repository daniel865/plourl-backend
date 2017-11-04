package com.plourlbackend.dao;

import com.plourlbackend.domain.Destination;
import com.plourlbackend.domain.ServiceRequest;
import com.plourlbackend.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceRequestRepository extends CrudRepository<ServiceRequest, Long> {

    List<ServiceRequest> findByUser(User field);

}
