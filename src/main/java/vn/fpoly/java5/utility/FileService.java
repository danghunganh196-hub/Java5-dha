package vn.fpoly.java5.utility;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileService {
    File save (MultipartFile file, String folder);
    Byte [] read(String name, String folder);
}


