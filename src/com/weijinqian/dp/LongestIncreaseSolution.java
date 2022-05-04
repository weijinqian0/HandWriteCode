package com.weijinqian.dp;

public class LongestIncreaseSolution {
    /**
     * 最长递增子序列
     *
     * @param arr
     * @return
     */
    public int[] LIS(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int len = arr.length;
        int[] dp = new int[len + 1];
        int[] node = new int[len + 1];
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i - 1] > arr[j - 1]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        node[i] = j;
                    }
                }
            }
        }
        int res = 0;
        int endIdx = 0;
        for (int i = 1; i <= len; i++) {
            if (dp[i] > res) {
                res = dp[i];
                endIdx = i;
            }
        }
        int[] subseq = new int[res];
        for (int i = res - 1; i >= 0; i--) {
            subseq[i] = arr[endIdx - 1];
            endIdx = node[endIdx];
        }
        return subseq;
    }

    public int[] LIS1(int[] arr) {
        int[] top = new int[arr.length];
        int piles = 0;
        for (int i = 0; i < arr.length; i++) {
            int poker = arr[i];

            int left = 0, right = piles;
            // 每次压到比它大的牌上
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        int[] res = new int[piles];
        for (int i = 0; i < piles; i++) {
            res[i] = top[i];
        }
        return res;
    }
//    LIS1 和 LIS2中的本质差别在于记录的方式不正确，p数组告诉了我们这个值应该在哪个堆，但是这个堆里面的数据是使用最小的值来弄，还是使用顺序遍历找到

    public int[] LIS2(int[] arr) {
        int n = arr.length;
        int[] d = new int[n + 1];
        int[] p = new int[n];
        int len = 1;
        d[len] = arr[0];
        p[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > d[len]) {
                d[++len] = arr[i];
                p[i] = len;
            } else {
                //二分查找恰好合适的位置
                int left = 1, right = len, pos = 0;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (d[mid] < arr[i]) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                //对该位置数字进行更新
                d[pos + 1] = arr[i];
                p[i] = pos + 1;
            }
        }

        int[] res = new int[len];
        for (int i = n - 1; i >= 0; i--) {
            if (p[i] == len) {
                res[--len] = arr[i];
            }
        }
        return res;
    }
}
