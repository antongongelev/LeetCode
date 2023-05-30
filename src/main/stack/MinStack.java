package main.stack;

import main.util.Medium;

import java.util.ArrayList;
import java.util.List;

public class MinStack implements Medium {

    private final List<Integer> stack;
    private final List<Integer> min;

    public MinStack() {
        stack = new ArrayList<>();
        min = new ArrayList<>();
        min.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.add(val);
        if (min.get(min.size() - 1) >= val) {
            min.add(val);
        }
    }

    public void pop() {
        if (min.get(min.size() - 1) == top()) {
            min.remove(min.get(min.size() - 1));
        }
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min.get(min.size() - 1);
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/min-stack/";
    }

    @Override
    public String mySolution() {
        return """
                private final List<Integer> stack;
                private final List<Integer> min;
                                
                    public MinStack() {
                        stack = new ArrayList<>();
                        min = new ArrayList<>();
                        min.add(Integer.MAX_VALUE);
                    }
                                
                    public void push(int val) {
                        stack.add(val);
                        if (min.get(min.size() - 1) >= val) {
                            min.add(val);
                        }
                    }
                                
                    public void pop() {
                        if (min.get(min.size() - 1) == top()) {
                            min.remove(min.get(min.size() - 1));
                        }
                        stack.remove(stack.size() - 1);
                    }
                                
                    public int top() {
                        return stack.get(stack.size() - 1);
                    }
                                
                    public int getMin() {
                        return min.get(min.size() - 1);
                    }
                """;
    }

    @Override
    public String optimizedSolution() {
        return mySolution();
    }
}
