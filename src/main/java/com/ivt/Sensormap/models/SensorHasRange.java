package com.ivt.Sensormap.models;

import javax.persistence.*;

@Entity
@Table(name = "sensor_has_range")
public class SensorHasRange {
    @EmbeddedId
    private SensorHasRangeId id;

    @MapsId("sensorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sensorId", nullable = false)
    private Sensor sensor;

    @MapsId("rangeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rangeId", nullable = false)
    private Range range;

    public SensorHasRangeId getId() {
        return id;
    }

    public void setId(SensorHasRangeId id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

}