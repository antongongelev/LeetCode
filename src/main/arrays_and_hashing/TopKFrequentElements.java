package main.arrays_and_hashing;

import main.util.Medium;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements implements Medium {

    public static void main(String[] args) {
        int k = 2;
        int[] nums = new int[]{1, 1, 1, 4, 4, 3,4,4};
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(nums, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> collect = map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).toList();
        for (int i = 0; i < k; i++) {
            result[i] = collect.get(collect.size() - i - 1);
        }
        return result;
    }

    @Override
    public String mySolution() {
        return """
                    public int[] topKFrequent(int[] nums, int k) {
                        int[] result = new int[k];
                        Map<Integer, Integer> map = new HashMap<>();
                        for (int num : nums) {
                            map.put(num, map.getOrDefault(num, 0) + 1);
                        }
                        List<Integer> collect = map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).toList();
                        for (int i = 0; i < k; i++) {
                            result[i] = collect.get(collect.size() - i - 1);
                        }
                        return result;
                    }
                """;
    }

    @Override
    public String optimizedSolution() {
        return null;
    }
}
