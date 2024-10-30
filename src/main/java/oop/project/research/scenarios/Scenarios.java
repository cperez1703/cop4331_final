package oop.project.research.scenarios;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParserException;

import java.util.Map;

public class Scenarios {

    public static Result<Map<String, Object>> parse(String command) {
        //Note: argparse4j only accepts String[] arguments as it's designed for
        //use with Java's main method. However, if we have only a String command
        //(like when reading from user input), this places the burden on use to
        //handle. There are other disadvantages as well; but TLDR this is a
        //hacky string-based solution that is good enough for this assignment.
        //For the final project, you'll implement you're own version that
        //supports this behavior and fixes some related issues.
        var split = command.split(" ", 2);
        var base = split[0];
        var arguments = split.length == 2 ? split[1].split(" ") : new String[] {};
        return switch (base) {
            case "add" -> add(arguments);
            case "sub" -> sub(arguments);
            case "fizzbuzz" -> fizzbuzz(arguments);
            case "difficulty" -> difficulty(arguments);
            case "echo" -> echo(arguments);
            case "search" -> search(arguments);
            case "weekday" -> weekday(arguments);
            default -> throw new AssertionError("Undefined command " + base + ".");
        };
    }

    private static Result<Map<String, Object>> add(String[] arguments) {
        var parser = ArgumentParsers.newFor("add").build();
        parser.addArgument("left").type(int.class);
        parser.addArgument("right").type(int.class);
        try {
            var namespace = parser.parseArgs(arguments);
            //Note: namespace.getAttrs() returns a Map directly, but a major
            //part of this problem is to ensure we can safely get arguments with
            //the correct static type for use in a real program!
            int left = namespace.getInt("left");
            int right = namespace.getInt("right");
            return new Result.Success<>(Map.of("left", left, "right", right));
        } catch (ArgumentParserException e) {
            return new Result.Failure<>(e.getMessage());
        }
    }

    private static Result<Map<String, Object>> sub(String[] arguments) {
        throw new UnsupportedOperationException("TODO"); //TODO
    }

    private static Result<Map<String, Object>> fizzbuzz(String[] arguments) {
        throw new UnsupportedOperationException("TODO"); //TODO
    }

    private static Result<Map<String, Object>> difficulty(String[] arguments) {
        throw new UnsupportedOperationException("TODO"); //TODO
    }

    private static Result<Map<String, Object>> echo(String[] arguments) {
        throw new UnsupportedOperationException("TODO"); //TODO
    }

    private static Result<Map<String, Object>> search(String[] arguments) {
        throw new UnsupportedOperationException("TODO"); //TODO
    }

    private static Result<Map<String, Object>> weekday(String[] arguments) {
        throw new UnsupportedOperationException("TODO"); //TODO
    }

}
