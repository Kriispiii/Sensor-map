package com.ivt.Sensormap.models;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistic {
    @EmbeddedId
    private StatisticId id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "sensorId", referencedColumnName = "sensorId", nullable = false),
            @JoinColumn(name = "rangeId", referencedColumnName = "rangeId", nullable = false)
    })
    private SensorHasRange sensorHasRange;

    @Column(name = "data")
    private Integer data;

    public StatisticId getId() {
        return id;
    }

    public void setId(StatisticId id) {
        this.id = id;
    }

    public SensorHasRange getSensorHasRange() {
        return sensorHasRange;
    }

    public void setSensorHasRange(SensorHasRange sensorHasRange) {
        this.sensorHasRange = sensorHasRange;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

}