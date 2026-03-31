package vn.fpoly.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String handleIndex() {
        return "student/index";
    }
}
