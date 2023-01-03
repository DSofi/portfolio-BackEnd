
package com.probando.segunda.service;

import jakarta.annotation.Resource;
import java.io.IOException;
import java.net.MalformedURLException;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadImageService {
    
    public Resource load(String filename) throws MalformedURLException;
    public String copy(MultipartFile file) throws IOException;
    public boolean delete(String filename);
    
}
