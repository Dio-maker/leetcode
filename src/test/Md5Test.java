package test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class Md5Test {
    public static void main(String[] args)  {
//        ArrayList<String> list = new ArrayList<>();
//        try {
//            String s = getMd5("hello");
//            int count = 1;
//            while (!s.equals(getMd5(s))){
//                s=getMd5(s);
//
//            }
//            System.out.println(s);
//
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }

        String a = "ss";
        System.out.println(a.substring(a.length()-10));
//        System.out.println(new Random().nextInt(10*Math.));
    }

    public static String getMd5(String str) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(str.getBytes());
        return new BigInteger(1,digest.digest()).toString(16);
    }
}