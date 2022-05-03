## 本质
解决一个回溯问题，实际上就是解决一个决策树遍历的问题。
路径：就是已经做出的选择
选择列表：当前可以做出的选择；
结束条件：达到决策树底层，无法再做选择的条件。
本质上和DFS一样，是深度优先遍历。

## 回溯法和动态规划的关系
1. 动态规划的三个需要明确的条件：状态，选择，和basecase，
2. 回溯法对应的是路径，当前的选择列表，结束条件
3. 这里面回溯法和动态规划的不同为，动态规划一定是多选一，是唯一最值（大、小、长、短）的路径选择，而回溯法则是全部遍历