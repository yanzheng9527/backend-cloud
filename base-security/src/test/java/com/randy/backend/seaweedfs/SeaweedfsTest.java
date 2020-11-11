package com.randy.backend.seaweedfs;

import com.randy.backend.BaseSecurityApplication;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = {BaseSecurityApplication.class})
public class SeaweedfsTest {
  @Autowired private TestRestTemplate testRestTemplate;

  private String fid = "6,0c8a8ed7fe";

  private String url = "http://39.98.185.90:8080";

  @Ignore
  @Test
  public void getFidTest() {
    FileInfo fidInfo =
        testRestTemplate.getForObject("http://39.98.185.90:9333/dir/assign", FileInfo.class);
    System.out.println("fid: " + fidInfo.getFid());
    this.fid = fid;
  }

  @Ignore
  @Test
  public void uploadTest() {
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    MediaType mediaType = MediaType.parseMediaType("multipart/form-data");
    headers.setContentType(mediaType);

    String filename = "image3.png";
    FileSystemResource fileSystemResource = new FileSystemResource("C:\\upload\\" + filename);
    MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
    form.add("file", fileSystemResource);
    form.add("filename", filename);

    HttpEntity<MultiValueMap<String, Object>> files = new HttpEntity<>(form, headers);
    String result = restTemplate.postForObject(url + "/" + fid, files, String.class);
    System.out.println("result:" + result);
  }

  @Ignore
  @Test
  public void deleteTest() {
    testRestTemplate.delete(url + "/" + fid);
  }

  @Test
  public void deleteTest2() {
    // delete, entity直接设为null即可
    ResponseEntity<FileInfo> resultEntity =
        testRestTemplate.exchange(url + "/" + fid, HttpMethod.DELETE, null, FileInfo.class);
    if (resultEntity != null) {
      System.out.println("result:" + resultEntity.getBody().getSize());
    } else {
      System.out.println("result is null");
    }
  }
}
