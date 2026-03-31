package vn.fpoly.java5.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.fpoly.java5.entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final List<Student> studentList = new ArrayList<Student>();

    @GetMapping("/info")
    public String getInfo(Model model) {
        model.addAttribute("id","TL00002");
        model.addAttribute("name","Đặng Hùng Anh");
        model.addAttribute("gender","Nam");
        model.addAttribute("birthday","2008-06-19");
        model.addAttribute("image","image.jpg");
        model.addAttribute("score","9.5");
        model.addAttribute("containerStyle","padding-left:40px"+"text-align:left");
        model.addAttribute("titleStyle","font-weight:bold;"+"font-size:1.5rem"+"color:red");
        model.addAttribute("imageStyle","width:100px;"+"height:100px;"+"border-radius:50%;"+"object-fit:cover;");

        return "student/info";
    }
    @GetMapping("/detail")
    public String getDetail(Model model) {
        Student student = Student.builder()
                .id("TL19233")
                .name("coco kiryu")
                .gender(false)
                .birthday(LocalDate.of(2002,6,17))
                .image("image.png")
                .score(9.5)
                .status(0)
                .build();
                model.addAttribute("student",student);
                return "student/detail";
    }
    @GetMapping("/image")
    public String getImagePath(Model model) {
        Student student = Student.builder()
                .id("TL19233")
                .name("Coco Kiryu")
                .gender(false)
                .birthday(LocalDate.of(2002,6,17))
                .image("avatar.png")
                .score(9.5)
                .build();
        model.addAttribute("student",student);
        return "student/image";

    }
    @GetMapping("/info2")
    public String getInfo2(Model model) {
        model.addAttribute("id","TL00002");
        model.addAttribute("name","Đặng Hùng Anh");
        model.addAttribute("gender","Nam");
        model.addAttribute("birthday","2008-06-19");
        model.addAttribute("image","image.jpg");
        model.addAttribute("score","9.5");
        model.addAttribute("containerStyle","padding-left:40px" + "text-align:center");
        model.addAttribute("","");
        return "student/info";
    }
    @GetMapping("/list")
    public String getList(Model model) {
        List<Student> students = List.of(
                Student.builder().id("TL19233").name("Sê Sủi").gender(false).score(4.5).status(0).build(),
                Student.builder().id("TL38849").name("Mũ Mây").gender(false).score(7.5).status(0).build()
        );
        model.addAttribute("students",students);
        return "student/list";
    }
// Hiển thị form tạo mới
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("student",new Student());
        model.addAttribute("message","Nhập thông tin sinh viên: ");
        return "student/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("student") @Valid Student student, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "student/create";
        }
        studentList.add(student);
        model.addAttribute("message","Tạo đối tượng thành công");
        return "redirect:/student/create";
    }
}
