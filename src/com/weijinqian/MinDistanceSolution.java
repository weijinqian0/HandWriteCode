package com.weijinqian;

/**
 * 最小编辑距离
 */
public class MinDistanceSolution {
    /**
     * 最小编辑距离
     *
     * @param str1
     * @param str2
     * @return
     */
    public int minDistance(String str1, String str2) {
        return 0;
    }

    /**
     * 计算最小编辑距离
     * 包括增删改，三个操作
     * 使用动态规划方程法来计算得出
     *
     * @param word1 句子1
     * @param word2 句子2
     * @return
     */
    public int minEditDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }

        int len1 = word1.length();
        int len2 = word2.length();

        int[][] distance = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1; i++) {
            distance[i][0] = i;
        }

        for (int i = 0; i < len2; i++) {
            distance[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 只对其中一个单词做操作就可以了 比如word1
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    // word1增加一个字符
                    int add = distance[i][j - 1] + 1;
                    // word1删除字符
                    int delete = distance[i - 1][j] + 1;
                    // word1修改字符
                    int modify = distance[i - 1][j - 1] + 1;
                    distance[i][j] = min(add, delete, modify);
                } else {
                    distance[i][j] = distance[i - 1][j - 1];
                }
            }
        }

        return distance[len1][len2];
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }


    public void DP1(int str1, int str2) {

    }

}
