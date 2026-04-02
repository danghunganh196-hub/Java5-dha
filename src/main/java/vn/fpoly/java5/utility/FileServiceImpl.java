package vn.fpoly.java5.utility;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service("fileService")
public class FileServiceImpl implements FileService {
    @Override
    public File save (MultipartFile file, String folder){
        try{
            Path folderPath = Paths.get(folder);
            if(!Files.exists(folderPath)){
                Files.createDirectory(folderPath);
            }
            String originalFilename = file.getOriginalFilename();
            if(originalFilename == null){
                throw new RuntimeException("Invalid original filename");
            }
            Path filePath = folderPath.resolve(originalFilename);
            Files.write(filePath, file.getBytes());
            return filePath.toFile();

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    };

    @Override
    public Byte [] read(String name, String folder){
        try{
            Path filePath = Paths.get(folder, name);
            if(!Files.exists(filePath)){
                throw new RuntimeException("File not found");
            }
            byte[] bytes = Files.readAllBytes(filePath);
            Byte[] byteArr = new Byte[bytes.length];
            for(int i=0; i<bytes.length ; i++){
                byteArr[i] = bytes[i];
            }
            return byteArr;
        }catch(Exception e){
            throw new RuntimeException("cannot read file");
        }
    };
}
