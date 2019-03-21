package com.harmonycloud.service;

import com.harmonycloud.bo.UserBo;
import com.harmonycloud.entity.*;
import com.harmonycloud.enums.ErrorMsgEnum;
import com.harmonycloud.exception.UserException;
import com.harmonycloud.repository.ClinicRepository;
import com.harmonycloud.repository.EncounterTypeRepository;
import com.harmonycloud.repository.RoomRepository;
import com.harmonycloud.repository.UserRepository;
import com.harmonycloud.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.harmonycloud.util.StringUtil;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

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


    /**
     * user login
     *
     * @param loginname loginname
     * @param password  password
     * @return userBoList
     */
    public User login(String loginname, String password) throws Exception {
        String msg = LogUtil.getRequest(request) + ", information='";

        logger.info(msg + "login start.....'");

        User user = userRepository.findByLoginName(loginname);
        if (user == null) {
            throw new UserException(ErrorMsgEnum.USER_NOT_EXIST.getMessage());
        }
        if (!(StringUtil.EncoderByMd5(password).equals(user.getPassword()))) {
            throw new UserException(ErrorMsgEnum.PASSWORD_ERROR.getMessage());
        }

        logger.info(msg + "login successful.....\'");
        return user;
    }


    /**
     * get the user accessright
     *
     * @param user
     * @return
     * @throws Exception
     */
    public Map<String, Object> getAccessRight(User user) throws Exception {
        List<UserBo> userBoList = userRepository.findUSer(user.getUserId());
        Map<String, Object> result = new HashMap<>();
        List<AccessRight> accessRightList = new ArrayList<>();
        List<UserRole> userRoleList = new ArrayList<>();

        userBoList.forEach(userBo -> {
            UserRole userRole = new UserRole(userBo.getRoleId(), userBo.getRoleName(), userBo.getUserRoleDesc(), userBo.getUserRoleStatus(),
                    userBo.getClinicId());
            userRoleList.add(userRole);
            AccessRight accessRight = new AccessRight(userBo.getAccessRightId(), userBo.getAccessRightType(), userBo.getAccessRightName());
            accessRightList.add(accessRight);
        });
        result.put("userRole", userRoleList);
        result.put("accessRight", accessRightList);
        return result;
    }


    /**
     * get all clinic
     *
     * @return clinicList
     * @throws Exception
     */
    public List<Clinic> listClinics() throws Exception {
        return clinicRepository.findAll();
    }

    /**
     * get all room in this clinic
     *
     * @param clinicId clinicId
     * @return roomList
     */
    public List<Room> listRoomByCliniciId(Integer clinicId) throws Exception {
        String msg = LogUtil.getRequest(request) + ", information='";

        List<Room> roomList = roomRepository.findByClinicId(clinicId);
        if (CollectionUtils.isEmpty(roomList)) {
            logger.info(msg + "No room in this clinic '");
            return null;
        }
        return roomList;
    }

    /**
     * get specific room by encounterTypeId in this clinic
     *
     * @param clinicId        clinicId
     * @param encounterTypeId encounterTypeId
     * @return roomList
     */
    public List<Room> listRoom(Integer clinicId, Integer encounterTypeId) throws Exception {
        String msg = LogUtil.getRequest(request) + ", information='";

        List<Room> roomList = roomRepository.listRoom(clinicId, encounterTypeId);
        if (CollectionUtils.isEmpty(roomList)) {
            logger.info(msg + "No room in this clinic '");
            return null;
        }

        return roomList;
    }

    /**
     * get all type of encounter in this clinic
     *
     * @param clinicId clinicId
     * @return encounterTypeList
     * @throws Exception
     */
    public List<EncounterType> listEncounterType(Integer clinicId) throws Exception {
        String msg = LogUtil.getRequest(request) + ", information='";

        List<EncounterType> encounterTypeList = encounterTypeRepository.findByClinicId(clinicId);
        if (CollectionUtils.isEmpty(encounterTypeList)) {
            logger.info(msg + "No type of encounter in this clinic '");
            return null;
        }
        return encounterTypeList;
    }


}
