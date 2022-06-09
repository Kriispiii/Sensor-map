package com.ivt.Sensormap.repository;

import com.ivt.Sensormap.models.Sensor;
import com.ivt.Sensormap.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {

    @Override
    List<Sensor> findAll();
}