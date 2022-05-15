package com.restfulwebservices.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }


    public User save(final User user) {
       return this.userRepository.save(user);
    }

    public User findOne(final Long id) {
        return this.userRepository.findById(id);
    }

    public User deleteUser(final Long id) {
       return this.userRepository.deleteById(id);
    }



}
