package com.harmonycloud.repository;

import com.harmonycloud.bo.UserBo;
import com.harmonycloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLoginName(String LoginName);

    @Query("SELECT new com.harmonycloud.bo.UserBo(u.userId,u.englishSurname,u.englishGivenName,u.loginName,r.userRoleName) FROM User u,UserUserrole ur,UserRole r where u.userId=1 and u.userId=ur.userId and ur.userRoleId=r.roleId")
    UserBo finduser(int userid);
}
