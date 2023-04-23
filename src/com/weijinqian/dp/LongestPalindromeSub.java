package com.weijinqian.dp;

/**
 * 最长回文子序列
 * 最长回文子串
 * 以最小的插入次数构造回文串
 */
public class LongestPalindromeSub {

    /**
     * 最长回文子序列
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
//        因为依赖于左、下方的位置，所以得先把左边的位置和下方的位置填充一下
//        所以遍历的时候，需要已经存在左边的位置，所以j从左到右
//        需要存在下方的位置，所以i需要从下往上。
//        dp[i][j] = dp[i+1][j-1]
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }


    /**
     * 最长回文子数组
     * 重点在于标识出为true的位置
     * dp的含义为下表为i和j的字符串是回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindromeSubArray(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
//        因为依赖于左、下方的位置，所以得先把左边的位置和下方的位置填充一下
//        所以遍历的时候，需要已经存在左边的位置，所以j从左到右
//        需要存在下方的位置，所以i需要从下往上。
//        dp[i][j] = dp[i+1][j-1]
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int beginIndex = 0;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] || (j - i + 1) <= 2;
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    maxLen = j - i + 1;
                    beginIndex = i;
                }
            }
        }
        return s.substring(beginIndex, beginIndex + maxLen);
    }

    /**
     * 最长回文字数组，返回数组，唉，又写了一次，还是不咋会
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int maxIdx = 1;
        for (int i = len; i >= 1; i--) {
            for (int j = i + 1; j <= len; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i + 1][j - 1] || (j - i + 1) <= 2;
                }
                if (dp[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    maxIdx = i;
                }
            }
        }

        return s.substring(maxIdx - 1, maxIdx + maxLen - 1);
    }


    /**
     * 当前节点开始的回文子串
     *
     * @param s
     * @param l
     * @param r
     * @return
     */
    String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r - l - 1);
    }

    /**
     * 最长回文子串的另外一种写法，是从字符串的中心开始向两边扩展
     *
     * @param s
     * @return
     */
    public String longestPalindromeSubArray1(String s) {
        String res = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }


    /**
     * 1312. 让字符串成为回文串的最少插入次数
     *
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
//        dp[i][j]=dp[i+1][j-1] 依赖于下方和左边，因此j需要从左到右，i从下到上
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][len - 1];
    }
}
