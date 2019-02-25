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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Api(value = "User")
public class UserController {
    private JwtUtil jwtUtil = new JwtUtil();
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "user", response = UserDto.class, httpMethod = "POST")
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
    @ApiOperation(value = "user", response = Clinic.class, httpMethod = "GET")
    public Result listClinic() {
        try {
            return userService.listClinics();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/listEncounterType")
    @ApiOperation(value = "user", response = EncounterType.class, httpMethod = "GET")
    public Result listEncounterType() {
        try {
            return userService.listEncounTertype();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/listRoom")
    @ApiOperation(value = "user", response = Room.class, httpMethod = "GET")
    public Result listRoom() {
        try {
            return userService.listRoom();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/publicKey")
    public String getPublicKey(){
        return jwtUtil.getPublicKey();
    }
}
