package com.randy.backend.test.cos;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.tencent.cloud.CosStsClient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;
import java.util.TreeMap;

/** SimpleUpload 给出了简单上传的示例 */
public class SimpleUploadFileDemo {
  private static String tmpSecretId =
      "AKIDa7AnERVgmcwPKtr5XB3VHcFd3hSu0e76DYiW8Kae9acfTmmprdluEOajXWp_35_H";
  private static String tmpSecretKey = "rW0DXDs7RMO+/KjKteeMCP8pVGuVtPyw+4Psh1eYRzY=";
  private static String sessionToken =
      "EfvHREvijezOO5pSM6gPWnVz3gdEVQ6Y919650c1cc8c20450dac2d4ee472a2f8CUT_bTjTLb2zxv3Yzy3ZR-bqqzh9sXv8hBMTmZfHS1qXX55FDCMKZRAl2_38qtdrY861eg8CysyYv5y-xxu5qxEugqBfeAcBxrWPnHbEXG2AEv4z0LCdklSDasmjhMF81P6o7cqsRq9w4nNm1dnaA6kfAnSkTukd4J51Kc6CpAseHa6qqPeKl4swU-TACpHb";

  // 将本地文件上传到COS
  public static void SimpleUploadFileFromLocal(boolean useTrafficLimit) {
    // 1 初始化用户身份信息(secretId, secretKey)
    COSCredentials cred = new BasicCOSCredentials(Constants.SECRET_ID, Constants.SECRET_KEY);
    // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
    ClientConfig clientConfig = new ClientConfig(new Region(Constants.REGION));
    // 3 生成cos客户端
    COSClient cosClient = new COSClient(cred, clientConfig);

    //    // 1 传入获取到的临时密钥 (tmpSecretId, tmpSecretKey, sessionToken)
    //    BasicSessionCredentials cred =
    //        new BasicSessionCredentials(tmpSecretId, tmpSecretKey, sessionToken);
    //    // 2 设置 bucket 的区域, COS 地域的简称请参阅 https://cloud.tencent.com/document/product/436/6224
    //    // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参阅源码或者常见问题 Java SDK 部分
    //    Region region = new Region(Constants.REGION);
    //    ClientConfig clientConfig = new ClientConfig(region);
    //    // 3 生成 cos 客户端
    //    COSClient cosClient = new COSClient(cred, clientConfig);

    // bucket名需包含appid
    String bucketName = Constants.BUCKET;

    String key = "fanhan/aaa.png";
    File localFile = new File("C:\\upload\\image1.png");
    PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
    if (useTrafficLimit) {
      // 限流使用的单位是bit/s, 这里测试1MB/s的上传带宽限制
      putObjectRequest.setTrafficLimit(8 * 1024 * 1024);
    }
    // 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
    putObjectRequest.setStorageClass(StorageClass.Standard_IA);
    try {
      PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
      // putobjectResult会返回文件的etag
      String etag = putObjectResult.getETag();
    } catch (CosServiceException e) {
      e.printStackTrace();
    } catch (CosClientException e) {
      e.printStackTrace();
    }

    // 关闭客户端
    cosClient.shutdown();
  }

  // 从输入流进行读取并上传到COS
  public static void SimpleUploadFileFromStream() {
    // 1 初始化用户身份信息(secretId, secretKey)
    COSCredentials cred = new BasicCOSCredentials("AKIDXXXXXXXX", "1A2Z3YYYYYYYYYY");
    // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
    ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing-1"));
    // 3 生成cos客户端
    COSClient cosclient = new COSClient(cred, clientConfig);
    // bucket名需包含appid
    String bucketName = "mybucket-1251668577";

    String key = "aaa/bbb.jpg";
    File localFile = new File("src/test/resources/len10M.txt");

    InputStream input = new ByteArrayInputStream(new byte[10]);
    ObjectMetadata objectMetadata = new ObjectMetadata();
    // 从输入流上传必须制定content length, 否则http客户端可能会缓存所有数据，存在内存OOM的情况
    objectMetadata.setContentLength(10);
    // 默认下载时根据cos路径key的后缀返回响应的contenttype, 上传时设置contenttype会覆盖默认值
    objectMetadata.setContentType("image/jpeg");

    PutObjectRequest putObjectRequest =
        new PutObjectRequest(bucketName, key, input, objectMetadata);
    // 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
    putObjectRequest.setStorageClass(StorageClass.Standard_IA);
    try {
      PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
      // putobjectResult会返回文件的etag
      String etag = putObjectResult.getETag();
    } catch (CosServiceException e) {
      e.printStackTrace();
    } catch (CosClientException e) {
      e.printStackTrace();
    }

    // 关闭客户端
    cosclient.shutdown();
  }

