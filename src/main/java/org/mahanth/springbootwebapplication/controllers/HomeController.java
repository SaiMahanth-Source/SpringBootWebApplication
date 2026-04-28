package org.mahanth.springbootwebapplication.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController // Which is a concept to transfer data from server to client which means state i.e, client, server but not layout
public class HomeController {

    @RequestMapping("/")
//    @ResponseBody // When Controller is only @Controller then we use response body to get the data from the server
    public String greet(){
        return "Currently in development";
        /*
        Ideally we will be returning page here instead we are returning data aslo we can return the page with body using
        thymeleaf
         */
    }

    @RequestMapping("/about")
    public String about(){
        return "Soon will implement";
    }
}
