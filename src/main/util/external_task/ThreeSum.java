package main.util.external_task;

import main.util.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum implements Medium {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

//        [-1, 0, 1, 2, -1, -4] -> [-4, -1, -1, 0, 1, 2]

        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            int target = -nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (target == sum) {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    if (set.add(String.valueOf(nums[i]) + nums[left++] + nums[right--])) {
                        result.add(triplet);
                    }
                    continue;
                }

                if (sum < target) {
                    left++;
                    continue;
                }

                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ThreeSum().threeSum(new int[]{-2, 0, 1, 1, 2});
        System.out.println(lists);
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/3sum/";
    }

    @Override
    public String mySolution() {
        return """
                        Arrays.sort(nums);
                                
                //        [-1, 0, 1, 2, -1, -4] -> [-4, -1, -1, 0, 1, 2]
                                
                        List<List<Integer>> result = new ArrayList<>();
                        Set<String> set = new HashSet<>();
                                
                        for (int i = 0; i < nums.length; i++) {
                                
                            int target = -nums[i];
                                
                            int left = i + 1;
                            int right = nums.length - 1;
                                
                            while (left < right) {
                                int sum = nums[left] + nums[right];
                                
                                if (target == sum) {
                                    ArrayList<Integer> triplet = new ArrayList<>();
                                    triplet.add(nums[i]);
                                    triplet.add(nums[left]);
                                    triplet.add(nums[right]);
                                    if (set.add(String.valueOf(nums[i]) + nums[left++] + nums[right--])) {
                                        result.add(triplet);
                                    }
                                    continue;
                                }
                                
                                if (sum < target) {
                                    left++;
                                    continue;
                                }
                                
                                right--;
                            }
                        }
                                
                        return result;
                """;
    }

    @Override
    public String optimizedSolution() {
        return "Not to use SET to check if triplets are unique";
    }
}
