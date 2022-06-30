package com.weijinqian.dfs;

public class VerifySquenceOfBSTSolution {

    /**
     * 判断当前的序列是否是二叉搜索树
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return verify(sequence, 0, sequence.length - 1);
    }

    public boolean verify(int[] sequence, int left, int right) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (left >= right) {
            return true;
        }

        int mid = sequence[right];
        int curLeft = left;
        boolean isRightSubSeq = false;
        for (int i = left; i < right - 1; i++) {
            if (sequence[i] > mid) {
                curLeft = i - 1;
                isRightSubSeq = true;
            }
            if (isRightSubSeq && sequence[i] <= mid) {
                return false;
            }
        }

        return verify(sequence, left, curLeft) && verify(sequence, curLeft + 1, right - 1);

    }
}
