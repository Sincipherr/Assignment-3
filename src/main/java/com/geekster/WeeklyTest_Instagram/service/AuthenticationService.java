package com.geekster.WeeklyTest_Instagram.service;

import com.geekster.WeeklyTest_Instagram.Repository.IAuthenticationRepo;
import com.geekster.WeeklyTest_Instagram.model.AuthenticationToken;
import com.geekster.WeeklyTest_Instagram.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    IAuthenticationRepo ar;

    public void savetoken(AuthenticationToken token) {
        ar.save(token);
    }

    public AuthenticationToken gettoken(User user) {
            return ar.findByUser(user);
    }

    public boolean authenticate(String email, String token) {
        if(token==null && email==null){
            return false;
        }
        AuthenticationToken authToken = ar.findFirstByToken(token);
        if(authToken==null){
            return false;
        }
        String expectedEmail = authToken.getUser().getEmail();
        return expectedEmail.equals(email);
    }

    public void deleteToken(String token) {
        AuthenticationToken token1 = ar.findFirstByToken(token);
        ar.deleteById(token1.getTokenId());
    }
}
