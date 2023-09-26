package main.two_pointers;

import main.util.Easy;

public class ValidPalindrome implements Easy {

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length() - 1;

        char[] chars = s.toCharArray();

        while (leftIndex <= rightIndex) {
            char left = Character.toLowerCase(chars[leftIndex]);
            if (!Character.isAlphabetic(left) && !Character.isDigit(left)) {
                leftIndex++;
                continue;
            }
            char right = Character.toLowerCase(chars[rightIndex]);
            if (!Character.isAlphabetic(right) && !Character.isDigit(right)) {
                rightIndex--;
                continue;
            }
            leftIndex++;
            rightIndex--;
            if (left != right) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/valid-palindrome/";
    }

    @Override
    public String mySolution() {
        return """
                String toLeft = "";
                        String toRight = "";
                        int leftIndex = 0;
                        int rightIndex = 0;
                                
                        char[] chars = s.toCharArray();
                        for (int i = 0; i < chars.length; i++) {
                                
                            char a = chars[leftIndex++];
                            char b = chars[chars.length - rightIndex++ - 1];
                                
                            if (Character.isAlphabetic(a) || Character.isDigit(a)) {
                                toRight += Character.toLowerCase(a);
                            }
                            if (Character.isAlphabetic(b) || Character.isDigit(b)) {
                                toLeft += Character.toLowerCase(b);
                            }
                        }
                                
                        return toLeft.equals(toRight);
                """;
    }

    @Override
    public String optimizedSolution() {
        return """
                        int leftIndex = 0;
                        int rightIndex = s.length() - 1;
                                
                        char[] chars = s.toCharArray();
                                
                        while (leftIndex <= rightIndex) {
                            char left = Character.toLowerCase(chars[leftIndex]);
                            if (!Character.isAlphabetic(left) && !Character.isDigit(left)) {
                                leftIndex++;
                                continue;
                            }
                            char right = Character.toLowerCase(chars[rightIndex]);
                            if (!Character.isAlphabetic(right) && !Character.isDigit(right)) {
                                rightIndex--;
                                continue;
                            }
                            leftIndex++;
                            rightIndex--;
                            if (left != right) {
                                return false;
                            }
                        }
                                
                        return true;
                """;
    }
}
