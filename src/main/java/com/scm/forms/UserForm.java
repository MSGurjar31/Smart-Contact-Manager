package com.scm.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {

    private String userName;
    private String email;
    private String password;
    private String about;
    private String phoneNumber;
    private String profilePic;

}   
