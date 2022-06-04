package com.ivt.Sensormap.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sensor")
public class Sensor {
    @Id
    @Column(name = "sensorId", nullable = false)
    private Integer id;

    @Column(name = "isActive", nullable = false)
    private Integer isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

/*
  TODO [JPA Buddy] create field to map the 'latitude' column
   Available actions: Define target Java type | Uncomment as is | Remove column mapping
  @Column(name = "latitude", columnDefinition = "FLOAT(12) UNSIGNED not null")
  private Object latitude;
*/
/*
  TODO [JPA Buddy] create field to map the 'longitude' column
   Available actions: Define target Java type | Uncomment as is | Remove column mapping
  @Column(name = "longitude", columnDefinition = "FLOAT(12) UNSIGNED not null")
  private Object longitude;
*/
}