package com.yagiz.SpringSecurtiyDemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/admin")
    public String admin(){
        return "successfully logined, Admin dashboard page";
    }

    @GetMapping("/index")
    public String index(){
        return "Index page, welcome :)";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "successfully logined, user dashboard page";
    }
}
