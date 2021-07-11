package com.dojo.kata.args.argument;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class IntegerListArgument implements Argument {
    public static String FLAG = "-i";
    public static List<Integer> DEFAULT_VALUE = new ArrayList<>();

    List<Integer> intList;

    public IntegerListArgument(List<Integer> intList) {
        this.intList = intList;
    }

    @Override
    public String toString() {
        return "-i [" + intList.stream().map(x -> x.toString()).collect(Collectors.joining(", ")) + "]";
    }
}
