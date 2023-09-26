package main.stack;

import main.util.Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses implements Medium {

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        appendRecursively(n, 0, 0, result, "");
        return result;
    }

    private static void appendRecursively(int total, int opened, int closed, List<String> result, String string) {
        if (total == opened && total == closed) {
            result.add(string);
            return;
        }

        if (opened < total) {
            appendRecursively(total, opened + 1, closed, result, string + "(");
        }

        if (closed < opened) {
            appendRecursively(total, opened, closed + 1, result, string + ")");
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
