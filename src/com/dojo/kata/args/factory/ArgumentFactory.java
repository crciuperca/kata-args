package com.dojo.kata.args.factory;

import com.dojo.kata.args.argument.Argument;
import com.dojo.kata.args.argument.ArgumentType;
import com.dojo.kata.args.argument.DirectoryArgument;
import com.dojo.kata.args.argument.IntegerListArgument;
import com.dojo.kata.args.argument.LogsArgument;
import com.dojo.kata.args.argument.PortArgument;
import com.dojo.kata.args.argument.StringListArgument;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ArgumentFactory {

    public List<Argument> getArguments(String[] args) {
        return Arrays.stream(ArgumentType.values()).toList().stream()
                .map(argType -> getArgument(Arrays.stream(args).toList(), argType))
                .collect(Collectors.toList());
    }

    private Argument getArgument(List<String> args, ArgumentType type) {
        Argument arg = null;
        switch (type) {
            case LOGS:
                arg = new LogsArgument(getLogValueAndCheckForErrors(args));
                break;
            case PORT:
                arg = new PortArgument(getPortValueAndCheckForErrors(args));
                break;
            case DIRECTORY:
                arg = new DirectoryArgument(getDirectoryValueAndCheckForErrors(args));
                break;
            case STRING_LIST:
                arg = new StringListArgument(getStringListValueAndCheckForErrors(args));
                break;
            case INTEGER_LIST:
                arg = new IntegerListArgument(getIntegerListValueAndCheckForErrors(args));
                break;
        }
        return arg;
    }


    private Boolean getLogValueAndCheckForErrors(List<String> args) {
        String value = getArgValue(args, LogsArgument.FLAG);
        if (value != null && !argHasNoValue(value)) {
            System.out.println("-l doesn't take any parameter. Current usage: \"-l " + value + "\"");
        }
        return args.stream().anyMatch(arg -> LogsArgument.FLAG.equals(arg));
    }

    private int getPortValueAndCheckForErrors(List<String> args) {
        int port = PortArgument.DEFAULT_VALUE;
        String value = getArgValue(args, PortArgument.FLAG);

        if (value == null || argHasNoValue(value)) {
            System.out.println("-p requires an integer parameter.");
        } else {
            try {
                port = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("-p requires an integer parameter. Current usage: \"-l " + value + "\"");
            }
        }
        return port;
    }

    private String getDirectoryValueAndCheckForErrors(List<String> args) {
        String value = getArgValue(args, DirectoryArgument.FLAG);

        if (value == null || argHasNoValue(value)) {
            System.out.println("-d requires a string parameter.");
            return DirectoryArgument.DEFAULT_VALUE;
        } else {
            return value;
        }
    }

    private List<String> getStringListValueAndCheckForErrors(List<String> args) {
        String value = getArgValue(args, StringListArgument.FLAG);

        if (value == null || argHasNoValue(value)) {
            System.out.println("-g requires a string list parameter.");
            return StringListArgument.DEFAULT_VALUE;
        } else {
            return Arrays.stream(value.split(",")).toList();
        }
    }

    private List<Integer> getIntegerListValueAndCheckForErrors(List<String> args) {
        List<Integer> integerList = IntegerListArgument.DEFAULT_VALUE;
        String value = getArgValue(args, IntegerListArgument.FLAG);

        if (value == null || argHasNoValue(value)) {
            System.out.println("-i requires an integer list parameter.");
        } else {
            try {
                integerList = Arrays.stream(value.split(",")).map(integerString -> Integer.parseInt(integerString)).collect(Collectors.toList());
            } catch (NumberFormatException e) {
                System.out.println("-i requires a valid integer list parameter. Current usage: \"-l " + value + "\"");
            }
        }
        return integerList;
    }


    private String getArgValue(List<String> args, String arg) {
        int argIdx = args.indexOf(arg);
        if (argIdx == -1 || argIdx == args.size() - 1) {
            return null;
        }
        return args.get(argIdx + 1);
    }

    private boolean argHasNoValue(String value) {
        return Arrays.stream(ArgumentType.values()).toList().stream()
                .map(type -> type.getArg())
                .anyMatch(arg -> arg.equals(value));
    }
}
