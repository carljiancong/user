package com.harmonycloud.controller;


import com.harmonycloud.entity.Clinic;
import com.harmonycloud.entity.EncounterType;
import com.harmonycloud.entity.Room;
import com.harmonycloud.result.Result;
import com.harmonycloud.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    @ApiOperation(value = "user", response = Result.class, httpMethod = "POST")
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
    @ApiOperation(value = "user", httpMethod = "GET")
    public List<Clinic> listclinic() {
        try {
            return userService.listclincs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/listencountertype")
    @ApiOperation(value = "user", httpMethod = "GET")
    public List<EncounterType> listencountertype() {
        try {
            return userService.listencountertype();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/listroom")
    @ApiOperation(value = "user", httpMethod = "GET")
    public List<Room> listroom() {
        try {
            return userService.listroom();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
