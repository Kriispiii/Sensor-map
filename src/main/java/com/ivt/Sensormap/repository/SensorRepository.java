package com.ivt.Sensormap.repository;

import com.ivt.Sensormap.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}