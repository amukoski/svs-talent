package com.amukoski;

import com.amukoski.zip.ZipCode;

public class Application {
    public static void main(String[] args) {
        ZipCode zipCode = new ZipCode();

        zipCode.setValue("12345");      // digits:5   OK
        System.out.println(zipCode);

        zipCode.setValue("123456");     // length 6   NOK
        System.out.println(zipCode);

        zipCode.setValue("1234a");      // not all digits NOK
        System.out.println(zipCode);

        System.out.println();
        System.out.println(new ZipCode("123456789")); // digits:9 OK
    }
}
