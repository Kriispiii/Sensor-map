package com.ivt.Sensormap.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "access_rules")
public class AccessRule {
    @Id
    @Column(name = "accessLvl", nullable = false)
    private Integer id;

    @Column(name = "dayRange")
    private Integer dayRange;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDayRange() {
        return dayRange;
    }

    public void setDayRange(Integer dayRange) {
        this.dayRange = dayRange;
    }

}