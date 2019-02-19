package com.harmonycloud.service;

import com.harmonycloud.bo.UserBo;
import com.harmonycloud.entity.Clinic;
import com.harmonycloud.entity.EncounterType;
import com.harmonycloud.entity.Room;
import com.harmonycloud.entity.User;
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
            UserBo userBo = userRepository.finduser(user.getUserId());
            String token = jwtUtil.generateToken(userBo.getUserId(), userBo.getLoginName(), userBo.getRole());
            result.put("user", userBo);
            result.put("token", token);

            return Result.buildSuccess(result);

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return Result.buildError(CodeMsg.LOGIN_FAIL);
    }

    public List<Clinic> listclincs() {
        try {
            return clinicRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Room> listroom() {
        try {
            return roomRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<EncounterType> listencountertype() {
        try {
            return encounterTypeRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(StringUtil.EncoderByMd5("vicky"));
    }
}
