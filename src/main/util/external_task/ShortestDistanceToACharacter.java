package main.util.external_task;

import main.util.Easy;

import java.util.Arrays;

public class ShortestDistanceToACharacter implements Easy {

    public static void main(String[] args) {
        int[] result = new ShortestDistanceToACharacter().shortestToChar("loveleetcode", 'e');
        System.out.println(Arrays.toString(result));
    }

//    [3,2,1,0,1,0,0,1,2,2,1,0]

    public int[] shortestToChar(String s, char c) {

        int[] result = new int[s.length()];
        char[] chars = s.toCharArray();

        int counter = chars.length;

        // ->
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                result[i] = 0;
                counter = 1;
                continue;
            }
            result[i] = counter;
            counter++;
        }

        counter = chars.length;

        // <-
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == c) {
                result[i] = 0;
                counter = 1;
                continue;
            }
            result[i] = Math.min(counter, result[i]);
            counter++;
        }

        return result;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/shortest-distance-to-a-character";
    }

    @Override
    public String mySolution() {
        return """
                                
                        int[] result = new int[s.length()];
                        char[] chars = s.toCharArray();
                                
                        int counter = chars.length;
                                
                        // ->
                        for (int i = 0; i < chars.length; i++) {
                            if (chars[i] == c) {
                                result[i] = 0;
                                counter = 1;
                                continue;
                            }
                            result[i] = counter;
                            counter++;
                        }
                                
                        counter = chars.length;
                                
                        // <-
                        for (int i = chars.length - 1; i >= 0; i--) {
                            if (chars[i] == c) {
                                result[i] = 0;
                                counter = 1;
                                continue;
                            }
                            result[i] = Math.min(counter, result[i]);
                            counter++;
                        }
                                
                        return result;
                """;
    }

    @Override
    public String optimizedSolution() {
        return null;
    }
}
