package main.arrays_and_hashing;

import main.Solution;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates implements Solution {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            boolean result = set.add(num);
            if (!result) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String mySolution() {
        return """
                public boolean containsDuplicate(int[] nums) {

                    Set<Integer> set = new HashSet<>();
                    for (int num : nums) {
                        boolean result = set.add(num);
                        if (!result) {
                            return true;
                        }
                    }
                    return false;
                }
                            """;
    }

    @Override
    public String optimizedSolution() {
        return mySolution();
    }
}