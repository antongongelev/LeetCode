package main.stack;

import main.util.Medium;

import java.util.Stack;

public class EvaluateReversePolishNotation implements Medium {

    public static void main(String[] args) {
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(String str : tokens){
            switch (str) {
                case "+" -> {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a + b));
                }
                case "-" -> {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(b - a));
                }
                case "*" -> {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a * b));
                }
                case "/" -> {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(b / a));
                }
                default -> stack.push(str);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/evaluate-reverse-polish-notation";
    }

    @Override
    public String mySolution() {
        return """
                    public int evalRPN(String[] tokens) {
                            Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>() {{
                                put("+", (a, b) -> a + b);
                                put("-", (a, b) -> a - b);
                                put("*", (a, b) -> a * b);
                                put("/", (a, b) -> a / b);
                            }};
                            Stack<String> stack = new Stack<>();
                            for (String s : tokens) {
                                if (map.containsKey(s)) {
                                    String b = stack.pop();
                                    String a = stack.pop();
                                    Integer result = map.get(s).apply(Integer.parseInt(a), Integer.parseInt(b));
                                    stack.add(String.valueOf(result));
                                    continue;
                                }
                                stack.add(s);
                            }
                            return Integer.parseInt(stack.pop());
                        }
                """;
    }

    @Override
    public String optimizedSolution() {
        return """
                public int evalRPN(String[] tokens) {
                        Stack<String> stack = new Stack<>();
                               
                        for(String str : tokens){
                            switch (str) {
                                case "+" -> {
                                    int a = Integer.parseInt(stack.pop());
                                    int b = Integer.parseInt(stack.pop());
                                    stack.push(String.valueOf(a + b));
                                }
                                case "-" -> {
                                    int a = Integer.parseInt(stack.pop());
                                    int b = Integer.parseInt(stack.pop());
                                    stack.push(String.valueOf(b - a));
                                }
                                case "*" -> {
                                    int a = Integer.parseInt(stack.pop());
                                    int b = Integer.parseInt(stack.pop());
                                    stack.push(String.valueOf(a * b));
                                }
                                case "/" -> {
                                    int a = Integer.parseInt(stack.pop());
                                    int b = Integer.parseInt(stack.pop());
                                    stack.push(String.valueOf(b / a));
                                }
                                default -> stack.push(str);
                            }
                        }
                        return Integer.parseInt(stack.pop());
                    }
                """;
    }
}
