package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.forms.UserForm;
import com.scm.model.SCM_User;
import com.scm.service.InUserService;

import org.springframework.web.bind.annotation.PostMapping;





@Controller
@RequestMapping("/scm")

public class scmController {

    @Autowired
    private InUserService userService;


    @GetMapping("/home")
    public String gethome(Model model) {
        model.addAttribute("name", "Mayank");
        model.addAttribute("Youtube", "MSGurjar");
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return new String("about");
    }
    
    @GetMapping("/services")
    public String service() {
        return new String("services");
    }
    @GetMapping("/base")
    public String base() {
        return new String("base");
    }
    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }

    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

    @GetMapping("/register")
    public String register(Model model) {

        UserForm userForm = new UserForm();
        
        model.addAttribute("userForm", userForm);
        

        return "register";
    }

    @PostMapping("/do-register")
    public String processRegister(@ModelAttribute UserForm userForm) {
    	    	
    	
    	SCM_User user = new  SCM_User();
    	user.setUserName(userForm.getUserName());
    	user.setEmail(userForm.getEmail());
    	user.setPassword(userForm.getPassword());
    	user.setPhoneNumber(userForm.getPhoneNumber());
    	user.setAbout(userForm.getAbout());
    	user.setProfilePic("");
    	
    	SCM_User savedUser = userService.saveUser(user);
      	
    	System.out.println("User Saved");
    	
    	System.out.println("UserDetails : "+savedUser);
        
        return "redirect:/scm/register";
    }
    
    
    
    
    
    
}
