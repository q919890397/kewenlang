package com.lajilang;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = null;
        while ((s = scanner.nextLine()) != null && !s.equals("exit")) {
            String[] strings = s.split(" ");

            boolean flag = false;

            for (String string : strings) {
                if (string.equals("-a")) {
                    flag = true;
                    break;
                }
            }



            File file = new File(strings[strings.length - 1]);
            String fileName = file.getName();
            if (!file.isDirectory()) {
                file = file.getParentFile();
            }
//            doFile(file,flag,strings,fileName);
            if (file != null && file.isDirectory()) {
                File[] files = file.listFiles(pathname -> {
                    if (pathname.isDirectory()) {
                        return true;
                    }
                    return isRight(pathname, fileName);
                });
                if (files != null) {
                    for (File file1 : files) {
                        doFile(file1, flag, strings, fileName);
                    }
                }
            } else {
                System.out.println("输入文件有误");

            }

        }
    }

    private static void doFile(File file, boolean flag, String[] args, String fileName) {
        if (file != null && file.isFile() && isRight(file, fileName)) {
            try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
                String line;
                Result result = new Result();
                while ((line = bf.readLine()) != null) {
                    analyze(line, args, result);
                }
                result.print(file.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file != null && flag && file.isDirectory()) {
            File[] files = file.listFiles(pathname -> {
                if (fileName.equals("") || pathname.isDirectory()) {
                    return true;
                }
                return isRight(pathname, fileName);
            });
            if (files != null) {
                for (File file1 : files) {
                    doFile(file1, true, args, fileName);
                }
            }
        }
    }

    private static void analyze(String line, String[] args, Result result) {
        for (String arg : args) {
            switch (arg) {
                case "-w":
                    new WordCheck(result).check(line);
                    break;
                case "-l":
                    new LineCheck(result).check(line);
                    break;
                case "-c":
                    new CharCheck(result).check(line);
                    break;
                case "-s":
                    new StructureCheck(result).check(line);
                    break;
            }
        }
    }

    private static boolean isRight(File file, String fileName) {
        if (fileName.startsWith("*")) {
            return file.getName().endsWith(fileName.substring(fileName.lastIndexOf(".")));
        } else {
            return file.getName().equals(fileName);
        }
    }
}
