package vn.fpoly.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.fpoly.java5.entity.Student;

import java.time.LocalDate;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/info")
    public String getInfo(Model model) {
        model.addAttribute("id","TL00002");
        model.addAttribute("name","Đặng Hùng Anh");
        model.addAttribute("gender","Nam");
        model.addAttribute("birthday","2008-06-19");
        model.addAttribute("image","image.jpg");
        model.addAttribute("score","9.5");
        return "student/info";
    }
    @GetMapping("/detail")
    public String getDetail(Model model) {
        Student student = Student.builder()
                .id("TL19233")
                .name("Coco Kiryu")
                .gender(false)
                .birthday(LocalDate.of(2002,6,17))
                .image("image.png")
                .score(9.5)
                .build();
                model.addAttribute("student",student);
                return "student/detail";

    }
}
