package com.plourlbackend.service;

import com.plourlbackend.dao.UserRepository;
import com.plourlbackend.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(User.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User deleteUser(Long id) {
        Optional<User> user = Optional.ofNullable(userRepository.findOne(id));
        if (user.isPresent()) {
            userRepository.delete(user.get().getId());
            return user.get();
        } else {
            throw new IllegalArgumentException("El usuario no existe");
        }
    }

}
