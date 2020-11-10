package com.randy.backend.seaweedfs;

public class FileInfo {
  private String fid;
  private String url;
  private String publicUrl;
  private String count;

  private String size;

  public String getFid() {
    return fid;
  }

  public void setFid(String fid) {
    this.fid = fid;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getPublicUrl() {
    return publicUrl;
  }

  public void setPublicUrl(String publicUrl) {
    this.publicUrl = publicUrl;
  }

  public String getCount() {
    return count;
  }

  public void setCount(String count) {
    this.count = count;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }
}
