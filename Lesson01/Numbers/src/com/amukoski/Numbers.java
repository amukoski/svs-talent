package com.amukoski;

public class Numbers {
    public static void main(String[] args) {

        StringBuilder numberBuilder = new StringBuilder();

        for (String arg : args) {

            switch (arg.toLowerCase()) {
                case "one":
                    numberBuilder.append(1);
                    break;
                case "two":
                    numberBuilder.append(2);
                    break;
                case "three":
                    numberBuilder.append(3);
                    break;
                case "four":
                    numberBuilder.append(4);
                    break;
                case "five":
                    numberBuilder.append(5);
                    break;
                case "six":
                    numberBuilder.append(6);
                    break;
                case "seven":
                    numberBuilder.append(7);
                    break;
                case "eight":
                    numberBuilder.append(8);
                    break;
                case "nine":
                    numberBuilder.append(9);
                    break;
                case "zero":
                    numberBuilder.append(0);
                    break;
            }

        }

        Integer result = Integer.valueOf(numberBuilder.toString());

        System.out.println(result);
    }

}
