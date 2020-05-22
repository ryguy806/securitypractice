package edu.greenriver.it.securitypractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/home")
    public String home(){


        return "home";
    }

    @RequestMapping("/userpages/home")
    public String userhome(){

        return "/userpages/home";
    }

    @RequestMapping("/adminpages/home")
    public String adminHome(){
        return "adminpages/home";
    }
}
