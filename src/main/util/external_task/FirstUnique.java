package main.util.external_task;

public class FirstUnique {

    public static void main(String[] args) {
        int result = FirstUnique.firstUnique("abcab");
        System.out.println(result);
    }

    public static int firstUnique(String str) {

        int[] chars = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            chars[c - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 1) {
                return str.indexOf(str.charAt(i));
            }
        }

        return -1;
    }

}
