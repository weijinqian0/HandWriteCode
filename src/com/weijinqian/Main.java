package com.weijinqian;

import java.util.Arrays;
import java.util.Collections;
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

//        print(new FirstNotRepeatingCharSolution().FirstNotRepeatingChar("google"));

//        int[] pushA = new int[]{1, 2, 3, 4, 5};
//        int[] popA = new int[]{4,5,3,2,1};
//        printBoolean(new IsPopOrderSolution().IsPopOrder(pushA, popA));

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(4);
//        print(new PrintFromTopToBottomSolution().PrintFromTopToBottom(root));

//        int[] sequence = new int[]{4, 6, 12, 8, 16, 14, 10};
//        printBoolean(new VerifySquenceOfBSTSolution().VerifySquenceOfBST(sequence));

//        print(new PermutationSolution().Permutation("abbc"));

//        int[] sequence = new int[]{1,2,3,2,4,2,5,2,3};
//        print(new MoreThanHalfNumSolution().MoreThanHalfNum_Solution(sequence));

//        int[] array = new int[]{1,-2,3,10,-4,7,2,-5};
//        print(new FindGreatestSumOfSubArraySolution().FindGreatestSumOfSubArray(array));

//        int[] array = new int[]{3, 32, 321};
//        print(new PrintMinNumberSolution().PrintMinNumber(array));

//        int[] array=new int[]{0,1,1,1,1,2,2,2,2,2,4,5,6,7};
//        print(new GetNumberOfKSolution().GetNumberOfK(array,3));

//        int[] array = new int[]{1, 3, 0, 5, 6};
//        print(new isContinuousSolution().isContinuous(array));

//        print(new StrToIntSolution().StrToInt("-2147483649"));

//        char[] str = new char[]{'a'};
//        char[] pattern = new char[]{'a', 'b'};
//        print(new MatchSolution().match(str, pattern));

        int[] array = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        print(new MaxInWindowSolution().maxInWindows(array, 3));


    }

    private static void print(String value) {
        System.out.println(value);
    }

    private static void print(int value) {
        System.out.println(value);
    }

    private static void print(boolean value) {
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
