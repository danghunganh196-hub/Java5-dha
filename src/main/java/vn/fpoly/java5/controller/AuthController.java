package vn.fpoly.java5.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.fpoly.java5.entity.Account;

import java.util.Optional;

@Controller
public class AuthController {
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    public AuthController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @RequestMapping("/auth/profile")
    public String getProfile(Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        String USER = "poly";
//        String PASS = "123";
//        if(USER.equals(username) && PASS.equals(password)){
//            model.addAttribute("message", "Dang nhap thanh cong");
//        }else{
//            model.addAttribute("message", "Dang nhap that bai");
//        }
//        model.addAttribute("username", username);
//        model.addAttribute("password", password);
        return "auth/profile";
    }

    @RequestMapping("/auth/login")
    public String login(Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean success = "user123".equals(username) && "pass123".equals(password);
        response.setStatus(success ? HttpServletResponse.SC_OK : HttpServletResponse.SC_UNAUTHORIZED);

        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("status", success ? 200 : 401);
        HttpSession session = request.getSession();

        if (success) {
            session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
        } else {
            session.invalidate();
        }

        return "auth/profile";
    }

    @RequestMapping("auth/session")
    public String getSession(Model model) {

        HttpSession session = request.getSession();

        if (session != null) {
            model.addAttribute("username", session.getAttribute("username"));
            model.addAttribute("password", session.getAttribute("password"));
        }
        return "auth/session";

    }

    @GetMapping("/auth/login-form")
    public String loginForm(Model model) {
        return "auth/login";
    }
    @PostMapping("/auth/login-form")
    public String processLoginForm(Model model, @RequestParam("username") String username,
                                   @RequestParam("password") String password) {
        if(username == "user123" && password == "pass123"){
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            model.addAttribute("status", "Đăng nhập thành công");
            return "auth/index";
        }else{
            return "auth/login";
        }
    }

    @GetMapping("/get-profile")
    public String getProfile(@RequestParam Optional<String> username, @RequestParam Optional<String> password, Model model) {
        String loggedUsername = username.orElse("guest");
        String loggedPassword = password.orElse("123456");

        model.addAttribute("loggedUsername", loggedUsername);
        model.addAttribute("loggedPassword", loggedPassword);
        model.addAttribute("message", "Đăng nhập với tài khoản:" + loggedUsername + "/" + loggedPassword);
        return "auth/profile";
    }

    @GetMapping("/register")
    public String showRegistration(Model model) {
        model.addAttribute("user",new Account());
        return "auth/register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute("account") Account account, Model model) {
        return "redirect:/auth/login-form";
    }
}
