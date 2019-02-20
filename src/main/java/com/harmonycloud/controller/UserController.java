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

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "User")
public class UserController {
    private JwtUtil jwtUtil = new JwtUtil();
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "user", response = UserDto.class, httpMethod = "POST")
    @ApiImplicitParam(name = "param", value = "param", paramType = "Body", dataType = "Map")
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

    @GetMapping(value = "/listclinic")

    @ApiOperation(value = "user", response = Clinic.class, httpMethod = "GET")
    public Result listclinic() {
        try {
            return userService.listclincs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/listencountertype")
    @ApiOperation(value = "user", response = EncounterType.class, httpMethod = "GET")
    public Result listencountertype() {
        try {
            return userService.listencountertype();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/listroom")
    @ApiOperation(value = "user", response = Room.class, httpMethod = "GET")
    public Result listroom() {
        try {
            return userService.listroom();
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
