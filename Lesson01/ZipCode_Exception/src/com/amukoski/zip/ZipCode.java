package com.amukoski.zip;


import com.amukoski.zip.exception.InvalidZipCodeException;

public class ZipCode {

    private String value;

    public ZipCode() {
    }

    public ZipCode(String value) throws InvalidZipCodeException {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) throws InvalidZipCodeException {
        String zipCodeTrimmed = value.trim();
        int length = zipCodeTrimmed.length();

        InvalidZipCodeException invalidZipCodeException =
                new InvalidZipCodeException("ZipCode must contain only 5 or 9 DIGITS!");

        if (zipCodeTrimmed.matches("[0-9]+") && (length == 5 || length == 9)) {
            this.value = zipCodeTrimmed;
        }else {
            throw invalidZipCodeException;
        }
    }

    @Override
    public String toString() {
        return "ZipCode: " + this.value;
    }
}