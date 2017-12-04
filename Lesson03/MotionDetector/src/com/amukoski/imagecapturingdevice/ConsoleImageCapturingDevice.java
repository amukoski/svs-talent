package com.amukoski.imagecapturingdevice;

import java.util.Scanner;

public class ConsoleImageCapturingDevice implements ImageCapturingDevice {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public byte[] captureImage() {
        String image = scanner.nextLine();
        return image.getBytes();
    }
}
