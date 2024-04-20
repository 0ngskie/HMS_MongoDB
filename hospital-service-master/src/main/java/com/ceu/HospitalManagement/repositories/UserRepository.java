package com.ceu.HospitalManagement.repositories;

import com.ceu.HospitalManagement.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
