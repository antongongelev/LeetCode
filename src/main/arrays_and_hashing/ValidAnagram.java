package main.arrays_and_hashing;

import main.util.Easy;

import java.util.Arrays;

public class ValidAnagram implements Easy {

    public static void main(String[] args) {
        boolean result = new ValidAnagram().isAnagram("anagram", "nagaram");
        System.out.println(result);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return String.valueOf(sChars).equals(String.valueOf(tChars));
    }

    @Override
    public String mySolution() {
        return """
                public boolean isAnagram(String s, String t) {
                               
                        if (s.length() != t.length()) {
                            return false;
                        }
                               
                        Map<Character, Integer> sMap = new HashMap<>();
                        Map<Character, Integer> tMap = new HashMap<>();
                               
                        for (int i = 0; i < s.length(); i++) {
                            sMap.put(s.charAt(i), 1 + sMap.getOrDefault(s.charAt(i), 0));
                            tMap.put(t.charAt(i), 1 + tMap.getOrDefault(t.charAt(i), 0));
                        }
                               
                        if (sMap.size() != tMap.size()) {
                            return false;
                        }
                               
                        for (Character c : sMap.keySet()) {
                            if (!Objects.equals(sMap.get(c), tMap.get(c))) {
                                return false;
                            }
                        }
                               
                        return true;
                    }
                """;
    }

    @Override
    public String optimizedSolution() {
        return """
                public boolean isAnagram(String s, String t) {
                        if (s.length() != t.length()) {
                            return false;
                        }
                                
                        char[] sChars = s.toCharArray();
                        char[] tChars = t.toCharArray();
                                
                        Arrays.sort(sChars);
                        Arrays.sort(tChars);
                                
                        return String.valueOf(sChars).equals(String.valueOf(tChars));
                    }
                """;
    }
}
