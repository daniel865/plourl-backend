package com.plourlbackend.dao;

import com.plourlbackend.domain.Tracking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TrackingRepository extends CrudRepository<Tracking, Long>, PagingAndSortingRepository<Tracking, Long> {
}
