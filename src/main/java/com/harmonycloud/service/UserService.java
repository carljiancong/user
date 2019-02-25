package com.harmonycloud.service;

import com.harmonycloud.bo.UserBo;
import com.harmonycloud.dto.UserDto;
import com.harmonycloud.entity.*;
import com.harmonycloud.repository.ClinicRepository;
import com.harmonycloud.repository.EncounterTypeRepository;
import com.harmonycloud.repository.RoomRepository;
import com.harmonycloud.repository.UserRepository;
import com.harmonycloud.result.CodeMsg;
import com.harmonycloud.result.Result;
import com.harmonycloud.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.harmonycloud.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Result login(String loginname, String password) {
        logger.info("start login......");
        Map<String, Object> result = new HashMap<>();
        try {

            User user = userRepository.findByLoginName(loginname);
            if (user == null) {
                logger.info("login failed.....can't find this user for loginname is {}", loginname);
                return Result.buildError(CodeMsg.USER_NOT_EXIST);
            }
            logger.info("we user the username:{} find this user,its info is {}", loginname, user);
            if (!(StringUtil.EncoderByMd5(password).equals(user.getPassword()))) {
                logger.info("login failed....password is wrong!");
                return Result.buildError(CodeMsg.PASSWORD_ERROR);
            }
            logger.info("login successful.....");
            List<UserBo> userBos = userRepository.finduser(user.getUserId());
            List<UserRole> userRoles = new ArrayList<UserRole>();
            List<AccessRight> accessRights = new ArrayList<AccessRight>();

            for (int i = 0; i < userBos.size(); i++) {

                UserRole userRole = new UserRole(userBos.get(i).getRoleId(), userBos.get(i).getRoleName(),userBos.get(i).getUserRoleDesc(),userBos.get(i).getUserRoleStatus(), userBos.get(i).getClinicId());
                userRoles.add(userRole);

                AccessRight accessRight = new AccessRight(userBos.get(i).getAccessRightId(),userBos.get(i).getAccessRightType(),userBos.get(i).getAccessRightName());
                accessRights.add(accessRight);
            }
            UserDto userDto = new UserDto(user.getUserId(),user.getEnglishSurname(),user.getEnglishGivenName(),user.getLoginName(),userRoles,accessRights);
            String token = jwtUtil.generateToken(userDto.getUserId(),userDto.getLoginName(),userDto.getUserRoles());
            result.put("user", userDto);
            result.put("token", token);

            return Result.buildSuccess(result);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return Result.buildError(CodeMsg.FAIL);
        }
    }

    public Result listClinics() {
        try {
            return Result.buildSuccess(clinicRepository.findAll());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Result.buildError(CodeMsg.FAIL);
        }
    }

    public Result listRoom() {
        try {
            return Result.buildSuccess(roomRepository.findAll());
        } catch (Exception e) {
            logger.error(e.getMessage());
            return Result.buildError(CodeMsg.FAIL);
        }
    }

    public Result listEncounTertype() {
        try {
             return Result.buildSuccess(encounterTypeRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.buildError(CodeMsg.FAIL);
        }
    }

}
