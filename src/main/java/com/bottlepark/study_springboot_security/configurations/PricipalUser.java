package com.bottlepark.study_springboot_security.configurations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PricipalUser implements UserDetails{
    private Map userInfo;
    private String memberName;

    public String getMemberName() {
        return memberName;
    }

    public PricipalUser(Map userInfo) {
        this.userInfo = userInfo;
        this.memberName = (String)userInfo.get("NAME");
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        // 권한들
        Collection<GrantedAuthority> collections = new ArrayList<>();
        collections.add(new SimpleGrantedAuthority((String) userInfo.get("AUTHORITY")));
        return collections;
    }


    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return (String)userInfo.get("PASSWORD");
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return (String)userInfo.get("MEMBER_ID");
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정만료
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠길 여부
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 비밀번호 변경  기간 만료
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
