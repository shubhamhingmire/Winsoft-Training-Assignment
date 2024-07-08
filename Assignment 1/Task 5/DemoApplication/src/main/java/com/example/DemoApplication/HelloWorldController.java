package com.example.DemoApplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("message", "Hello World!");
        return "hello"; // View name
    }
}
