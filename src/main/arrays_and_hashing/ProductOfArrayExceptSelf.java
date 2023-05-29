package main.arrays_and_hashing;

import main.util.Medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf implements Medium {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int toRightInt = 1;
        int[] toRight = new int[nums.length];
        int toLeftInt = 1;
        int[] toLeft = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            toRight[i] = toRightInt;
            toRightInt *= nums[i];
            toLeft[nums.length - i - 1] = toLeftInt;
            toLeftInt *= nums[nums.length - i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = toRight[i] * toLeft[i];
        }

        return result;
    }

    @Override
    public String mySolution() {
        return """
                public int[] productExceptSelf(int[] nums) {

                             int[] result = new int[nums.length];
                             int toRightInt = 1;
                             int[] toRight = new int[nums.length];
                             int toLeftInt = 1;
                             int[] toLeft = new int[nums.length];
                     
                             for (int i = 0; i < nums.length; i++) {
                                 toRight[i] = toRightInt;
                                 toRightInt *= nums[i];
                                 toLeft[nums.length - i - 1] = toLeftInt;
                                 toLeftInt *= nums[nums.length - i - 1];
                             }
                     
                             for (int i = 0; i < nums.length; i++) {
                                 result[i] = toRight[i] * toLeft[i];
                             }
                     
                             return result;
                         }
                """;
    }

    @Override
    public String optimizedSolution() {
        return """
                public int[] productExceptSelf(int[] nums) {
                                
                        int[] result = new int[nums.length];
                        int prefix = 1;
                        int postfix = 1;
                                
                        for (int i = 0; i < nums.length; i++) {
                            result[i] = prefix;
                            prefix *= nums[i];
                        }
                                
                        for (int i = nums.length - 1; i >= 0; i--) {
                            result[i] = result[i] * postfix;
                            postfix *= nums[i];
                        }
                                
                        return result;
                    }
                """;
    }
}
