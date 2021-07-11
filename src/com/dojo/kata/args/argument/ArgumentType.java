package com.dojo.kata.args.argument;


public enum ArgumentType {
    LOGS(LogsArgument.FLAG), PORT(PortArgument.FLAG), DIRECTORY(DirectoryArgument.FLAG),
    STRING_LIST(StringListArgument.FLAG), INTEGER_LIST(IntegerListArgument.FLAG);

    private String arg;

    public String getArg() {
        return arg;
    }

    ArgumentType(String arg) {
        this.arg = arg;
    }

}