  public static String getTempCredential() {
    TreeMap<String, Object> config = new TreeMap<String, Object>();
    try {
      // 替换为您的 SecretId
      config.put("SecretId", Constants.SECRET_ID);
      // 替换为您的 SecretKey
      config.put("SecretKey", Constants.SECRET_KEY);

      // 临时密钥有效时长，单位是秒，默认1800秒，最长可设定有效期为7200秒
      config.put("durationSeconds", 1800);

      // 换成您的 bucket
      config.put("bucket", Constants.BUCKET);
      // 换成 bucket 所在地区
      config.put("region", Constants.REGION);

      // 这里改成允许的路径前缀，可以根据自己网站的用户登录态判断允许上传的具体路径，例子：a.jpg 或者 a/* 或者 * 。
      // 如果填写了“*”，将允许用户访问所有资源；除非业务需要，否则请按照最小权限原则授予用户相应的访问权限范围。
      config.put("allowPrefix", "*");

      // 密钥的权限列表。简单上传、表单上传和分片上传需要以下的权限，其他权限列表请看 https://cloud.tencent.com/document/product/436/31923
      String[] allowActions =
          new String[] {
            // 所有权
            //                    // 简单上传
            "name/cos:*"
            //                    "name/cos:PutObject",
            //                    // 表单上传、小程序上传
            //                    "name/cos:PostObject",
            //             "name/cos:GetObject",
            //             "name/cos:DeleteObject",
            //                    "name/cos:HeadObject",
            //                    "name/cos:OptionsObject",
            //                    "name/cos:ListObject",
            //                    "name/cos:GetObjectUrl",
            //                    // 分片上传
            //                    "name/cos:InitiateMultipartUpload",
            //                    "name/cos:ListMultipartUploads",
            //                    "name/cos:ListParts",
            //                    "name/cos:UploadPart",
            //                    "name/cos:CompleteMultipartUpload"
          };
      config.put("allowActions", allowActions);

      org.json.JSONObject jsonObject = CosStsClient.getCredential(config);
      System.out.println("jsonObject:" + jsonObject);
      return jsonObject.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return "fail";
    }
  }

  public static String generatePresignedUrl() {
    // 1 初始化用户身份信息(secretId, secretKey)
    COSCredentials cred = new BasicCOSCredentials(Constants.SECRET_ID, Constants.SECRET_KEY);
    // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
    ClientConfig clientConfig = new ClientConfig(new Region(Constants.REGION));
    // 3 生成 cos 客户端
    COSClient cosclient = new COSClient(cred, clientConfig);
    // bucket名需包含appid
    String bucketName = Constants.BUCKET;
    String key = " fanhan/test.png";
    Date expirationTime = new Date(System.currentTimeMillis() + 30 * 60 * 1000);
    // 生成预签名上传 URL
    URL url = cosclient.generatePresignedUrl(bucketName, key, expirationTime, HttpMethodName.PUT);
    System.out.println("url:" + url);
    return url.toString();
  }

  public static int upLoadFileByFile(String singnedurl, String fileName) throws Exception {
    URL url = new URL(singnedurl);
    FileInputStream fileInputStream = new FileInputStream(fileName);
    int responseCode = 0;
    try {
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setDoOutput(true);
      connection.setRequestMethod("PUT");
      DataOutputStream out = new DataOutputStream(connection.getOutputStream());

      //      out = new OutputStreamWriter(new FileOutputStream(new File("c:/qqq.zip")));
      // out=new OutputStreamWriter(new FileOutputStream(new File("c:/qqq.zip")));
      // 写入要上传的数据
      byte buff[] = new byte[1024];
      int len;
      while ((len = fileInputStream.read(buff)) != -1) {
        out.write(buff, 0, len);
      }
      out.close();
      responseCode = connection.getResponseCode();
      System.out.println("Service returned response code " + responseCode);
    } catch (ProtocolException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return responseCode;
  }

  public static void download() {
    // 1 初始化用户身份信息(secretId, secretKey)
    COSCredentials cred = new BasicCOSCredentials(Constants.SECRET_ID, Constants.SECRET_KEY);
    // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
    ClientConfig clientConfig = new ClientConfig(new Region(Constants.REGION));
    // 3 生成cos客户端
    COSClient cosClient = new COSClient(cred, clientConfig);
    String outputFilePath = "C:\\upload\\download\\bbb.png";
    File downFile = new File(outputFilePath);
    GetObjectRequest getObjectRequest = new GetObjectRequest(Constants.BUCKET, "fanhan/aaa.png");
    ObjectMetadata downObjectMeta = cosClient.getObject(getObjectRequest, downFile);
  }

  public static void main(String[] args) throws Exception {
    //    getTempCredential();
    //    SimpleUploadFileFromLocal(false);
    //    String uploadUrl = generatePresignedUrl();
    //    upLoadFileByFile(uploadUrl, "C:\\upload\\image1.png");
    download();
  }
}
