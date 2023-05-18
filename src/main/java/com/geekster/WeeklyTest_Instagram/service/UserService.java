package com.geekster.WeeklyTest_Instagram.service;

import com.geekster.WeeklyTest_Instagram.Repository.IUserRepo;
import com.geekster.WeeklyTest_Instagram.dto.SignInInput;
import com.geekster.WeeklyTest_Instagram.model.AuthenticationToken;
import com.geekster.WeeklyTest_Instagram.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.xml.bind.DatatypeConverter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepo ur;

    @Autowired
    AuthenticationService as;

    @Autowired
    FollowingService fings;

    @Autowired
    FollowerService fs;

    public String signup(User signupdto) {
        User user=ur.findFirstByEmail(signupdto.getEmail());
        if(user!=null){
            throw new IllegalStateException("User already exist..Sign in instead..!");
        }
        String encryptedpassword=null;
        try {
            encryptedpassword=encryptedpassword(signupdto.getPassword());
        }catch (Exception e){
            e.printStackTrace();
        }
//        user=new User(signupdto.getFirstName(),signupdto.getLastName(),
//                signupdto.getAge(),signupdto.getEmail(),
//                signupdto.getPhoneNumber(),encryptedpassword);
        signupdto.setPassword(encryptedpassword);
        ur.save(signupdto);
//not saving tokenhere
//        AuthenticationToken token=new AuthenticationToken(user);
//        as.savetoken(token);
        return "User registered successfully";
    }

    private String encryptedpassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5= MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested=md5.digest();
        String hash= DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public String signin(SignInInput signindto) {
        User user=ur.findFirstByEmail(signindto.getUserEmail());
        if(user==null){
            throw new IllegalStateException("Invalid user..Sign up instead..");
        }
        String encryptedpassword=null;
        try {
            encryptedpassword=encryptedpassword(signindto.getUserPassword());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        boolean isvalid=encryptedpassword.equals(user.getPassword());
        if(!isvalid){
            throw new IllegalStateException("signup instead..!");
        }
        AuthenticationToken token=new AuthenticationToken(user);
        //generating token and save it
        as.savetoken(token);
        AuthenticationToken auth=as.gettoken(user);
        return "User signed in successfully.."+auth.getToken()+" is generated..!";
    }

    @Transactional
    public String updatedetails(Integer id, String email) {
        ur.updateuser(id,email);
        return "User details updated successfully...";
    }

    @Transactional
    public String followuser(Long myid, Long oid) {
        if(myid==oid){
            return "Are you out of your mind...!";
        }
        User myuser= ur.findByUserId(myid);
        User otheruser=ur.findByUserId(oid);

        if(myuser!=null && otheruser!=null){
            fings.savefollowing(myuser,otheruser);
            fs.saveFollower(otheruser,myuser);
            return "Followed successfully";
        }else{
            return "User are invalid...!";
        }
    }

    public String updatebluetick(Long id,boolean blue) {
        User user=ur.findByUserId(id);
        if(user!=null){
            user.setBlueTick(blue);
            ur.save(user);
            return "Blue tick update";
        }else{
            return "User doesnt exist..";
        }
    }
}

