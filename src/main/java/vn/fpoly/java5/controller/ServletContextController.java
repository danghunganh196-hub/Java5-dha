package vn.fpoly.java5.controller;

import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServletContextController {
    private final ServletContext servletContext;
    public ServletContextController(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    @RequestMapping("/get-context-info")
    public String getContextInfo(Model model) {
        String contextPath = servletContext.getContextPath();
        String contextInfo = servletContext.getServerInfo();
        String realPath = servletContext.getRealPath("/");

        model.addAttribute("contextPath", contextPath);
        model.addAttribute("serverInfo", contextInfo);
        model.addAttribute("realPath", realPath);

        return "auth/get-context-info";
    }
}
