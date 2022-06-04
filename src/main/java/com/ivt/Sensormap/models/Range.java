package com.ivt.Sensormap.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

@Entity
@Table(name = "`range`")
public class Range {
    @Id
    @Column(name = "rangeId", nullable = false)
    private Integer id;

    @Column(name = "lowValue")
    private Integer lowValue;

    @Column(name = "highValue")
    private Integer highValue;

    @Column(name = "rangeName", nullable = false, length = 45)
    private String rangeName;

    @Column(name = "updateTime", nullable = false)
    private LocalTime updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLowValue() {
        return lowValue;
    }

    public void setLowValue(Integer lowValue) {
        this.lowValue = lowValue;
    }

    public Integer getHighValue() {
        return highValue;
    }

    public void setHighValue(Integer highValue) {
        this.highValue = highValue;
    }

    public String getRangeName() {
        return rangeName;
    }

    public void setRangeName(String rangeName) {
        this.rangeName = rangeName;
    }

    public LocalTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalTime updateTime) {
        this.updateTime = updateTime;
    }

}