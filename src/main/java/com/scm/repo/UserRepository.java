package com.scm.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.model.SCM_User;



public interface UserRepository  extends JpaRepository<SCM_User,String>{

    public Optional<SCM_User> findByEmail(String email);
    public Optional<SCM_User> findByEmailAndPassword(String email,String password);
}
