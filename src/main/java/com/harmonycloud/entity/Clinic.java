package com.harmonycloud.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * @author qidong
 * @date 2019/2/13
 */
@Entity
@Table(name = "clinic")
public class Clinic {
    @Id
    private Integer clinicId;
    @Column(name = "clinic_name")
    private String clinicName;

    public Clinic() {
    }

    public Clinic(Integer clinicId, String clinicName) {
        this.clinicId = clinicId;
        this.clinicName = clinicName;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }
}
