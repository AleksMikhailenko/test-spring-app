package ru.mikhailenko.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String firstName = request.getParameter("name");
        String lastName = request.getParameter("surname");
        System.out.println(String.format("Hello, %s %s", firstName, lastName));
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String firstName,
                              @RequestParam(value = "surname", required = false) String lastName) {
        System.out.println(String.format("Hello, %s %s", firstName, lastName));
        return "first/goodbye";
    }
}
