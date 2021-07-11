package com.dojo.kata.args.argument;


public class PortArgument implements Argument {
    public static String FLAG = "-p";
    public static int DEFAULT_VALUE = 0;

    int port;

    public PortArgument(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "-p " + port;
    }
}
