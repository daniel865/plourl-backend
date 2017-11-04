package com.plourlbackend.dao;

import com.plourlbackend.domain.Availability;
import com.plourlbackend.domain.Destination;
import org.springframework.data.repository.CrudRepository;

public interface AvailabilityRepository extends CrudRepository<Availability, Long> {
}
