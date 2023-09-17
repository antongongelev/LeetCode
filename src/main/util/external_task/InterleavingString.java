package main.util.external_task;

import main.util.Medium;

import java.util.Stack;

public class InterleavingString implements Medium {

    public static void main(String[] args) {
        boolean result = new InterleavingString().isInterleave("aabc", "abad", "aabadabc");
        System.out.println(result);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        Stack<Character> s1Stack = new Stack<>();
        Stack<Character> s2Stack = new Stack<>();
        Stack<Character> s3Stack = new Stack<>();

        for (char c : s1.toCharArray()) {
            s1Stack.add(c);
        }
        for (char c : s2.toCharArray()) {
            s2Stack.add(c);
        }
        for (char c : s3.toCharArray()) {
            s3Stack.add(c);
        }

        while (!s3Stack.isEmpty()) {

            if (!s1Stack.isEmpty() && s1Stack.peek() == s3Stack.peek()) {
                s1Stack.pop();
                s3Stack.pop();
                continue;
            }
            if (!s2Stack.isEmpty() && s2Stack.peek() == s3Stack.peek()) {
                s2Stack.pop();
                s3Stack.pop();
                continue;
            }

            return false;
        }

        return s1Stack.isEmpty() && s2Stack.isEmpty();
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/interleaving-string/";
    }

    @Override
    public String mySolution() {
        return """
                                
                """;
    }

    @Override
    public String optimizedSolution() {
        return null;
    }
}
