package com.randy.backend.test.web.controller;

import com.randy.backend.dao.mapper.ImageMapper;
import com.randy.backend.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@Transactional
@CrossOrigin
public class ImageTestController {
  @Autowired private ImageMapper imageMapper;

  @RequestMapping(value = "/uploadTest3", method = RequestMethod.POST)
  public String uploadTest3(MultipartFile file, Image image) throws IOException {
    image.setContent(file.getBytes());
    imageMapper.insert(image);
    return "success";
  }

  @RequestMapping(value = "/uploadTest4", method = RequestMethod.POST)
  public String uploadTest4(Image image) throws IOException {
    image.setContent(image.getFile().getBytes());
    imageMapper.insert(image);
    return "success";
  }

  @RequestMapping(value = "/downloadTest", method = RequestMethod.GET)
  public String download(@RequestParam("id") int id, HttpServletResponse response)
      throws IOException {
    Image image = imageMapper.getOneById(id);
    String fileName = image.getFileName();
    fileName = "test.jpg";
    // 设置文件ContentType类型，自动判断下载文件类型
    response.setContentType("multipart/form-data");
    // 设置文件头
    response.setHeader(
        "Content-Disposition",
        "attachment;fileName=" + new String(fileName.getBytes("GBK"), "ISO8859-1"));
    //    writeToOutputStream(new File(fileName), response);
    ByteArrayInputStream inputStream;
    inputStream = new ByteArrayInputStream(image.getContent());
    OutputStream out = response.getOutputStream();
    int i = 0;
    byte[] buffer = new byte[1024];
    while ((i = inputStream.read(buffer)) > 0) {
      // 写到输出流中
      out.write(buffer, 0, i);
    }
    return "success";
  }

  //  public static void writeToOutputStream(File file, HttpServletResponse response) throws
  // IOException {
  //    FileInputStream inputStream;
  //    inputStream = new FileInputStream(file);
  //    OutputStream out = response.getOutputStream();
  //    int i = 0;
  //    byte[] buffer = new byte[1024];
  //    while ((i = inputStream.read(buffer)) > 0) {
  //      //写到输出流中
  //      out.write(buffer, 0, i);
  //    }
  //  }
}
