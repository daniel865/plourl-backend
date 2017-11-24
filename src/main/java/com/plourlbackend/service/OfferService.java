package com.plourlbackend.service;

import com.plourlbackend.dao.OfferRepository;
import com.plourlbackend.domain.Offer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferService {

    private static final Logger log = LoggerFactory.getLogger(OfferService.class);

    @Autowired
    private OfferRepository  offerRepository;

    public OfferService() {
    }

    public Offer createOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    public Offer getOffer(Long id) {
        return offerRepository.findOne(id);
    }

    public Offer updateOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    public Offer deleteOffer(Long id) {
        Optional<Offer> offerOptional = Optional.ofNullable(offerRepository.findOne(id));
        if (offerOptional.isPresent()) {
            offerRepository.delete(offerOptional.get().getId());
            return offerOptional.get();
        } else {
            throw new IllegalArgumentException("La oferta no existe");
        }
    }


}
