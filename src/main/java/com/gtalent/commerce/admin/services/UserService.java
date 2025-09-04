package com.gtalent.commerce.admin.services;

import com.gtalent.commerce.admin.models.Segment;
import com.gtalent.commerce.admin.models.User;
import com.gtalent.commerce.admin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Page<User> getAllUsers(PageRequest pageRequest) {
        return userRepository.findAll(pageRequest);
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public void assignSegmentToUser(int id, int segmentId) {
        Optional<Segment> segment = segmentRepository.findById(segmentId);
        Optional<User> user = userRepository.findById();

    }
}

