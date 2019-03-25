package com.harmonycloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "encounter_type")
public class EncounterType {
    @Id
    private Integer encounterTypeId;
    @Column(name = "encounter_type")
    private String encounterType;

    public EncounterType() {
    }

    public EncounterType(Integer encounterTypeId, String encounterType) {
        this.encounterTypeId = encounterTypeId;
        this.encounterType = encounterType;
    }

    public Integer getEncounterTypeId() {
        return encounterTypeId;
    }

    public void setEncounterTypeId(Integer encounterTypeId) {
        this.encounterTypeId = encounterTypeId;
    }

    public String getEncounterType() {
        return encounterType;
    }

    public void setEncounterType(String encounterType) {
        this.encounterType = encounterType;
    }
}
