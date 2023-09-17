package main.arrays_and_hashing;

import main.util.Easy;

import java.util.Arrays;

public class SquaresOfSortedArray implements Easy {

//    [-4 -2 0 1 5] -> [0 1 4 16 25]

    public static void main(String[] args) {
        int[] array = new SquaresOfSortedArray().getSquare(new int[]{-4, -2, -1, 2, 6});
        System.out.println(Arrays.toString(array));
    }

    public int[] getSquare(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[right - left] = nums[left] * nums[left];
                left++;
            } else {
                result[right - left] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/squares-of-a-sorted-array/description/";
    }

    @Override
    public String mySolution() {
        return null;
    }

    @Override
    public String optimizedSolution() {
        return """
                        int left = 0;
                        int right = nums.length - 1;
                        int index = nums.length - 1;
                        int[] result = new int[nums.length];
                                
                        while (left <= right) {
                            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                                result[index] = nums[left] * nums[left];
                                left++;
                            } else {
                                result[index] = nums[right] * nums[right];
                                right--;
                            }
                            index--;
                        }
                        return result;
                """;
    }
}
