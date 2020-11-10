package com.randy.backend.test.cos;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;

import java.io.File;

public class COSUploadTest {
  private static String fileName = "HospitalInfo.png";
  private static String key = Constants.KEY_PREFIX + fileName;

  // 将本地文件上传到COS
  public static void SimpleUploadFileFromLocal(String uploadFilePath) {
    // 1 初始化用户身份信息(secretId, secretKey)
    COSCredentials cred = new BasicCOSCredentials(Constants.SECRET_ID, Constants.SECRET_KEY);
    // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
    ClientConfig clientConfig = new ClientConfig(new Region(Constants.REGION));
    // 3 生成cos客户端
    COSClient cosClient = new COSClient(cred, clientConfig);

    // bucket名需包含appid
    String bucketName = Constants.BUCKET;

    File localFile = new File(uploadFilePath);
    PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);

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

  public static void download(String downloadFilePath) {
    // 1 初始化用户身份信息(secretId, secretKey)
    COSCredentials cred = new BasicCOSCredentials(Constants.SECRET_ID, Constants.SECRET_KEY);
    // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
    ClientConfig clientConfig = new ClientConfig(new Region(Constants.REGION));
    // 3 生成cos客户端
    COSClient cosClient = new COSClient(cred, clientConfig);
    File downFile = new File(downloadFilePath);
    GetObjectRequest getObjectRequest = new GetObjectRequest(Constants.BUCKET, key);
    ObjectMetadata downObjectMeta = cosClient.getObject(getObjectRequest, downFile);
    // 关闭客户端
    cosClient.shutdown();
  }

  public static void main(String[] args) throws Exception {
    String uploadFilePath = "C:\\upload\\" + fileName;
    SimpleUploadFileFromLocal(uploadFilePath);
    //    String downloadFilePath = "C:\\upload\\download\\" + fileName;
    //    download(downloadFilePath);
  }
}
