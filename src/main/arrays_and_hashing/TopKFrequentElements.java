package main.arrays_and_hashing;

import main.util.Medium;

import java.util.*;

public class TopKFrequentElements implements Medium {

    public static void main(String[] args) {
        int k = 2;
        int[] nums = new int[]{1, 1, 1, 4, 5, 3, 4, 4};
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(nums, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] array = new ArrayList[nums.length + 1];

        //Заполним мапу для количества повторов
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //Заполним массив, в котором индекс = кол-ву повторов N, а значение = список элементов, которые повторялись N раз
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = array[entry.getValue()];
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(entry.getKey());
            array[entry.getValue()] = list;
        }

        int taken = 0;

        //Идем с конца массива, заходя в каждую ненулевую ячейку и достаем k элементов
        for (int i = array.length - 1; i >= 0; i--) {

            List<Integer> list = array[i];
            if (list == null) {
                continue;
            }

            for (Integer integer : list) {
                result[taken] = integer;
                if (++taken == k) {
                    return result;
                }
            }
        }

        return result;
    }

    @Override
    public String mySolution() {
        return """
                    public int[] topKFrequent(int[] nums, int k) {
                        int[] result = new int[k];
                        Map<Integer, Integer> map = new HashMap<>();
                        for (int num : nums) {
                            map.put(num, map.getOrDefault(num, 0) + 1);
                        }
                        List<Integer> collect = map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).map(Map.Entry::getKey).toList();
                        for (int i = 0; i < k; i++) {
                            result[i] = collect.get(collect.size() - i - 1);
                        }
                        return result;
                    }
                """;
    }

    @Override
    public String optimizedSolution() {
        return """
                public int[] topKFrequent(int[] nums, int k) {
                        int[] result = new int[k];
                        Map<Integer, Integer> map = new HashMap<>();
                        List<Integer>[] array = new ArrayList[nums.length + 1];
                                
                        //Заполним мапу для количества повторов
                        for (int num : nums) {
                            map.put(num, map.getOrDefault(num, 0) + 1);
                        }
                                
                        //Заполним массив, в котором индекс = кол-ву повторов N, а значение = список элементов, которые повторялись N раз
                        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                            List<Integer> list = array[entry.getValue()];
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            list.add(entry.getKey());
                            array[entry.getValue()] = list;
                        }
                                
                        int taken = 0;
                                
                        //Идем с конца массива, заходя в каждую ненулевую ячейку и достаем k элементов\s
                        for (int i = array.length - 1; i >= 0; i--) {
                                
                            List<Integer> list = array[i];
                            if (list == null) {
                                continue;
                            }
                                
                            for (Integer integer : list) {
                                result[taken] = integer;
                                if (++taken == k) {
                                    return result;
                                }
                            }
                        }
                                
                        return result;
                    }
                """;
    }
}
