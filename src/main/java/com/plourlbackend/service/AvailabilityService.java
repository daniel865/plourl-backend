package com.plourlbackend.service;

import com.plourlbackend.dao.AvailabilityRepository;
import com.plourlbackend.domain.Availability;
import com.plourlbackend.domain.Destination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AvailabilityService {

    private static final Logger log = LoggerFactory.getLogger(Availability.class);

    @Autowired
    private AvailabilityRepository availabilityRepository;

    public AvailabilityService() {
    }

    public Availability createAvailability(Availability availability){
        return availabilityRepository.save(availability);
    }

    public Availability getAvailability(Long id){
        return availabilityRepository.findOne(id);
    }

    public Availability updateAvailability(Availability availability){
        return availabilityRepository.save(availability);
    }

    public Availability deleteAvailability(Long id){
        Optional<Availability> availabilityOptional = Optional.ofNullable(availabilityRepository.findOne(id));
        if (availabilityOptional.isPresent()) {
            availabilityRepository.delete(availabilityOptional.get().getId());
            return availabilityOptional.get();
        } else {
            throw new IllegalArgumentException("La disponibilidad no existe");
        }
    }

}
