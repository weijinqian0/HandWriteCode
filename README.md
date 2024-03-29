# HandWriteCode

### 并查集我不会，需要花时间搞一下


### 动态规划算法
#### 三个条件
1. 最优子结构（最优解中包含子问题的最优解）
2. 无后效性 （1. 只关心前面阶段的状态值，不关心改状态怎么推导过来；2. 某阶段一但确定，就不受之后阶段的决策影响）
3. 重复子问题（必须重复才有意义）

#### 两种思路
1. 状态转移表法（大多数是二维的，如果是高维的就不适合用状态转移表法来解决）（这里相当于BFS，考虑每一步怎么做）
2. 状态转移方程法（这里相当于DFS，考虑每一步已经实现之后怎么做）

该仓库主要针对面试刷题，每一道题目会提供多种解法。
### 机器人运动范围
#### 题目描述
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

#### 解法：
1. DFS + 状态管理
2. 动态规划（维护状态矩阵DP和DP1）其中DP1优化了存储空间

### 剪绳子
####  题目描述：
给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

#### 解法：
1. DFS+状态管理
2. 动态规划，方程方法(相当于DFS)）
3. 动态规划，状态表（相当于BFS）

### 矩阵中的路径
#### 题目描述
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。

#### 解法与分析
暴力求解，不满足动态规划的无后效性（因为会互相影响）

### 最小编辑距离
解法：
1. 使用动态规划（方程法）
2. 使用DFS+状态管理
3. 使用动态规划（状态表方法）

### 剑指offer-数值的整数次方
解法：
1. 使用二分思想
2. 区分次幂的正负

### 剑指offer-倒数第k个节点
解法：
1. 两个指针
2. 递归，后序遍历

### 剑指offer-合并有序列表
解法：
1. 递归，分解子问题

### 剑指offer-顺时针打印矩阵
解法：
1. 维护上下左右四个边界信息

### 剑指offer-含有min函数的栈
解法：
1. 直接维护两个栈，一个是原生的栈  一个是维护当前最小值的栈

### 剑指offer-丑数
解法：
1. 维护三个指针，分别表示当前应该乘2，3，5的元素的下标

### 剑指offer-第一次只出现一次的字符
解法：
1. 需要保存一个字符数组，表明字符出现的先后顺序

### 剑指offer-栈的压入、弹出序列
解法：
1. 使用一个栈来保存弹出顺序；
2. 首先找到pop[i]在push中的下标；
3. 如果下标在当前push遍历下标的左侧，则代表要出栈，否则就代表是要进栈；
4. 每次遍历的时候，stack都要出栈，如果没有出栈，则return false，代表此时出错了。
5. 默认返回true。

### 剑指offer-从上往下打印二叉树
解法：
1. 层序遍历

### 剑指offer-二叉搜索树的后序遍历序列
解法：
1. 分解子问题
2. 子问题依然是二叉搜索树

### 剑指offer-二叉树中和为某一值的路径
解法：
1. 深度优先遍历，只不过被遍历的是两个分支，left和right
2. 需要考虑好最后循环结束后，是否有必要return

### 剑指offer-字符串的排列
解法：
1. 字符串排列使用swap的方式，对序列进行排列；
2. 对于重复字母的问题，需要考虑过滤下当前要交换的字母是不是需要相等

### 剑指offer-数组中超出一半的数字
解法：
1. 超出一半的数字，那么首先能找出当前需要判断的数字是什么？
2. 通过类似快排的思想，就可以得到当前处于中间位置的数字是啥，比如说X；
3. 最后还需要判断X是否超出了数组的一半。

这里用到了一个partition的函数，这个函数的作用是找出中位数，然后左边的数小于它，右边的数大于等于它
返回的是partition的下标。

### 剑指offer-最小的k个数
解法：
1. 和一半数字的思想一样，通过不断的partition，知道当前分割的index下标为k-1；
2. 然后获取前k个数字，并排序一下。

### 剑指offer-连续子数组的最大和
解法：
1. 维护一个状态表；表示当前的最大值
2. 每次有两次选择，一个是选择与之前的联合，一个是不选择联合
3. 最后再遍历一遍状态数组，取最大值

### 剑指offer-把数组排成最小的数
解法：直接排序，添加排序比较器

### 剑指offer-两个链表的第一个公共结点
解法：招到两个链表的差值，然后两个指针位，再一起寻找相等的节点

### 剑指offer-数字在排序数组中出现的次数
解法：使用二分查找，分别找出左边界和右边界

### 剑指offer-二叉树的深度
解法：递归求的左子树和右子树的最大值

### 剑指offer-数组中只出现一次的数字
解法：
1. 先求出所有数字的异或
2. 再求出异或的其中一位为1，分为两组数字
3. 对两组数字求异或的结果就是结果

### 剑指offer-扑克牌顺子
解法：
1. 将所有数字出现的次数放到一个数组中
2. 对数据每个开头遍历5个数字看下效果

### 剑指offer-把字符串转换成整数
解法：
需要考虑下边界条件就没啥问题了

### 剑指offer-数组中重复的数字
解法：
这个问题的关键在于数值的范围，用输入的数组来作为判断是否重复的方法。
从0-length，每次判断当前值和下标值的关系

### 剑指offer-构造乘积数组
解法：
前向后向分别乘一遍

### 剑指offer-滑动窗口的最大值
解法：
1. 维护一个队列，只做一件事：随着序列的遍历维护当前的窗口最大值
2. 如何维护最大值的呢？ 整个序列是单调递减的，所以第一个就是最大值；
3. 怎么样保证是处于窗口内的呢？通过存储最大值在数组中的下标来处理。

