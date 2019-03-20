package com.harmonycloud.service;

import com.harmonycloud.bo.UserBo;
import com.harmonycloud.dto.UserDto;
import com.harmonycloud.entity.*;
import com.harmonycloud.enums.ErrorMsgEnum;
import com.harmonycloud.exception.UserException;
import com.harmonycloud.repository.ClinicRepository;
import com.harmonycloud.repository.EncounterTypeRepository;
import com.harmonycloud.repository.RoomRepository;
import com.harmonycloud.repository.UserRepository;
import com.harmonycloud.result.CimsResponseWrapper;
import com.harmonycloud.util.JwtUtil;
import com.harmonycloud.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.harmonycloud.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private JwtUtil jwtUtil = new JwtUtil();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private EncounterTypeRepository encounterTypeRepository;

    @Autowired
    HttpServletRequest request;

    private String msg;

    /**
     * user login
     *
     * @param loginname loginname
     * @param password  password
     * @return
     */
    public CimsResponseWrapper<Map> login(String loginname, String password) throws Exception {
        msg = LogUtil.getRequest(request) + ", information='";

        logger.info(msg + "login start.....'");
        Map<String, Object> result = new HashMap<>();
        User user = userRepository.findByLoginName(loginname);
        if (user == null) {
            throw new UserException(ErrorMsgEnum.USER_NOT_EXIST.getMessage());
        }
        if (!(StringUtil.EncoderByMd5(password).equals(user.getPassword()))) {
            throw new UserException(ErrorMsgEnum.PASSWORD_ERROR.getMessage());
        }

        logger.info(msg + "login successful.....\'");
        List<UserBo> userBoList = userRepository.finduser(user.getUserId());
        List<AccessRight> accessRightList = new ArrayList<AccessRight>();
        List<UserRole> userRoleList = new ArrayList<>();

        for (int i = 0; i < userBoList.size(); i++) {

            UserRole userRole = new UserRole(userBoList.get(i).getRoleId(), userBoList.get(i).getRoleName(), userBoList.get(i).getUserRoleDesc(),
                    userBoList.get(i).getUserRoleStatus(), userBoList.get(i).getClinicId());
            userRoleList.add(userRole);

            AccessRight accessRight = new AccessRight(userBoList.get(i).getAccessRightId(), userBoList.get(i).getAccessRightType(), userBoList.get(i).getAccessRightName());
            accessRightList.add(accessRight);
        }
        UserDto userDto = new UserDto(user.getUserId(), user.getEnglishSurname(), user.getEnglishGivenName(), user.getLoginName(), userRoleList, accessRightList);
        String token = jwtUtil.generateToken(userDto.getUserId(), userDto.getEnglishSurname(), userDto.getEnglishGivenName(), userDto.getUserRoleList());
        result.put("user", userDto);
        result.put("token", token);
        return new CimsResponseWrapper<>(true, null, result);
    }

    /**
     * get all clinic
     *
     * @return
     * @throws Exception
     */
    public CimsResponseWrapper<List> listClinics() throws Exception {
        return new CimsResponseWrapper<List>(true, null, clinicRepository.findAll());
    }

    /**
     * get all room in this clinic
     *
     * @param clinicId clinicId
     * @return
     */
    public CimsResponseWrapper<List> listRoomByCliniciId(Integer clinicId) throws Exception {
        msg = LogUtil.getRequest(request) + ", information='";

        List<Room> roomList = roomRepository.findByClinicId(clinicId);
        if (roomList.size() == 0) {
            logger.info(msg + "No room in this clinic '");
            return new CimsResponseWrapper<List>(true, null, null);
        }
        return new CimsResponseWrapper<List>(true, null, roomList);
    }

    /**
     * get specific room by encounterTypeId in this clinic
     *
     * @param clinicId        clinicId
     * @param encounterTypeId encounterTypeId
     * @return
     */
    public CimsResponseWrapper<List> listRoom(Integer clinicId, Integer encounterTypeId) throws Exception {
        msg = LogUtil.getRequest(request) + ", information='";

        List<Room> roomList = roomRepository.listRoom(clinicId, encounterTypeId);
        if (roomList.size() == 0) {
            logger.info(msg + "No room in this clinic '");
            return new CimsResponseWrapper<List>(true, null, null);
        }
        return new CimsResponseWrapper<List>(true, null, roomList);
    }

    /**
     * get all type of encounter in this clinic
     *
     * @param clinicId clinicId
     * @return
     * @throws Exception
     */
    public CimsResponseWrapper<List> listEncounterType(Integer clinicId) throws Exception {
        msg = LogUtil.getRequest(request) + ", information='";

        List<EncounterType> encounterTypeList = encounterTypeRepository.findByClinicId(clinicId);
        if (encounterTypeList.size() == 0) {
            logger.info(msg + "No type of encounter in this clinic '");
            return new CimsResponseWrapper<List>(true, null, null);
        }
        return new CimsResponseWrapper<List>(true, null, encounterTypeList);
    }


}
