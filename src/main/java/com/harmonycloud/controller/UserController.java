package com.harmonycloud.controller;

import com.harmonycloud.dto.UserDto;
import com.harmonycloud.entity.*;
import com.harmonycloud.entity.AccessRight;
import com.harmonycloud.enums.ErrorMsgEnum;
import com.harmonycloud.exception.UserException;
import com.harmonycloud.result.CimsResponseWrapper;
import com.harmonycloud.service.UserService;
import com.harmonycloud.util.JwtUtil;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;

import java.util.Map;

@RestController
@Api(value = "User")
@SuppressWarnings("unchecked")
public class UserController {

    private JwtUtil jwtUtil = new JwtUtil();

    @Autowired
    private UserService userService;


    /**
     * user login
     *
     * @param param loginname and password
     * @return CimsResponseWrapper
     * @throws Exception
     */
    @PostMapping(value = "/login")
    @ApiOperation(value = "login", httpMethod = "POST")
    @ApiImplicitParam(name = "param", value = "{\"loginname\":\"1\",\"password\":\"1\"}", paramType = "Body", dataType = "Map")
    public CimsResponseWrapper login(@RequestBody Map<String, String> param) throws Exception {
        if (param.get("loginname") == null || param.get("password") == null) {
            throw new UserException(ErrorMsgEnum.PARAMETER_ERROR.getMessage());
        }

        User user = userService.login(param.get("loginname"), param.get("password"));
        Map<String, Object> loginResult = userService.getAccessRight(user);
        Map<String, Object> result = new HashMap<>();

        UserDto userDto = new UserDto(user.getUserId(), user.getEnglishSurname(), user.getEnglishGivenName(), user.getLoginName(),
                (List<UserRole>) loginResult.get("userRole"), (List<AccessRight>) loginResult.get("accessRight"));
        String token = jwtUtil.generateToken(userDto.getUserId(), userDto.getEnglishSurname(), userDto.getEnglishGivenName(), userDto.getUserRoleList());

        result.put("user", userDto);
        result.put("token", token);
        return new CimsResponseWrapper<>(true, null, result);
    }


    /**
     * get all clinic
     *
     * @return CimsResponseWrapper
     * @throws Exception
     */
    @GetMapping(value = "/listClinic")
    @ApiOperation(value = "list clinic", response = Clinic.class, httpMethod = "GET")
    public CimsResponseWrapper<List> listClinic() throws Exception {
        List<Clinic> clinicList = userService.listClinics();
        return new CimsResponseWrapper<>(true, null, clinicList);
    }

    /**
     * get all type of encounter  in this clinic
     *
     * @param clinicId clinicId
     * @return CimsResponseWrapper
     * @throws Exception
     */
    @GetMapping(value = "/listEncounterType")
    @ApiOperation(value = "list encounterType by clinicId", response = EncounterType.class, httpMethod = "GET")
    @ApiImplicitParam(name = "clinicId", value = "clinicId", paramType = "query", dataType = "Integer")
    public CimsResponseWrapper<List> listEncounterType(@RequestParam("clinicId") Integer clinicId) throws Exception {
        if (clinicId == null || clinicId <= 0) {
            throw new UserException(ErrorMsgEnum.PARAMETER_ERROR.getMessage());
        }
        List<EncounterType> encounterTypeList = userService.listEncounterType(clinicId);

        return new CimsResponseWrapper<>(true, null, encounterTypeList);
    }


    /**
     * in attendance page ,list room by clinicId
     *
     * @param clinicId clinicId
     * @return CimsResponseWrapper
     * @throws Exception
     */
    @GetMapping(value = "/getRoomList")
    @ApiOperation(value = "list room by clinicId", response = Room.class, httpMethod = "GET")
    @ApiImplicitParam(name = "clinicId", value = "clinicId", paramType = "query", dataType = "Integer")
    public CimsResponseWrapper<List> getRoomList(@RequestParam("clinicId") Integer clinicId) throws Exception {
        if (clinicId == null || clinicId <= 0) {
            throw new UserException(ErrorMsgEnum.PARAMETER_ERROR.getMessage());
        }
        List<Room> roomList = userService.listRoomByCliniciId(clinicId);
        return new CimsResponseWrapper<>(true, null, roomList);
    }

    /**
     * in appointment page hierarchical queries
     *
     * @param clinicId        clinicId
     * @param encounterTypeId encounterTypeId
     * @return CimsResponseWrapper
     * @throws Exception
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
        List<Room> roomList = userService.listRoom(clinicId, encounterTypeId);

        return new CimsResponseWrapper<>(true, null, roomList);
    }

    /**
     * get jwt public key
     *
     * @return String
     * @throws Exception
     */
    @GetMapping("/publicKey")
    public String getPublicKey() throws Exception {
        return jwtUtil.getPublicKey();
    }

    /**
     * refresh token
     *
     * @param oldToken oldtoken
     * @return token
     */
    @PostMapping("/refreshToken")
    public Map<String, Object> refreshToken(String oldToken) throws Exception {
        return jwtUtil.refreshToken(oldToken);
    }


}
