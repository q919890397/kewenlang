package com.lajilang;


import java.util.ArrayList;
import java.util.List;

public class WordCheck implements Check {

    private final Result result;

    public WordCheck(Result result) {
        this.result = result;
    }

    @Override
    public void check(String s) {
        s = s.replaceAll("[\\p{Nd}\\p{Punct}\\s]", " ");
        result.addWord(splitWorker(s).length);
    }


    private String[] splitWorker(final String str) {

        if (str == null) {
            return null;
        }
        final int len = str.length();
        if (len == 0) {
            return new String[]{""};
        }
        final List<String> list = new ArrayList<>();
        int sizePlus1 = 1;
        int i = 0, start = 0;
        boolean match = false;
        final char sep = " ".charAt(0);
        while (i < len) {
            if (str.charAt(i) == sep) {
                if (match) {
                    if (sizePlus1++ == -1) {
                        i = len;
                    }
                    list.add(str.substring(start, i));
                    match = false;
                }
                start = ++i;
                continue;
            }
            match = true;
            i++;
        }
        if (match) {
            list.add(str.substring(start, i));
        }
        return list.toArray(new String[list.size()]);
    }
}
