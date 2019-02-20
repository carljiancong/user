package com.harmonycloud.repository;

import com.harmonycloud.bo.UserBo;
import com.harmonycloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLoginName(String LoginName);

    @Query("SELECT new com.harmonycloud.bo.UserBo(u.userId,u.englishSurname,u.englishGivenName,u.loginName,r.roleId,r.userRoleName,r.userRoleDesc,r.userRoleStatus,r.clinicId,ar.accessRightId,ar.accessRightType,ar.accessRightName) " +
            "FROM User u,UserUserrole ur,UserRole r , AccessRight ar,RoleAccessRight rar  " +
            "where u.userId=?1 and u.userId=ur.userId and ur.roleId=r.roleId and r.roleId=rar.roleId and ar.accessRightId=rar.accessRightId")
    List<UserBo> finduser(int userid);
}
