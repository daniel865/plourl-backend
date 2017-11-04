package com.plourlbackend.dao;

import com.plourlbackend.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends CrudRepository<User, Long> {
}
