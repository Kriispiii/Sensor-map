package com.ivt.Sensormap.repo;

import com.ivt.Sensormap.models.Sensor;
import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends CrudRepository<Sensor,Long> {
}
