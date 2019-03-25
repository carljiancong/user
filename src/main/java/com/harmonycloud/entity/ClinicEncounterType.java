package com.harmonycloud.entity;

import javax.persistence.*;


@Entity
@Table(name = "clinic_encounter_type")
public class ClinicEncounterType {
    @Id
    private Integer clinicEncounterTypeId;
    @Column(name = "clinic_id")
    private Integer clinicId;
    @Column(name = "encounter_type_id")
    private Integer encounterTypeId;

    public ClinicEncounterType() {
    }

    public ClinicEncounterType(Integer clinicEncounterTypeId, Integer clinicId, Integer encounterTypeId) {
        this.clinicEncounterTypeId = clinicEncounterTypeId;
        this.clinicId = clinicId;
        this.encounterTypeId = encounterTypeId;
    }

    public Integer getclinicEncounterTypeId() {
        return clinicEncounterTypeId;
    }

    public void setclinicEncounterTypeId(Integer clinicencounterTypeId) {
        this.clinicEncounterTypeId = clinicEncounterTypeId;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public Integer getEncounterTypeId() {
        return encounterTypeId;
    }

    public void setEncounterTypeId(Integer encounterTypeId) {
        this.encounterTypeId = encounterTypeId;
    }
}
