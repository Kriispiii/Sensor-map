package com.ivt.Sensormap.models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MatchuserandareaId implements Serializable {
    private static final long serialVersionUID = -6924645017436235995L;
    @Column(name = "userId", nullable = false)
    private Integer userId;

    @Column(name = "areaId", nullable = false)
    private Integer areaId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MatchuserandareaId entity = (MatchuserandareaId) o;
        return Objects.equals(this.areaId, entity.areaId) &&
                Objects.equals(this.userId, entity.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaId, userId);
    }

}