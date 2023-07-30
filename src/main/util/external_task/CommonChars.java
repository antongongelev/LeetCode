package main.util.external_task;

import main.util.Easy;

import java.util.ArrayList;
import java.util.List;

public class CommonChars implements Easy {

    public static void main(String[] args) {
        List<String> strings = new CommonChars().commonChars(new String[]{"god", "dog", "omg"});
        System.out.println(strings);
    }

    public List<String> commonChars(String[] words) {

        List<String> result = new ArrayList<>();
        int[] repeats = new int[26];

        outer:
        for (int i = 0; i < repeats.length; i++) {
            for (String word : words) {
                if (!word.contains(Character.toString((char) i + 97))) {
                    continue outer;
                }
                repeats[i] += 1;
            }
        }

        for (int i = 0; i < repeats.length; i++) {
            if (words.length != repeats[i]) {
                continue;
            }
            result.add(Character.toString((char) i + 97));
        }

        return result;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/find-common-characters/";
    }

    @Override
    public String mySolution() {
        return null;
    }

    @Override
    public String optimizedSolution() {
        return null;
    }
}
