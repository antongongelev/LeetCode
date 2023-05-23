
package main.arrays_and_hashing;

import main.util.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum implements Easy {

    public static void main(String[] args) {
        int[] ints = new TwoSum().twoSum(new int[]{1, 3, 4, 6, 4}, 8);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            Integer necessaryIndex = map.get(target - a);
            if (necessaryIndex == null) {
                map.put(a, i);
                continue;
            }
            return new int[]{i, necessaryIndex};
        }
        return null;
    }

    @Override
    public String mySolution() {
        return """
                        for (int i = 0; i < nums.length - 1; i++) {
                            int a = nums[i];
                            for (int j = i + 1; j < nums.length; j++) {
                                int b = nums[j];
                                if (a + b == target) {
                                    return new int[]{i, j};
                                }
                            }
                        }
                        return null;
                """;
    }

    @Override
    public String optimizedSolution() {
        return """
                        Map<Integer, Integer> map = new HashMap<>();
                                
                        for (int i = 0; i < nums.length; i++) {
                            int a = nums[i];
                            Integer necessaryIndex = map.get(target - a);
                            if (necessaryIndex == null) {
                                map.put(a, i);
                                continue;
                            }
                            return new int[] {i, necessaryIndex};
                        }
                        return null;
                """;
    }
}
