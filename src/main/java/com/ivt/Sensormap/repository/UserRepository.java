package com.ivt.Sensormap.repository;

import com.ivt.Sensormap.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}