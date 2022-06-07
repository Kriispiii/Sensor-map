package com.ivt.Sensormap.models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AreaId implements Serializable {
    private static final long serialVersionUID = 4324796832893159961L;
    @Column(name = "areaId", nullable = false)
    private Integer areaId;

    @Column(name = "owner_userId", nullable = false)
    private Integer ownerUserid;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getOwnerUserid() {
        return ownerUserid;
    }

    public void setOwnerUserid(Integer ownerUserid) {
        this.ownerUserid = ownerUserid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AreaId entity = (AreaId) o;
        return Objects.equals(this.areaId, entity.areaId) &&
                Objects.equals(this.ownerUserid, entity.ownerUserid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaId, ownerUserid);
    }

}