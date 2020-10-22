package com.randy.backend.common;

public class DataUtils {
  public static Object getDataValue(DataType dataType, String originValue) {
    Object value = null;
    switch (dataType) {
      case STRING:
        value = originValue;
        break;
      case INT:
        value = Integer.parseInt(originValue);
        break;
    }
    return value;
  }
}
