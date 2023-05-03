
package main.arrays_and_hashing;

import main.Medium;

import java.util.*;

public class GroupAnagram implements Medium {

    public static void main(String[] args) {
        String[] input = new String[]{"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        System.out.println(new GroupAnagram().groupAnagrams(input));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] list = new int[26];

            char[] charArray = str.toCharArray();

            for (int j = 0; j < charArray.length; j++) {
                int index = Character.getNumericValue(str.charAt(j)) - Character.getNumericValue('a');
                list[index] += 1;
            }

            List<String> strings = map.getOrDefault(Arrays.toString(list), new ArrayList<>());
            strings.add(str);
            map.put(Arrays.toString(list), strings);
        }

        return new ArrayList<>(map.values());
    }

    @Override
    public String mySolution() {
        return """
                              public List<List<String>> groupAnagrams(String[] strs) {
                                  HashMap<String, List<Integer>> map = new HashMap<>();
                                  List<List<String>> result = new ArrayList<>();
                          
                                  for (int i = 0; i < strs.length; i++) {
                                      String s = strs[i];
                                      char[] sChars = s.toCharArray();
                                      Arrays.sort(sChars);
                                      String sortedS = String.valueOf(sChars);
                                      List<Integer> indexes = map.getOrDefault(sortedS, new ArrayList<>());
                                      indexes.add(i);
                                      map.put(sortedS, indexes);
                                  }
                          
                                  for (List<Integer> value : map.values()) {
                                      List<String> list = new ArrayList<>();
                                      for (Integer i : value) {
                                          list.add(strs[i]);
                                      }
                                      result.add(list);
                                  }
                          
                                  return result;
                              }
                """;
    }

    @Override
    public String optimizedSolution() {
        return """
                  public List<List<String>> groupAnagrams(String[] strs) {
                          Map<String, List<String>> map = new HashMap<>();
                  
                          for (String str : strs) {
                  
                              int[] list = new int[26];
                  
                              char[] charArray = str.toCharArray();
                  
                              for (int j = 0; j < charArray.length; j++) {
                                  int index = Character.getNumericValue(str.charAt(j)) - Character.getNumericValue('a');
                                  list[index] += 1;
                              }
                  
                              List<String> strings = map.getOrDefault(Arrays.toString(list), new ArrayList<>());
                              strings.add(str);
                              map.put(Arrays.toString(list), strings);
                          }
                  
                          return new ArrayList<>(map.values());
                      }
                """;
    }
}
