package com.randy.backend.utils.file;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
@ConditionalOnProperty(name = "file.upload.enabled", havingValue = "true")
public interface MyFileOperator {
  String save(MultipartFile file) throws IOException;

  File get(MultipartFile file);
}
