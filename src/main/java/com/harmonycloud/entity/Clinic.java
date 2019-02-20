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
@ApiModel(value = "诊所")
public class Clinic {
    @Id
    @ApiModelProperty(value = "诊所Id",name="clinicid",example = "1")
    private Integer clinicId;
    @Column(name = "clinic_name")
    @ApiModelProperty(value = "诊所名称",name="clinicname",example = "clinictest")
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
