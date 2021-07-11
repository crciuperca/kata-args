package com.dojo.kata.args.argument;


public class DirectoryArgument implements Argument {
    public static String FLAG = "-d";
    public static String DEFAULT_VALUE = "";

    String directory;

    public DirectoryArgument(String directory) {
        this.directory = directory;
    }

    @Override
    public String toString() {
        return "-d " + directory;
    }
}
