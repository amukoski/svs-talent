package com.amukoski.zip;

public class ZipCode {

    private String value;

    public ZipCode() {
    }

    public ZipCode(String value) {
        setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        String zipCodeTrimmed = value.trim();

        if (!zipCodeTrimmed.matches("[0-9]+")) {
            return;
        }

        int length = zipCodeTrimmed.length();

        if (length == 5 || length == 9) {
            this.value = zipCodeTrimmed;
        }
    }

    @Override
    public String toString() {
        return "ZipCode: " + this.value;
    }
}