package com.weijinqian.dp;

import java.util.LinkedList;
import java.util.Queue;

public class Trap {
    /**
     * 42. 接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 建模每一个位置，高于当前位置的左右两侧的最大值，然后取得其中的最小值
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        // 当前位置高于它的左侧最大值
        int[] dp1 = new int[len];
        // 当前位置高于它的右侧最大值
        int[] dp2 = new int[len];
        dp1[0] = height[0];
        for (int i = 1; i < len; i++) {
            dp1[i] = Math.max(dp1[i - 1], height[i]);
        }

        dp2[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            res += Math.min(dp1[i], dp2[i]) - height[i];
        }
        return res;

    }

    /**
     * 3D接雨水
     * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
     * @param height
     * 我们假设初始时矩阵的每个格子都接满了水，且高度均为 maxHeight\textit{maxHeight}maxHeight，其中 maxHeight\textit{maxHeight}maxHeight 为矩阵中高度最高的格子。我们知道方块接水后的高度为 water[i][j]\textit{water}[i][j]water[i][j]，它的求解公式与方法一样。方块 (i,j)(i,j)(i,j) 的接水后的高度为：
     *
     * water[i][j]=max(heightMap[i][j],min(water[i−1][j],water[i+1][j],water[i][j−1],water[i][j+1]))\textit{water}[i][j] = \max(\textit{heightMap}[i][j],\min(\textit{water}[i-1][j],\textit{water}[i+1][j],\textit{water}[i][j-1],\textit{water}[i][j+1]))
     * water[i][j]=max(heightMap[i][j],min(water[i−1][j],water[i+1][j],water[i][j−1],water[i][j+1]))
     * 我们知道方块 (i,j)(i,j)(i,j) 实际接水的容量计算公式为 water[i][j]−heightMap[i][j]\textit{water}[i][j] - \textit{heightMap}[i][j]water[i][j]−heightMap[i][j]。 我们首先假设每个方块 (i,j)(i,j)(i,j) 的接水后的高度均为 water[i][j]=maxHeight\textit{water}[i][j] = \textit{maxHeight}water[i][j]=maxHeight，首先我们知道最外层的方块的肯定不能接水，所有的多余的水都会从最外层的方块溢出，我们每次发现当前方块 (i,j)(i,j)(i,j) 的接水高度 water[i][j]\textit{water}[i][j]water[i][j] 小于与它相邻的 444 个模块的接水高度时，则我们将进行调整接水高度，我们将其相邻的四个方块的接水高度调整与 (i,j)(i,j)(i,j) 的高度保持一致，我们不断重复的进行调整，直到所有的方块的接水高度不再有调整时即为满足要求。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/trapping-rain-water-ii/solutions/1079738/jie-yu-shui-ii-by-leetcode-solution-vlj3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @return
     */
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[] dirs = {-1, 0, 1, 0, -1};
        int maxHeight = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                maxHeight = Math.max(maxHeight, heightMap[i][j]);
            }
        }
        int[][] water = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j){
                water[i][j] = maxHeight;
            }
        }
        Queue<int[]> qu = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (water[i][j] > heightMap[i][j]) {
                        water[i][j] = heightMap[i][j];
                        qu.offer(new int[]{i, j});
                    }
                }
            }
        }
        while (!qu.isEmpty()) {
            int[] curr = qu.poll();
            int x = curr[0];
            int y = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nx = x + dirs[i], ny = y + dirs[i + 1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (water[x][y] < water[nx][ny] && water[nx][ny] > heightMap[nx][ny]) {
                    water[nx][ny] = Math.max(water[x][y], heightMap[nx][ny]);
                    qu.offer(new int[]{nx, ny});
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res += water[i][j] - heightMap[i][j];
            }
        }
        return res;
    }

}
