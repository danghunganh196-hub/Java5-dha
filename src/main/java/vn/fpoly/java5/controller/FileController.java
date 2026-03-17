package vn.fpoly.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;

@Controller
@RequestMapping("/file")
public class FileController {
    @GetMapping("/upload")
    public String upload() {
        return "file/upload";
    }

    @PostMapping("/upload")
    public String processFileUpload(@RequestPart("file") MultipartFile file, Model model) {
        if(file.isEmpty()) {
            model.addAttribute("message", "Vui lòng chọn tệp tin");
            return "file/upload";
        }
        try {
            String uploadDir = "D:/JavaJavaJavaJavaJavaJava5/Java5/src/main/resources/static/upload";
            File uploadFolder = new File(uploadDir);
            if (!uploadFolder.exists()) {
                boolean mkdir = uploadFolder.mkdir();
            }
            File saveFile = new File(uploadFolder, Objects.requireNonNull(file.getOriginalFilename()));
            file.transferTo(saveFile);
            model.addAttribute("message","Tải tệp tin thành công");
        }catch(Exception e) {
            e.printStackTrace();
        }
        return "file/upload";
    }
}
