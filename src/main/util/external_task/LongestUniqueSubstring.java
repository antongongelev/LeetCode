package main.util.external_task;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestUniqueSubstring().longestSubstring("abcbbeftg"));
    }

    public int longestSubstring(String value) {
        return helper(0, value);
    }

    private int helper(int max, String value) {
        if (value.length() <= max) {
            return max;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < value.length(); i++) {

            char c = value.charAt(i);
            Integer index = map.get(c);

            if (index == null) {
                map.put(c, i);
                continue;
            }

            return helper(Math.max(max, map.size()), value.substring(index + 1));
        }

        return Math.max(max, map.size());
    }
}
