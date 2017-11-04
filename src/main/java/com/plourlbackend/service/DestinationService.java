package com.plourlbackend.service;

import com.plourlbackend.dao.DestinationRepository;
import com.plourlbackend.domain.Destination;
import com.plourlbackend.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    private static final Logger log = LoggerFactory.getLogger(Destination.class);

    @Autowired
    private DestinationRepository destinationRepository;

    public DestinationService() {
    }

    public Destination createDestination(Destination destination){
        return destinationRepository.save(destination);
    }

    public Destination getDestination(Long id) {
        return destinationRepository.findOne(id);
    }

    public Destination updatedDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    public Destination deleteDestination(Long id) {
        Optional<Destination> destination = Optional.ofNullable(destinationRepository.findOne(id));
        if (destination.isPresent()) {
            destinationRepository.delete(destination .get().getId());
            return destination.get();
        } else {
            throw new IllegalArgumentException("El destino no existe");
        }
    }

    public List<Destination> getDestinationsByUser(Long idUser) {
        return destinationRepository.findByUser(new User(idUser));
    }


}
