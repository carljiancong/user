package com.harmonycloud.controller;


import com.harmonycloud.dto.UserDto;
import com.harmonycloud.entity.Clinic;
import com.harmonycloud.entity.EncounterType;
import com.harmonycloud.entity.Room;
import com.harmonycloud.result.Result;
import com.harmonycloud.service.UserService;
import com.harmonycloud.util.JwtUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Api(value = "User")
public class UserController {
    private JwtUtil jwtUtil = new JwtUtil();
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "login", response = UserDto.class, httpMethod = "POST")
    @ApiImplicitParam(name = "param", value = "{\"loginname\":\"1\",\"password\":\"1\"}", paramType = "Body", dataType = "Map")
    public Result login(@RequestBody Map<String, String> param) {
        try {
            String loginname = param.get("loginname");
            String password = param.get("password");
            return userService.login(loginname, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/listClinic")
    @ApiOperation(value = "list clinic", response = Clinic.class, httpMethod = "GET")
    public Result listClinic() {
        try {
            return userService.listClinics();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/listEncounterType")
    @ApiOperation(value = "list encounterType by clinicId", response = EncounterType.class, httpMethod = "GET")
    @ApiImplicitParam(name = "clinicId", value = "clinicId", paramType = "query", dataType = "Integer")
    public Result listEncounterType(@RequestParam("clinicId") Integer clinicId) {
        try {
            return userService.listEncounterType(clinicId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 在attendance页面根据登录时的clinicId显示room
     * @param clinicId
     * @return
     */
    @GetMapping(value = "/getRoomList")
    @ApiOperation(value = "list room by clinicId", response = Room.class, httpMethod = "GET")
    @ApiImplicitParam(name = "clinicId", value = "clinicId", paramType = "query", dataType = "Integer")
    public Result getRoomList(@RequestParam("clinicId") Integer clinicId) {
        try {
            return userService.listRoomByCliniciId(clinicId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 在appointment页面，级联查询
     * @param clinicId
     * @param encounterTypeId
     * @return
     */
    @GetMapping(value = "/listRoom")
    @ApiOperation(value = "list room by clinicId and encounterTypeId", response = Room.class, httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clinicId", value = "clinicId", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "encounterTypeId", value = "encounterTypeId", paramType = "query", dataType = "Integer")
    })
    public Result listRoom(@RequestParam("clinicId") Integer clinicId,
                           @RequestParam("encounterTypeId") Integer encounterTypeId) {
        try {
            return userService.listRoom(clinicId,encounterTypeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/publicKey")
    public String getPublicKey() {
        return jwtUtil.getPublicKey();
    }
}
