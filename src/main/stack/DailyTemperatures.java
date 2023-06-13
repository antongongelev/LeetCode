package main.stack;

import main.util.Medium;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures implements Medium {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int currDay = 0; currDay < temperatures.length; currDay++) {

            while (!stack.isEmpty() && temperatures[currDay] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                result[prevDay] = currDay - prevDay;
            }

            stack.add(currDay);
        }

        return result;
    }


    @Override
    public String getLink() {
        return "https://leetcode.com/problems/daily-temperatures/";
    }

    @Override
    public String mySolution() {
        return """
                      private static class Pair {
                              private final int index;
                              private final int value;
                      
                              private Pair(int index, int value) {
                                  this.index = index;
                                  this.value = value;
                              }
                      
                          }
                      
                          public int[] dailyTemperatures(int[] temperatures) {
                              int[] result = new int[temperatures.length];
                              Stack<Pair> stack = new Stack<>();
                      
                              for (int i = 0; i < temperatures.length; i++) {
                      
                                  int temperature = temperatures[i];
                      
                                  if (stack.isEmpty() || temperature <= stack.peek().value) {
                                      stack.push(new Pair(i, temperature));
                                      continue;
                                  }
                      
                                  while (true) {
                                      if (stack.isEmpty() || temperature <= stack.peek().value) {
                                          stack.push(new Pair(i, temperature));
                                          break;
                                      }

                                      Pair pair = stack.pop();
                                      result[pair.index] = i - pair.index;
                                  }
                              }
                              return result;
                          }
                """;
    }

    @Override
    public String optimizedSolution() {
        return """
                       public int[] dailyTemperatures(int[] temperatures) {
                   
                           int[] result = new int[temperatures.length];
                           Stack<Integer> stack = new Stack<>();
                   
                           for (int currDay = 0; currDay < temperatures.length; currDay++) {
                   
                               while (!stack.isEmpty() && temperatures[currDay] > temperatures[stack.peek()]) {
                                   int prevDay = stack.pop();
                                   result[prevDay] = currDay - prevDay;
                               }
                   
                               stack.add(currDay);
                           }
                   
                           return result;
                       }             
                """;
    }
}
