package com.weijinqian.dfs;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeRightView {

    /**
     * 使用递归的方式来做
     *
     * @param xianxu
     * @param zhongxu
     * @return
     */
    private Map<Integer, Integer> res = new HashMap<>();

    public int[] solve(int[] xianxu, int[] zhongxu) {
        // write code here
        if (xianxu == null || zhongxu == null || zhongxu.length != zhongxu.length) {
            return new int[]{};
        }
        reconstruct(xianxu, zhongxu, 0, xianxu.length - 1, 0, zhongxu.length - 1, 0);

        int[] final_res = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            final_res[i] = res.get(i);
        }
        return final_res;
    }

    public void reconstruct(int[] xianxu, int[] zhongxu, int ll, int lr, int rl, int rr, int height) {
        if ((ll - lr) > 0 || rl - rr > 0) {
            return;
        }

        int root = xianxu[ll];
        int idx = getIndex(zhongxu, root); //3
        int lLen = idx - rl; // 3
        int rLen = rr - rl - idx; //1
        res.put(height, root);
        reconstruct(xianxu, zhongxu, ll + 1, ll + lLen, rl, idx - 1, height + 1);
        reconstruct(xianxu, zhongxu, ll + lLen + 1, lr, idx + 1, rr, height + 1);

    }

    private int getIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }
        return -1;
    }


}
