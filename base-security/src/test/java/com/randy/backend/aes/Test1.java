package com.randy.backend.aes;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Test1 {
  public static void main(String[] args) throws NoSuchAlgorithmException {
    KeyGenerator keygen = KeyGenerator.getInstance("AES");
    SecureRandom random = new SecureRandom();
    keygen.init(random);
    Key key = keygen.generateKey();
    System.out.println(key.toString());
  }
}
