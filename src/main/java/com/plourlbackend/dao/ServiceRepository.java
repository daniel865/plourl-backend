package com.plourlbackend.dao;

import com.plourlbackend.domain.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServiceRepository extends CrudRepository<Service, Long>, PagingAndSortingRepository<Service, Long> {
}
