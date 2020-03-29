package com.weijinqian;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        System.out.println(new RobotSolution().DP1(10, 1, 100));
//        print(new CutRopeSolution().DP(4));

//        char[] matrix = new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
//        char[] str = new char[]{'a', 'b', 'c', 'b'};
//        printBoolean(new HasPathSolution().hasPath(matrix, 3, 4, str));

//        print(new PowerSolution().Power(3, -5));
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        new FindKthNodeSolution().FindKthToTail(head, 5);

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(3);
//        head.next.next = new ListNode(5);
//        head.next.next.next = new ListNode(7);
//        head.next.next.next.next = new ListNode(9);
//
//        ListNode head1 = new ListNode(2);
//        head1.next = new ListNode(4);
//        head1.next.next = new ListNode(6);
//        head1.next.next.next = new ListNode(8);
//
//        new MergeSortSolution().Merge(head, head1);

//        int[][] matrix = new int[5][2];
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 2; j++) {
//                matrix[i][j] = i * 2 + j + 1;
//            }
//        }
//        print(new PrintMatrixSolution().printMatrix(matrix));

        print(new FirstNotRepeatingCharSolution().FirstNotRepeatingChar("google"));

    }

    private static void print(int value) {
        System.out.println(value);
    }

    private static void printBoolean(boolean value) {
        System.out.println(value);
    }

    private static void print(double value) {
        System.out.println(value);
    }

    private static void print(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
