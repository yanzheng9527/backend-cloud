package com.randy.backend.test.web.controller;

import com.randy.backend.utils.file.MyFileOperator;
import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@RestController
@RequestMapping("/test")
public class UploadTestController {
  //  @Value("${my.file.operator}")
  //  public String myFileOperatorStr;

  //  @Autowired
  //  @Qualifier("${my.file.operator}")
  @Resource(name = "${my.file.operator}")
  MyFileOperator myFileOperator;

  //  @RequestMapping(value = "/test1", method = RequestMethod.GET)
  //  public String test1() {
  //    System.out.println("MyFileOperator:" + myFileOperatorStr);
  //    return this.myFileOperatorStr;
  //  }

  @RequestMapping(value = "/uploadTest1", method = RequestMethod.POST)
  public String uploadTest1(MultipartFile file) throws IOException {
    if (!file.isEmpty()) {
      String fileName = file.getOriginalFilename();
      String path = "C:\\upload";
      File localFile = new File(path, fileName);
      file.transferTo(localFile);
    }
    return "success";
  }

  @RequestMapping(value = "/uploadTest2", method = RequestMethod.POST)
  public String uploadTest2(MultipartFile[] files) throws IOException {
    if (files == null || files.length == 0) {
      return "请选择要上传的文件";
    }
    for (int i = 0; i < files.length; i++) {
      MultipartFile file = files[i];
      if (!file.isEmpty()) {
        String fileName = file.getOriginalFilename();
        //        fileName += UUID.randomUUID() + "&" + fileName;
        String path = "C:\\upload";
        File localFile = new File(path, fileName);
        file.transferTo(localFile);
      }
    }
    return "success";
  }

  @RequestMapping(value = "/uploadTest3", method = RequestMethod.POST)
  public String uploadTest3(MultipartFile[] files) throws IOException {
    if (files == null || files.length == 0) {
      return "请选择要上传的文件";
    }
    for (int i = 0; i < files.length; i++) {
      MultipartFile file = files[i];
      if (!file.isEmpty()) {
        //        String fileName = file.getOriginalFilename();
        //        fileName += UUID.randomUUID() + "&" + fileName;
        //        String path = "C:\\upload";
        //        File localFile = new File(path, fileName);
        //        file.transferTo(localFile);
        //        MyFileOperator myFileOperator = (MyFileOperator)
        // SpringBeanUtil.getBean(myFileOperatorStr);
        myFileOperator.save(file);
      }
    }
    return "success";
  }

  @RequestMapping(value = "/uploadTest4", method = RequestMethod.POST)
  public String uploadTest4(MultipartFile[] files) throws IOException {
    if (files == null || files.length == 0) {
      return "请选择要上传的文件";
    }
    for (int i = 0; i < files.length; i++) {
      MultipartFile file = files[i];
      if (!file.isEmpty()) {
        String fileName = myFileOperator.save(file);
        System.out.println("fileName:" + fileName);
      }
    }
    return "success";
  }

  @RequestMapping(value = "/downloadTest1", method = RequestMethod.GET)
  public String downloadTest1(String fileName, HttpServletResponse response) throws IOException {
    fileName = "image1.png";
    String path = "C:\\upload";
    File file = new File(path, fileName);
    // 设置文件ContentType类型，自动判断下载文件类型
    response.setContentType("multipart/form-data");
    // 设置文件头
    response.setHeader(
        "Content-Disposition",
        "attachment;fileName=" + new String(fileName.getBytes("GBK"), "ISO8859-1"));
    //    writeToOutputStream(new File(fileName), response);
    FileInputStream inputStream = new FileInputStream(file);
    OutputStream out = response.getOutputStream();
    int i = 0;
    byte[] buffer = new byte[1024];
    while ((i = inputStream.read(buffer)) > 0) {
      // 写到输出流中
      out.write(buffer, 0, i);
    }
    return "success";
  }

  @RequestMapping(value = "/downloadTest2")
  public ResponseEntity<byte[]> download(
      HttpServletRequest request,
      @RequestParam("filename") String filename,
      @RequestHeader("User-Agent") String userAgent,
      Model model)
      throws Exception {
    // 下载文件路径
    //    String path = request.getServletContext().getRealPath("/upload/");
    String path = "C:\\upload";
    // 构建File
    //    File file = new File(path + File.separator + filename);
    File file = new File(path, filename);
    // ok表示Http协议中的状态 200
    ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
    // 内容长度
    builder.contentLength(file.length());
    // application/octet-stream ： 二进制流数据（最常见的文件下载）。
    builder.contentType(MediaType.APPLICATION_OCTET_STREAM);
    // 使用URLDecoder.decode对文件名进行解码
    filename = URLEncoder.encode(filename, "UTF-8");
    // 设置实际的响应文件名，告诉浏览器文件要用于【下载】、【保存】attachment 以附件形式
    // 不同的浏览器，处理方式不同，要根据浏览器版本进行区别判断
    if (userAgent.indexOf("MSIE") > 0) {
      // 如果是IE，只需要用UTF-8字符集进行URL编码即可
      builder.header("Content-Disposition", "attachment; filename=" + filename);
    } else {
      // 而FireFox、Chrome等浏览器，则需要说明编码的字符集
      // 注意filename后面有个*号，在UTF-8后面有两个单引号！
      builder.header("Content-Disposition", "attachment; filename*=UTF-8''" + filename);
    }
    return builder.body(FileUtils.readFileToByteArray(file));
  }
}
