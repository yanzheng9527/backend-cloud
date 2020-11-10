package com.randy.backend.utils.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component("SeaweedfsFileOperator")
@ConditionalOnProperty(name = "file.upload.enabled", havingValue = "true")
public class SeaweedfsFileOperator implements MyFileOperator {
  @Value("${file.upload.dir}")
  public String uploadDir;

  @Value("${seaweedfs.master.ip:}")
  public String seaweedfsMasterIP;

  @Autowired LocalFileOperator localFileOperator;

  public String save(MultipartFile file) throws IOException {
    String fileName = localFileOperator.save(file);
    File tempFile = new File(uploadDir, fileName);

    // 从seaweedfs master上获得文件存储的地址
    SeaweedfsFileInfo seaweedfsFileInfo = getSeaweedfsFileInfo();
    String fid = seaweedfsFileInfo.getFid();
    String seaweedVolumePublicUrl = "http://" + seaweedfsFileInfo.getPublicUrl() + "/" + fid;
    System.out.println("seaweedfsFileInfo:" + seaweedVolumePublicUrl);

    // 获取文件属性（还要额外形参这里就不给出了） 一系列的存表 操作
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Accept", MediaType.APPLICATION_JSON.toString());
    headers.setContentType(MediaType.parseMediaType("multipart/form-data;charset=UTF-8"));
    MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();

    // MultipartFile 直接转 fileSystemResource 是不行的
    // 把临时文件变成FileSystemResource
    FileSystemResource resource = new FileSystemResource(tempFile);
    param.add("file", resource);

    HttpEntity<MultiValueMap<String, Object>> fileEntity = new HttpEntity<>(param, headers);
    String result = restTemplate.postForObject(seaweedVolumePublicUrl, fileEntity, String.class);
    System.out.println("result:" + result);

    tempFile.delete(); // 删除临时文件文件
    return fid;
  }

  public File get(MultipartFile file) {
    return null;
  }

  public SeaweedfsFileInfo getSeaweedfsFileInfo() {
    RestTemplate restTemplate = new RestTemplate();
    SeaweedfsFileInfo fileInfo =
        restTemplate.getForObject(seaweedfsMasterIP + "/dir/assign", SeaweedfsFileInfo.class);
    System.out.println("fid: " + fileInfo.getFid());
    return fileInfo;
  }
}
