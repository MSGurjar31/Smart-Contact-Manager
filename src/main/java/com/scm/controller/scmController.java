package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/scm")

public class scmController {

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
    public String register() {
        return new String("register");
    }

    
    
    
    
    
    
}
