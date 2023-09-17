package main.stack;

import main.util.Medium;

public class CarFleet implements Medium {

    public int carFleet(int target, int[] position, int[] speed) {

        int res = 0;
        double[] timeArr = new double[target];
        for (int i = 0; i < position.length; i++) {
            timeArr[position[i]] = (double) (target - position[i]) / speed[i];
        }
        double prev = 0.0;
        for (int i = target - 1; i >= 0; i--) {
            double cur = timeArr[i];
            if (cur > prev) {
                prev = cur;
                res++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int result = new CarFleet().carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3});
        System.out.println(result);
    }

    @Override
    public String getLink() {
        return "https://leetcode.com/problems/car-fleet/";
    }

    @Override
    public String mySolution() {
        return """
                  TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
                         Stack<Float> times = new Stack<>();
                                
                         for (int i = 0; i < position.length; i++) {
                             map.put(position[i], speed[i]);
                         }
                                
                         for (Integer pos : map.keySet()) {
                             float time = (float) (target - pos) / map.get(pos);
                             if (times.isEmpty() || times.peek() < time) {
                                 times.add(time);
                             }
                         }
                                
                         return times.size(); 
                """;
    }

    @Override
    public String optimizedSolution() {
        return """
                int res = 0;
                       double[] timeArr = new double[target];
                       for (int i = 0; i < position.length; i++)
                        {
                            timeArr[position[i]]= (double)(target - position[i]) / speed[i];
                        }
                        double prev = 0.0;
                        for (int i = target-1; i >=0 ; i--)
                        {
                            double cur = timeArr[i];
                            if (cur > prev)
                            {
                                prev = cur;
                                res++;
                            }
                        }
                        return res;
                """;
    }
}
