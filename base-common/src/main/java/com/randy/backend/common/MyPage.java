package com.randy.backend.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.randy.backend.model.Entity;

public class MyPage<T extends Entity> extends Page<T> {
  public MyPage() {}

  public MyPage(long current, long size) {
    super(current, size);
  }

  public MyPage(long current, long size, long total) {
    super(current, size, total);
  }

  public MyPage(long current, long size, boolean isSearchCount) {
    super(current, size, isSearchCount);
  }

  public MyPage(long current, long size, long total, boolean isSearchCount) {
    super(current, size, total, isSearchCount);
  }
}
