package util;

import java.util.Scanner;

public class InputUtil {
    private InputUtil() {
    }

    private static InputUtil inputUtil;

    public static InputUtil getInstance() {
        return inputUtil == null ? new InputUtil() : inputUtil;
    }

    public Byte inputByte(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextByte();
    }
    public Double inputDouble(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextDouble();
    }
    public String inputString(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.next();
    }
}