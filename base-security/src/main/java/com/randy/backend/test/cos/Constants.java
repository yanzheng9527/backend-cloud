package com.randy.backend.test.cos;

public class Constants {
  public static final String APP_ID = "wxe7ee34dc846e4e41";
  public static final String SECRET = "0aef549da66503c96a64ce91ee78e267";

  public static String getWxLoginUrl(String jsCode) {
    return "https://api.weixin.qq.com/sns/jscode2session"
        + "?appid="
        + APP_ID
        + "&secret="
        + SECRET
        + "&js_code="
        + jsCode
        + "&grant_type=authorization_code";
  }

  public static final String SECRET_ID = "AKID53AffTjT7bqrunaS0KNDqQzRhtqKP2qe";
  public static final String SECRET_KEY = "eWIftLgBcyF2g7KLAj2ECxShjY7QsDQQ";
  public static final String BUCKET = "static-1300875854";
  public static final String REGION = "ap-shanghai";
  public static final String KEY_PREFIX = "fanhan/";
}
