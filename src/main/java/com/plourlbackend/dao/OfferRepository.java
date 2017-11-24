package com.plourlbackend.dao;

import com.plourlbackend.domain.Offer;
import com.plourlbackend.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface OfferRepository extends CrudRepository<Offer, Long>, PagingAndSortingRepository<Offer, Long> {

    List<Offer> findByUser(User user);

}
