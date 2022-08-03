package com.weijinqian;

import com.weijinqian.dp.*;

import java.util.List;
import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        System.out.println(new RobotSolution().DP1(10, 1, 100));
//        print(new CutRopeSolution().cutRopeDp(8));

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

//        int[] array = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
//        print(new MaxInWindowSolution().maxInWindows(array, 3));

//        int[][] arr1 = new int[][]{{8, 20, 948}, {23, 28, 166}, {4, 6, 20}, {8, 22, 788}, {2, 6, 969}, {2, 12, 15}, {13, 19, 168}, {
//                6, 33, 97}, {16, 39, 199}, {8, 18, 199}, {2, 19, 271}, {19, 38, 85}, {7, 32, 331}, {3, 14, 444}, {21, 39, 360}, {
//                5, 34, 431}, {8, 16, 268}, {14, 35, 337}, {16, 34, 677}, {8, 17, 22}, {9, 31, 542}, {9, 27, 388}, {24, 30, 647}, {
//                23, 29, 584}, {29, 37, 493}, {25, 28, 482}, {3, 27, 753}, {25, 32, 221}, {20, 26, 872}, {30, 34, 343}, {13, 15, 80}, {
//                1, 10, 713}, {15, 26, 216}, {26, 29, 40}, {20, 25, 779}, {14, 33, 653}, {13, 29, 365}, {19, 38, 835}, {7, 19, 455}, {
//                16, 32, 808}, {27, 31, 602}, {10, 28, 440}, {5, 35, 885}, {6, 21, 836}, {3, 34, 508}, {19, 37, 76}, {11, 21, 740}, {
//                6, 39, 773}, {27, 28, 335}, {1, 36, 707}, {24, 36, 141}, {2, 33, 168}, {2, 14, 225}, {17, 35, 136}, {4, 29, 43}, {
//                2, 22, 922}, {6, 21, 18}, {6, 30, 714}, {23, 31, 335}, {7, 11, 895}, {21, 39, 979}, {12, 20, 791}, {20, 24, 652}, {
//                10, 18, 29}, {23, 37, 253}, {33, 38, 814}, {37, 38, 63}, {15, 22, 864}, {27, 30, 594}, {30, 38, 276}, {28, 30, 679}, {
//                6, 24, 710}, {6, 22, 221}, {1, 21, 589}, {10, 26, 779}, {3, 15, 135}, {10, 14, 33}, {22, 27, 779}, {4, 10, 962}, {
//                4, 12, 105}, {30, 37, 669}, {15, 29, 457}, {12, 36, 597}, {23, 25, 844}, {2, 23, 28}, {15, 20, 723}, {36, 39, 601}, {
//                5, 9, 692}, {6, 38, 301}, {17, 39, 565}, {7, 28, 610}, {11, 28, 22}, {19, 28, 15}, {1, 22, 738}, {31, 32, 608}, {
//                1, 19, 707}, {13, 27, 144}, {22, 23, 154}};
//        print(new GraphShortestPathSolution().findShortestPath(39, 98, arr1));

//        String S = "XDOYEZODEYXNZ";
//        String T = "XYZ";
//        print(new MinWindow().minWindow(S, T));

//        int[] array=new int[]{1,2,8,4,6};
//        print(new LongestIncreaseSolution().LIS2(array));

//        int[] array = new int[]{-2,0,1,1,2};
//        print(new NSum().threeSum(array));

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(1);
//        print(new FindPathSolution().FindPath(root, 2));
//[1,2,4,5,6,3],[5,4,6,2,1,3]
//        int[] xianxu=new int[]{1,2,4,5,6,3};
//        int[] zhongxu = new int[]{5,4,6,2,1,3};
//        print(new BinaryTreeRightView().solve(xianxu,zhongxu));
//        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'},
//                {'0', '1', '0', '1', '1'},
//                {'0', '0', '0', '1', '1'},
//                {'0', '0', '0', '0', '0'},
//                {'0', '0', '1', '1', '1'}
//        };
//        print(new NumOfIsland().solve(grid));

//        print(new RevertedSeqSolution().);
//        "aaaaaaaaaaaaab"
//        "a*a*a*a*a*a*a*a*a*a*c"
//        "abcaaaaaaabaabcabac"
//        ".*ab.a.*a*a*.*b*b*"
//        print(new RegularExpression().isMatch("abcaaaaaaabaabcabac", ".*ab.a.*a*a*.*b*b*"));
//        print(new GenerateParenthesis().generateParenthesis(3));
//        long time = System.currentTimeMillis();
//        print(new LongestValidParentheses().longestValidParentheses1("())((()()(()(((()())))))))((((((())()(()()(())()))(()))(()()())((((((()())()()()(()))())(((()(()(())(()((()())())))((()(((()(()((()())())))(())))()))))))))))())()))((())()()()()))((()))(((()))()(()))()((()()()(()))(((()()()()((()()(()())))(())))))))()))))()))()((()())())(()))(((()()()((())())())(((())((()))(())(())()))))(())))()())())()(()))))(())))(())))(()((())(())))((()(()))((((()))))()((()()()())()(())(()(()()())()((())(()((()()()())()))((()))))()))())))))))()((()()))()()()()))(()()()()(())()(()))))()(((((()(((((((()(((())()))(()())()(()))(()(()((()((((()))))()(())(()))))()(()(((((((()))((()(()(()))(()())(()())()(())()(()((((()))))()()()(((())()())()))())()(())))(()()))))(())))))((((()))))(((((()))((((()))((())))))((())))())((((((((()(()((())))()))()()))))))))(((()(()())(()))((())((())(()))))))))((())()()())(()(())()))))((())())(()(())((()())))))((())((())())()(()))(())()()()((((()(()()))()(()(((((()())())())))())()))()))(()())()((()()()()((())()())(((())(((()(()()(((((((()(((()((((()(()((())))())())(())()(()())()((())()()()))()(()())()))()())))()()())))()(((((()()))(())(((()())))(())(())())(())(()()())))()())()))(()))))(()())()(()))((((())()())(())(((()())(()((((((((()))((((())())()((()()())())()()()())()()((()())(()()))((()()))()))(((()((()()(()))()(())()())((())())()(((())))(())((()((())(()()()(()(()))((()((((()(()()(())(()()))))(())()(()()))))())()((())(()))()()(()()()((()))(()))))())((()(()(("));
//        print(System.currentTimeMillis() - time);
//        int[] height = new int[]{4,2,0,3,2,5};
//        print(new Trap().trap(height));
        long time = System.currentTimeMillis();
//        print(new WildcardMatch().isMatch("aa", "*"));
//        int[] num = new int[]{2,3,1,1,4};
//        print(new Jump().canJump(num));
        print(new EditDistance().minDistance("", "a"));
        print(System.currentTimeMillis() - time);
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

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void print(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
