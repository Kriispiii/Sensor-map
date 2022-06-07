package com.ivt.Sensormap.models;

import javax.persistence.*;

@Entity
@Table(name = "area")
public class Area {
    @EmbeddedId
    private AreaId id;

    @MapsId("ownerUserid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_userId", nullable = false)
    private User ownerUser;

    @Column(name = "areaName", nullable = false, length = 45)
    private String areaName;

    public AreaId getId() {
        return id;
    }

    public void setId(AreaId id) {
        this.id = id;
    }

    public User getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(User ownerUser) {
        this.ownerUser = ownerUser;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

/*
  TODO [JPA Buddy] create field to map the 'Geo' column
   Available actions: Define target Java type | Uncomment as is | Remove column mapping
  @Column(name = "Geo", columnDefinition = "JSON(1073741824) not null")
  private Object geo;
*/
}