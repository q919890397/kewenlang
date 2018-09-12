package com.lajilang;


public class StructureCheck implements Check {

    private final Result result;


    public StructureCheck(Result result) {
        this.result = result;
    }

    @Override
    public void check(String s) {
        if (s.length() == 0) {
            result.addBlankLine(1);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length()-1 && s.charAt(i) == ' ') {
                result.addBlankLine(1);
                return;
            }
            if (s.charAt(i) != ' ') {
                break;
            }
        }
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '/') {
                result.addAnnotationLine(1);
                return;
            }

            if (s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '*') {
                flag=true;
            }
            if (s.charAt(i) == '*' && i + 1 < s.length() && s.charAt(i + 1) == '/' && flag) {
                result.addAnnotationLine(1);
                return;
            }
        }

        result.addCodeLine(1);
    }
}
