package com.scm.service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.exception.ResourceNotFoundException;
import com.scm.model.SCM_User;
import com.scm.repo.UserRepository;

@Service
public class UserService implements InUserService{


    @Autowired
    private UserRepository userRepo;

    private Logger log = LoggerFactory.getLogger(InUserService.class);
    

    @Override
    public SCM_User saveUser(SCM_User user) {

    	String userId = UUID.randomUUID().toString();
    	
    	user.setUserId(userId);
    	
        return userRepo.save(user);
        
    }

    @Override
    public List<SCM_User> getAllUser() {

        return userRepo.findAll();
    }

    @Override
    public Optional<SCM_User> getUserById(String userId) {

        return userRepo.findById(userId);
    }

    @Override
    public Optional<SCM_User> updateUser(SCM_User user) {

        SCM_User updateUser = userRepo.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));

        updateUser.setUserName(user.getUserName());
        updateUser.setEmail(user.getEmail());
        updateUser.setPassword(user.getPassword());
        updateUser.setAbout(user.getAbout());
        updateUser.setPhoneNumber(user.getPhoneNumber());
        updateUser.setProfilePic(user.getProfilePic());
        updateUser.setEnabled(user.isEnabled());
        updateUser.setEmailVerified(user.isEmailVerified());
        updateUser.setPhoneVerified(user.isPhoneVerified());
        updateUser.setProvider(user.getProvider());
        updateUser.setProviderUserId(user.getProviderUserId());
      
        //save user
       SCM_User save =  userRepo.save(updateUser);
       return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String userId) {

        SCM_User user = userRepo.findById(userId)
                        .orElseThrow(()-> new ResourceNotFoundException("User not Found"));


        userRepo.deleteById(userId);
    }

    @Override
    public boolean isUserExist(String userId) {
    	
    	SCM_User user = userRepo.findById(userId).orElse(null);
    	
        return user!= null ? true : false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
       SCM_User user =  userRepo.findByEmail(email).orElseThrow(null);
		return user!= null ? true : false;
    }


}
