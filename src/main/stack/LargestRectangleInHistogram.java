package main.stack;

import main.util.Hard;

import java.util.Stack;

public class LargestRectangleInHistogram implements Hard {

    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{5, 4}));
    }

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Rectangle> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int index = i;
            while (!stack.isEmpty() && stack.peek().getHeight() > heights[i]) {
                Rectangle pop = stack.pop();
                max = Math.max(max, pop.getHeight() * (i - pop.getIndex()));
                index = pop.index;
            }
            stack.add(new Rectangle(index, heights[i]));
        }

        while (!stack.isEmpty()) {
            Rectangle pop = stack.pop();
            max = Math.max(max, pop.height * (heights.length - pop.index));
        }

        return max;
    }

    private static class Rectangle {
        private int index;
        private int height;

        public Rectangle(int index, int height) {
            this.index = index;
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public int getIndex() {
            return index;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setIndex(int index) {
            this.index = index;
        }

    }

    @Override
    public String getLink() {
        return null;
    }

    @Override
    public String mySolution() {
        return """
                        int max = 0;
                        Stack<Rectangle> stack = new Stack<>();
                                
                        for (int i = 0; i < heights.length; i++) {
                            int index = i;
                            while (!stack.isEmpty() && stack.peek().getHeight() > heights[i]) {
                                Rectangle pop = stack.pop();
                                max = Math.max(max, pop.getHeight() * (i - pop.getIndex()));
                                index = pop.index;
                            }
                            stack.add(new Rectangle(index, heights[i]));
                        }
                                
                        while (!stack.isEmpty()) {
                            Rectangle pop = stack.pop();
                            max = Math.max(max, pop.height * (heights.length - pop.index));
                        }
                                
                        return max;
                """;
    }

    @Override
    public String optimizedSolution() {
        return mySolution();
    }
}
