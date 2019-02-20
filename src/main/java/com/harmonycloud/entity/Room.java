package com.harmonycloud.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
/**
 * @author qidong
 * @date 2019/2/13
 */

@Entity
@Table(name = "room")
@ApiModel(value = "诊室")
public class Room {
    @Id
    @ApiModelProperty(value = "诊室Id",example = "1")
    private Integer roomId;
    @Column(name = "room_name")
    @ApiModelProperty(value = "诊室名称",example = "roomtest")
    private String roomName;
    @Column(name = "clinic_id")
    @ApiModelProperty(value = "诊所Id",example = "1")
    private Integer clinicId;

    public Room() {
    }

    public Room(Integer roomId, String roomName, Integer clinicId) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.clinicId = clinicId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }
}
