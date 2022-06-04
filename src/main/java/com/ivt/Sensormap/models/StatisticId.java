package com.ivt.Sensormap.models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Embeddable
public class StatisticId implements Serializable {
    private static final long serialVersionUID = -766764684029520234L;
    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(name = "sensorId", nullable = false)
    private Integer sensorId;

    @Column(name = "rangeId", nullable = false)
    private Integer rangeId;

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getRangeId() {
        return rangeId;
    }

    public void setRangeId(Integer rangeId) {
        this.rangeId = rangeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StatisticId entity = (StatisticId) o;
        return Objects.equals(this.date, entity.date) &&
                Objects.equals(this.rangeId, entity.rangeId) &&
                Objects.equals(this.sensorId, entity.sensorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, rangeId, sensorId);
    }

}