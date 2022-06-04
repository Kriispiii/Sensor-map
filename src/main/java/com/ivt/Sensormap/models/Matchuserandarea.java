package com.ivt.Sensormap.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "matchuserandarea")
public class Matchuserandarea {
    @EmbeddedId
    private MatchuserandareaId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(name = "isActiveMatch", nullable = false)
    private Integer isActiveMatch;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "accessLvl", nullable = false)
    private AccessRule accessLvl;

    @Column(name = "accessDate", nullable = false)
    private LocalDate accessDate;

    public MatchuserandareaId getId() {
        return id;
    }

    public void setId(MatchuserandareaId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getIsActiveMatch() {
        return isActiveMatch;
    }

    public void setIsActiveMatch(Integer isActiveMatch) {
        this.isActiveMatch = isActiveMatch;
    }

    public AccessRule getAccessLvl() {
        return accessLvl;
    }

    public void setAccessLvl(AccessRule accessLvl) {
        this.accessLvl = accessLvl;
    }

    public LocalDate getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(LocalDate accessDate) {
        this.accessDate = accessDate;
    }

}