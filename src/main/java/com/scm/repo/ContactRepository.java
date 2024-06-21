package com.scm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.model.SCM_Contact;

public interface ContactRepository extends JpaRepository<SCM_Contact,String>{
    

}
