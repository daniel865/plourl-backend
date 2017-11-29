package com.plourlbackend.service;

import com.plourlbackend.dao.ServiceRepository;
import com.plourlbackend.dao.TrackingRepository;
import com.plourlbackend.domain.Service;
import com.plourlbackend.domain.Tracking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@org.springframework.stereotype.Service
public class TrackingService {

    private static final Logger log = LoggerFactory.getLogger(TrackingService.class);

    @Autowired
    private TrackingRepository trackingRepository;

    public Tracking createTracking(Tracking tracking) {
        return trackingRepository.save(tracking);
    }

    public Tracking getTracking(Long id) {
        return trackingRepository.findOne(id);
    }

    public Tracking updateTracking(Tracking tracking) {
        return trackingRepository.save(tracking);
    }

    public Tracking deleteTracking(Long id) {
        Optional<Tracking> trackingOptional = Optional.ofNullable(trackingRepository.findOne(id));
        if (trackingOptional.isPresent()) {
            trackingRepository.delete(trackingOptional.get().getId());
            return trackingOptional.get();
        } else {
            throw new IllegalArgumentException("El tracking no existe");
        }
    }
}
