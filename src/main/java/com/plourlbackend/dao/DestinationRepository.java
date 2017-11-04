package com.plourlbackend.dao;

import com.plourlbackend.domain.Destination;
import com.plourlbackend.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface DestinationRepository extends CrudRepository<Destination, Long> {

    List<Destination> findByUser(User field);

}
