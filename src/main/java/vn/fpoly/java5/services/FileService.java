package vn.fpoly.java5.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService implements vn.fpoly.java5.utility.FileService {

    @Override
    public File save(MultipartFile file, String folder) {
        try {
            Path folderPath = Paths.get(folder);
            if (!Files.exists(folderPath)) {
                Files.createDirectories(folderPath);
            }
            String fileName = file.getOriginalFilename();
            Path filePath = folderPath.resolve(fileName);
            file.transferTo(filePath.toFile());
            return filePath.toFile();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Byte[] read(String name, String folder) {
        try {
            Path filePath = Paths.get(folder, name);
            byte[] bytes = Files.readAllBytes(filePath);
            Byte[] result = new Byte[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                result[i] = bytes[i];
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
