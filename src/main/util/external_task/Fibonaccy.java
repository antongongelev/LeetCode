package main.util.external_task;

public class Fibonaccy {


    public static void main(String[] args) {
        System.out.println(new Fibonaccy().getElement(2));
    }

    public int getElement(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fn1 = getElement(n - 1);
        int fn2 = getElement(n - 2);
        return fn1 + fn2;
    }
}
