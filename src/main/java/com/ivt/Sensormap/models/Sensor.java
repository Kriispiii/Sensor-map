package com.ivt.Sensormap.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "sensor")
public class Sensor {
    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensorId", nullable = false)
    private Integer id;

    @JsonIgnore
    @Column(name = "isActive", nullable = false)
    private Integer isActive;

    @JsonProperty("latitude")
    @Column(name = "latitude")
    private Float latitude;

    @JsonProperty("longitude")
    @Column(name = "longitude")
    private Float longitude;

    @JsonProperty("User_userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "User_userId", nullable = false)
    private User userUser;

    public Sensor() {
    }

    public Sensor(Float latitude, Float longitude) {
        this.isActive = 1;
        this.latitude = latitude;
        this.longitude = longitude;
    }

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

    public User getUserUser() {
        return userUser;
    }


    public void setUserUser(User userUser) {
        this.userUser = userUser;
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