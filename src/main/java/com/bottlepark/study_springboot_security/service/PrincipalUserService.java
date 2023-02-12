package com.bottlepark.study_springboot_security.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bottlepark.study_springboot_security.configurations.PricipalUser;
import com.bottlepark.study_springboot_security.daos.SharedDao;

@Service
public class PrincipalUserService implements UserDetailsService{

    @Autowired
    SharedDao sharedDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //query select with ID
        String sqlMapId = "Memberwithauthority.selectByUID";
        Object usernameObj = username;
        Map<String, String> resultMap = (Map<String, String>) sharedDao.getOne(sqlMapId, usernameObj);

        //session 등록
        PricipalUser pricipalUser = new PricipalUser(resultMap);
        
        return pricipalUser;
    }

    
    
}
