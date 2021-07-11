package com.dojo.kata.args.argument;


public class LogsArgument implements Argument {
    public static String FLAG = "-l";
    public static boolean DEFAULT_VALUE = false;

    boolean enabled;

    public LogsArgument(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "-l " + enabled;
    }
}
