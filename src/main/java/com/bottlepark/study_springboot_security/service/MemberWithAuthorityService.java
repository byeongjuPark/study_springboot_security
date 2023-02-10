package com.bottlepark.study_springboot_security.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bottlepark.study_springboot_security.daos.SharedDao;
import com.bottlepark.study_springboot_security.utils.CommonUtils;

@Service
public class MemberWithAuthorityService {
    
    @Autowired
    SharedDao sharedDao;

    @Autowired
    CommonUtils commonUtils;
    @Autowired
    BCryptPasswordEncoder bcryptPasswordEncoder;

    public Object insert(Object dataMap){
        String sqlMapId = "Memberwithauthority.insertWithUID";
        ((Map)dataMap).put("USERS_UID", commonUtils.getUniqueSequence());
        ((Map)dataMap).put("role", "ROLE_USER");
        
        String password = (String)((Map)dataMap).get("password");
        ((Map)dataMap).put("password",bcryptPasswordEncoder.encode(password));

        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }
}
