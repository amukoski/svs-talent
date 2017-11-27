package com.amukoski;

import com.amukoski.zip.ZipCode;
import com.amukoski.zip.exception.InvalidZipCodeException;

public class Application {
    public static void main(String[] args){
        ZipCode zipCode = new ZipCode();

        try {
            zipCode.setValue("12345");
            System.out.println(zipCode);
        } catch (InvalidZipCodeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            zipCode.setValue("123456");     // value length 6
            System.out.println(zipCode);
        } catch (InvalidZipCodeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            zipCode.setValue("1234a");      // value with chars
            System.out.println(zipCode);
        } catch (InvalidZipCodeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println();
        try {
            System.out.println(new ZipCode("123456789"));
        } catch (InvalidZipCodeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
