package main.stack;

import main.util.Medium;
import main.util.Unbearable;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses implements Medium, Unbearable {

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        appendRecursively(n, 0, 0, result, builder);
        return result;
    }

    private static void appendRecursively(int total, int opened, int closed, List<String> result, StringBuilder builder) {
        if (total == opened && total == closed) {
            result.add(builder.toString());
            return;
        }

        if (opened < total) {
            builder.append("(");
            appendRecursively(total, opened + 1, closed, result, builder);
            builder.setLength(builder.length() - 1);
        }

        if (closed < opened) {
            builder.append(")");
            appendRecursively(total, opened, closed + 1, result, builder);
            builder.setLength(builder.length() - 1);
        }
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/generate-parentheses/";
    }

    @Override
    public String mySolution() {
        return null;
    }

    @Override
    public String optimizedSolution() {
        return """
                public List<String> generateParenthesis(int n) {        
                        List<String> result = new ArrayList<>();
                        StringBuilder builder = new StringBuilder();
                                
                        appendRecursively(n, 0, 0, result, builder);
                        return result;
                    }
                                
                    private static void appendRecursively(int total, int opened, int closed, List<String> result, StringBuilder builder) {
                        if (total == opened && total == closed) {
                            result.add(builder.toString());
                            return;
                        }
                                
                        if (opened < total) {
                            builder.append("(");
                            appendRecursively(total, opened + 1, closed, result, builder);
                            builder.setLength(builder.length() - 1);
                        }
                                
                        if (closed < opened) {
                            builder.append(")");
                            appendRecursively(total, opened, closed + 1, result, builder);
                            builder.setLength(builder.length() - 1);
                        }
                    }
                """;
    }
}
