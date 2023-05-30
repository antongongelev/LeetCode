package main.stack;

import main.util.Easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses implements Easy {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()"));
    }

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                stack.addLast(c);
                continue;
            }
            try {
                Character last = stack.removeLast();
                if (!last.equals(map.get(c))) {
                    return false;
                }
            }  catch (Exception e) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/valid-parentheses/";
    }

    @Override
    public String mySolution() {
        return """
                    public boolean isValid(String s) {
                        LinkedList<Character> stack = new LinkedList<>();
                        Map<Character, Character> map = new HashMap<>() {{
                            put(')', '(');
                            put('}', '{');
                            put(']', '[');
                        }};
                        for (int i = 0; i < s.length(); i++) {
                            char c = s.charAt(i);
                            if (!map.containsKey(c)) {
                                stack.addLast(c);
                                continue;
                            }
                            try {
                                Character last = stack.removeLast();
                                if (!last.equals(map.get(c))) {
                                    return false;
                                }
                            }  catch (Exception e) {
                                return false;
                            }
                        }
                        return stack.isEmpty();
                    }
                """;
    }

    @Override
    public String optimizedSolution() {
        return mySolution();
    }
}
