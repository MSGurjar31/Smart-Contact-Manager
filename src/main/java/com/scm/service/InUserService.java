package com.scm.service;

import java.util.List;
import java.util.Optional;


import com.scm.model.SCM_User;

public interface InUserService {

        public SCM_User saveUser(SCM_User user);

        public List<SCM_User> getAllUser();

        public Optional<SCM_User> getUserById(String  userId);

        public Optional<SCM_User> updateUser(SCM_User user);

        public void deleteUser(String userId);

        public boolean isUserExist(String userId);

        public boolean isUserExistByEmail(String email);

       

        

}
