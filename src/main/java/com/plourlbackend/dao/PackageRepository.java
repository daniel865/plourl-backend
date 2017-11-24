package com.plourlbackend.dao;

import com.plourlbackend.domain.Package;
import com.plourlbackend.domain.ServiceRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PackageRepository extends CrudRepository<Package, Long>, PagingAndSortingRepository<Package, Long> {

    List<Package> findByServiceRequest(ServiceRequest serviceRequest);

}
