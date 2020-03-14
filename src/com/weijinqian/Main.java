package com.weijinqian;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        System.out.println(new RobotSolution().DP1(10, 1, 100));
        print(new CutRopeSolution().DP1(8));
    }

    private static void print(int value) {
        System.out.println(value);
    }
}
