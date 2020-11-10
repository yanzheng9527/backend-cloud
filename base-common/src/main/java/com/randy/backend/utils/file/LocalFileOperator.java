package com.randy.backend.utils.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component("LocalFileOperator")
@ConditionalOnProperty(name = "file.upload.enabled", havingValue = "true")
public class LocalFileOperator implements MyFileOperator {
  @Value("${file.upload.dir}")
  public String uploadDir;

  public String save(MultipartFile file) throws IOException {
    String fileName = file.getOriginalFilename();
    File localFile = new File(uploadDir, fileName);
    file.transferTo(localFile);
    return fileName;
  }

  public File get(MultipartFile file) {
    return null;
  }
}
