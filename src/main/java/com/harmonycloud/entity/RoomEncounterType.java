package com.harmonycloud.entity;

import javax.persistence.*;

@Entity
@Table(name = "room_encounter_type")
public class RoomEncounterType {
    @Id
    private Integer roomTypeId;
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "encounter_type_id")
    private Integer encounterTypeId;

    public RoomEncounterType() {
    }

    public RoomEncounterType(Integer roomTypeId, Integer roomId, Integer encounterTypeId) {
        this.roomTypeId = roomTypeId;
        this.roomId = roomId;
        this.encounterTypeId = encounterTypeId;
    }

    public Integer getroomTypeId() {
        return roomTypeId;
    }

    public void setroomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getroomId() {
        return roomId;
    }

    public void setroomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getEncounterTypeId() {
        return encounterTypeId;
    }

    public void setEncounterTypeId(Integer encounterTypeId) {
        this.encounterTypeId = encounterTypeId;
    }
}
