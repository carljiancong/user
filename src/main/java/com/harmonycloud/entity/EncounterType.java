package com.harmonycloud.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * @author qidong
 * @date 2019/2/13
 */
@Entity
@Table(name = "encounter_type")
@ApiModel(value = "服务类型")
public class EncounterType {
    @Id
    @ApiModelProperty(value = "服务类型Id",example = "1")
    private Integer encounterTypeId;
    @Column(name = "encounter_type")
    @ApiModelProperty(value = "服务类型名称",example = "encountertypetest")
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
