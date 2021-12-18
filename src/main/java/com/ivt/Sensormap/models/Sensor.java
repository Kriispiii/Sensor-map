package com.ivt.Sensormap.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.String;

//класс за счёт которого мы создаём бд
@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double  LATITUDE;
    private  double LONGITUDE;
    private String DATE;
    private String TIME;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(double LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public double getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(double LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }
}
