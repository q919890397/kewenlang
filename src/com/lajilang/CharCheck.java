package com.lajilang;


public class CharCheck implements Check {

    private final Result result;

    public CharCheck(Result result) {
        this.result = result;
    }

    @Override
    public void check(String s) {
        result.addCharLine(s.length());
    }
}
