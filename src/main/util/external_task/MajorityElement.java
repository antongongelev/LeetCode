package main.util.external_task;

import main.util.Easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement implements Easy {

    public int majorityElement(int[] nums) {
        int threshold = nums.length / 2;
        Map<Integer, Integer> repeats = new HashMap<>();

        for (int num : nums) {
            Integer repeat = repeats.getOrDefault(num, 0);
            repeat = repeat + 1;
            if (repeat > threshold) {
                return num;
            }
            repeats.put(num, repeat);
        }

        return 0;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/majority-element/";
    }

    @Override
    public String mySolution() {
        return """
                    public int majorityElement(int[] nums) {
                        int threshold = nums.length / 2;
                        Map<Integer, Integer> repeats = new HashMap<>();
                                
                        for (int num : nums) {
                            Integer repeat = repeats.getOrDefault(num, 0);
                            repeat = repeat + 1;
                            if (repeat > threshold) {
                                return num;
                            }
                            repeats.put(num, repeat);
                        }
                                
                        return 0;
                    }
                """;
    }

    @Override
    public String optimizedSolution() {
        return null;
    }
}
