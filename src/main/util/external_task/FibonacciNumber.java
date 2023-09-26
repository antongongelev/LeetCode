package main.util.external_task;

import main.util.Easy;

public class FibonacciNumber implements Easy {


    public static void main(String[] args) {
        System.out.println(new FibonacciNumber().getElement(6));
    }

    public int getElement(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int fn1 = 0;
        int fn2 = 1;
        int sum = fn1 + fn2;

        for (int i = 2; i < n; i++) {
            fn1 = fn2;
            fn2 = sum;
            sum = fn1 + fn2;
        }

        return sum;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/fibonacci-number/";
    }

    @Override
    public String mySolution() {
        return """
                if (n == 0 || n == 1) {
                            return n;
                        }
                        int fn1 = getElement(n - 1);
                        int fn2 = getElement(n - 2);
                        return fn1 + fn2;
                """;
    }

    @Override
    public String optimizedSolution() {
        return """
                        if (n == 0 || n == 1) {
                            return n;
                        }
                                
                        int fn1 = 0;
                        int fn2 = 1;
                        int sum = fn1 + fn2;
                                
                        for (int i = 2; i < n; i++) {
                            fn1 = fn2;
                            fn2 = sum;
                            sum = fn1 + fn2;
                        }
                                
                        return sum;
                """;
    }
}
