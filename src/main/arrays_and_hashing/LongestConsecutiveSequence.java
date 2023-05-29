package main.arrays_and_hashing;

import main.util.Medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence implements Medium {

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        for (Integer i : set) {
            if (set.contains(i - 1)) {
                continue;
            }
            int temp = 0;
            while (set.contains(i + temp)) {
                temp += 1;
            }
            result = Math.max(temp, result);
        }

        return result;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/longest-consecutive-sequence/";
    }

    @Override
    public String mySolution() {
        return """
                    public int longestConsecutive(int[] nums) {
                        int result = 0;
                        Set<Integer> set = new HashSet<>();
                        for (int n : nums) {
                            set.add(n);
                        }
                                
                        for (Integer i : set) {
                            if (set.contains(i - 1)) {
                                continue;
                            }
                            result = Math.max(getConsecutive(set, i, 1), result);
                        }
                                
                        return result;
                    }
                                
                    private static int getConsecutive(Set<Integer> set, Integer i, int result) {
                        if (!set.contains(i + 1)) {
                            return result;
                        }
                        return getConsecutive(set, i + 1, ++result);
                    }
                """;
    }

    @Override
    public String optimizedSolution() {
        return """
                    public int longestConsecutive(int[] nums) {
                        int result = 0;
                        Set<Integer> set = new HashSet<>();
                        for (int n : nums) {
                            set.add(n);
                        }
                                
                        for (Integer i : set) {
                            if (set.contains(i - 1)) {
                                continue;
                            }
                            int temp = 1;
                            while (set.contains(i + temp)) {
                                temp += 1;
                            }
                            result = Math.max(temp, result);
                        }
                                
                        return result;
                    }
                """;
    }
}
