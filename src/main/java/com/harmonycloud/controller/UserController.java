package com.harmonycloud.controller;


import com.harmonycloud.dto.UserDto;
import com.harmonycloud.entity.Clinic;
import com.harmonycloud.entity.EncounterType;
import com.harmonycloud.entity.Room;
import com.harmonycloud.enums.ErrorMsgEnum;
import com.harmonycloud.exception.UserException;
import com.harmonycloud.result.CimsResponseWrapper;
import com.harmonycloud.service.UserService;
import com.harmonycloud.util.JwtUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "User")
public class UserController {
    private JwtUtil jwtUtil = new JwtUtil();
    @Autowired
    private UserService userService;


    /**
     * user login
     *
     * @param param loginname and password
     * @return
     */
    @PostMapping(value = "/login")
    @ApiOperation(value = "login",  httpMethod = "POST")
    @ApiImplicitParam(name = "param", value = "{\"loginname\":\"1\",\"password\":\"1\"}", paramType = "Body", dataType = "Map")
    public CimsResponseWrapper login(@RequestBody Map<String, String> param) throws Exception {
        if (param.get("loginname") == null || param.get("password") == null) {
            throw new UserException(ErrorMsgEnum.PARAMETER_ERROR.getMessage());
        }
        return userService.login(param.get("loginname"), param.get("password"));
    }

    /**
     * get all clinic
     *
     * @return
     */
    @GetMapping(value = "/listClinic")
    @ApiOperation(value = "list clinic", response = Clinic.class, httpMethod = "GET")
    public CimsResponseWrapper<List> listClinic() throws Exception {
        return userService.listClinics();
    }

    /**
     * get all type of encounter  in this clinic
     *
     * @param clinicId clinicId
     * @return
     */
    @GetMapping(value = "/listEncounterType")
    @ApiOperation(value = "list encounterType by clinicId", response = EncounterType.class, httpMethod = "GET")
    @ApiImplicitParam(name = "clinicId", value = "clinicId", paramType = "query", dataType = "Integer")
    public CimsResponseWrapper<List> listEncounterType(@RequestParam("clinicId") Integer clinicId) throws Exception {
        if (clinicId == null || clinicId <= 0) {
            throw new UserException(ErrorMsgEnum.PARAMETER_ERROR.getMessage());
        }
        return userService.listEncounterType(clinicId);

    }


    /**
     * in attendance page ,list room by clinicId
     *
     * @param clinicId clinicId
     * @return
     */
    @GetMapping(value = "/getRoomList")
    @ApiOperation(value = "list room by clinicId", response = Room.class, httpMethod = "GET")
    @ApiImplicitParam(name = "clinicId", value = "clinicId", paramType = "query", dataType = "Integer")
    public CimsResponseWrapper<List> getRoomList(@RequestParam("clinicId") Integer clinicId) throws Exception {
        if (clinicId == null || clinicId <= 0) {
            throw new UserException(ErrorMsgEnum.PARAMETER_ERROR.getMessage());
        }
        return userService.listRoomByCliniciId(clinicId);
    }

    /**
     * in appointment page hierarchical queries
     *
     * @param clinicId        clinicId
     * @param encounterTypeId encounterTypeId
     * @return
     */
    @GetMapping(value = "/listRoom")
    @ApiOperation(value = "list room by clinicId and encounterTypeId", response = Room.class, httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "clinicId", value = "clinicId", paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "encounterTypeId", value = "encounterTypeId", paramType = "query", dataType = "Integer")
    })
    public CimsResponseWrapper<List> listRoom(@RequestParam("clinicId") Integer clinicId,
                                              @RequestParam("encounterTypeId") Integer encounterTypeId) throws Exception {
        if (clinicId == null || clinicId <= 0 || encounterTypeId == null || encounterTypeId <= 0) {
            throw new UserException(ErrorMsgEnum.PARAMETER_ERROR.getMessage());
        }
        return userService.listRoom(clinicId, encounterTypeId);
    }

    @GetMapping("/publicKey")
    public String getPublicKey() {
        return jwtUtil.getPublicKey();
    }

    @PostMapping("/refreshToken")
    public Map<String, Object> refreshToken(String oldToken) {
        return jwtUtil.refreshToken(oldToken);
    }


}
