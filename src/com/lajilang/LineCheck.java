package com.lajilang;


public class LineCheck implements Check {

    private final Result result;

    public LineCheck(Result result) {
        this.result = result;
    }

    @Override
    public void check(String s) {
        result.addLine(1);
    }

}
