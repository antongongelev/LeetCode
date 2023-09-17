package main.util.external_task;

import main.util.Hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMax implements Hard {

    public static void main(String[] args) {
        int[] result = new SlidingWindowMax().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
        System.out.println(Arrays.toString(result));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        int index = 0;
        Deque<Integer> q = new ArrayDeque<>();

        while (right < nums.length) {
            while (!q.isEmpty() && nums[right] > nums[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(right);

            if (left > q.peekFirst()) {
                q.pollFirst();
            }

            if (right + 1 >= k) {
                res[index++] = (nums[q.peekFirst()]);
                left++;
            }
            right++;
        }

        return res;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/sliding-window-maximum/";
    }

    @Override
    public String mySolution() {
        return """
                        int[] result = new int[nums.length - k + 1];
                        int left = 0;
                        int right = k;
                                
                        while (right <= nums.length) {
                            int max = Integer.MIN_VALUE;
                            for (int i = 0; i < k; i++) {
                                max = Math.max(max, nums[left + i]);
                            }
                            result[left] = max;
                            left++;
                            right++;
                        }
                                
                        return result;
                """;
    }

    @Override
    public String optimizedSolution() {
        return """
                int[] res = new int[nums.length - k + 1];
                        int left = 0;
                        int right = 0;
                        int index = 0;
                        Deque<Integer> q = new ArrayDeque<>();
                                
                        while (right < nums.length) {
                            while (!q.isEmpty() && nums[right] > nums[q.peekLast()]) {
                                q.pollLast();
                            }
                            q.offerLast(right);
                                
                            if (left > q.peekFirst()) {
                                q.pollFirst();
                            }
                                
                            if (right + 1 >= k) {
                                res[index++] = (nums[q.peekFirst()]);
                                left++;
                            }
                            right++;
                        }
                                
                        return res;
                """;
    }
}
