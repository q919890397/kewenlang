package com.lajilang;

public class Result {

    private Integer line;

    private Integer word;

    private Integer blankLine;

    private Integer annotationLine;

    private Integer charLine;

    private Integer codeLine;

    private boolean b = false;

    public void print(String name) {
        if (b) {
            System.out.print("文件:" + name + ",");
        }
        if (line != null) {
            System.out.print("行数：" + line + ",");
        }
        if (word != null) {
            System.out.print("单词数：" + word + ",");
        }
        if (blankLine != null) {
            System.out.print("空白行：" + blankLine + ",");
        }
        if (annotationLine != null) {
            System.out.print("注解行：" + annotationLine + ",");
        }
        if (codeLine != null) {
            System.out.print("代码行：" + codeLine + ",");
        }
        if (charLine != null) {
            System.out.print("字符数量：" + charLine + ",");
        }
        if (b) {
            System.out.println();
        }
    }

    public void addWord(int c) {
        if (word == null) {
            word = 0;
            b = true;
        }
        word += c;
    }

    public void addLine(int c) {
        if (line == null) {
            line = 0;
            b = true;
        }
        line += c;
    }

    public void addBlankLine(int c) {
        if (blankLine == null) {
            blankLine = 0;
            b = true;
        }
        blankLine += c;
    }

    public void addAnnotationLine(int c) {
        if (annotationLine == null) {
            annotationLine = 0;
            b = true;
        }
        annotationLine += c;
    }

    public void addCharLine(int c) {
        if (charLine == null) {
            charLine = 0;
            b = true;
        }
        charLine += c;
    }

    public void addCodeLine(int c) {
        if (codeLine == null) {
            codeLine = 0;
            b = true;
        }
        codeLine += c;
    }
}
