package com.dojo.kata.args;

import com.dojo.kata.args.argument.Argument;
import com.dojo.kata.args.factory.ArgumentFactory;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        ArgumentFactory argumentFactory = new ArgumentFactory();
        List<Argument> argumentList = argumentFactory.getArguments(args);


        System.out.println("\nProcessed:");
        argumentList.forEach(arg -> System.out.println(arg));
    }
}
