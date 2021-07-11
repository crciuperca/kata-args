package com.dojo.kata.args.argument;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class StringListArgument implements Argument {
    public static String FLAG = "-g";
    public static List<String> DEFAULT_VALUE = new ArrayList<>();

    List<String> stringList;

    public StringListArgument(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public String toString() {
        return "-g [" + stringList.stream().collect(Collectors.joining(", ")) + "]";
    }
}
