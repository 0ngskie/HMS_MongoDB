package com.ceu.HospitalManagement.services;

import com.ceu.HospitalManagement.entities.RO.UserRO;
import com.ceu.HospitalManagement.entities.User;
import com.ceu.HospitalManagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getOneById(String id) {
        return userRepository.findById(id).get();
    }

    public boolean save(UserRO userRO) {
            User user = Objects.isNull(userRO.getId()) ? null : getOneById(userRO.getId());
            userRepository.save(userRO.toEntity(user));
            return true;
    }

    public boolean update(String id, UserRO updatedUser) {
        User existingUser = getOneById(id);
        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setYearOfService(updatedUser.getYearOfService());
            existingUser.setSpecialty(updatedUser.getSpecialty());
            userRepository.save(existingUser);
            return true;
        }
        return false;
    }

    public boolean delete(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
