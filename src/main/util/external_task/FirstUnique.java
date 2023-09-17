package main.util.external_task;

public class FirstUnique {

    public static void main(String[] args) {
        int result = FirstUnique.firstUnique("aabb");
        System.out.println(result);
    }

    public static int firstUnique(String str) {

        int[] chars = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            chars[c - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            char c = str.charAt(i);
            if (chars[c - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

}
