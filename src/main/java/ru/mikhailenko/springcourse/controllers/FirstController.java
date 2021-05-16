package ru.mikhailenko.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String firstName,
                            @RequestParam(value = "surname", required = false) String lastName,
                            Model model) {
        //System.out.println(String.format("Hello, %s %s", firstName, lastName));
        String content = String.format("Hello, %s %s", firstName, lastName);
        model.addAttribute("message", content);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String firstName,
                              @RequestParam(value = "surname", required = false) String lastName) {
        System.out.println(String.format("Hello, %s %s", firstName, lastName));
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action,
                             Model model) {
        double result;

        switch (action) {
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a * 1.0 / b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);
        return "first/calculator";
    }
}
