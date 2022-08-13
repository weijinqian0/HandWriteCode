package com.weijinqian.dfs;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {

    /**
     * 241. 为运算表达式设计优先级
     * 本质就是运算符的全排列计算过程，那么怎么模拟这个过程呢
     * 这个题解是错的，会有重复值多出来
     *
     * @param expression
     * @return
     */
    public List<Integer> diffWaysToCompute(String expression) {
        if (expression == null || expression.length() == 0) {
            return new ArrayList<>();
        }
        String[] numStr = expression.split("/+|/-|/*|//");
        List<Integer> nums = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        for (int i = 0; i < numStr.length; i++) {
            if (numStr[i].length() == 0) {
                continue;
            }
            if (expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '/') {
                operators.add(expression.charAt(i));
            } else {
                nums.add(Integer.parseInt(numStr[i]));
            }
        }

        List<Integer> res = new ArrayList<>();
        compute(nums, operators, res);
        return res;
    }

    public void compute(List<Integer> numbers, List<Character> operators, List<Integer> res) {
        if (numbers.size() == 1 || operators.size() == 0) {
            res.add(numbers.get(0));
            return;
        }
        for (int i = 0; i < operators.size(); i++) {
            List<Character> copyOperators = new ArrayList<>(operators);
            List<Integer> copyNumbers = new ArrayList<>(numbers);

            int num1 = numbers.get(i);
            int num2 = numbers.get(i + 1);
            int tmp = 0;
            if (operators.get(i) == '*') {
                tmp = num1 * num2;
            } else if (operators.get(i) == '+') {
                tmp = num1 + num2;
            } else if (operators.get(i) == '-') {
                tmp = num1 - num2;
            } else if (operators.get(i) == '/') {
                tmp = num1 / num2;
            }
            copyOperators.remove(i);
            copyNumbers.remove(i);
            copyNumbers.add(i, tmp);
            copyNumbers.remove(i + 1);
            compute(copyNumbers, copyOperators, res);

        }
    }


    /**
     * @param expression
     * @return
     */
    public List<Integer> diffWaysToCompute1(String expression) {
        if (expression.length() <= 2) {
            List<Integer> ret = new ArrayList<>();
            ret.add(Integer.parseInt(expression));
            return ret;
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '/') {
                List<Integer> left = diffWaysToCompute1(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute1(expression.substring(i + 1));
                for (int a : left) {
                    for (int b : right) {
                        if (expression.charAt(i) == '*') {
                            ret.add(a * b);
                        } else if (expression.charAt(i) == '-') {
                            ret.add(a - b);
                        } else if (expression.charAt(i) == '+') {
                            ret.add(a + b);
                        } else {
                            ret.add(a / b);
                        }
                    }
                }
            }
        }
        return ret;
    }


}
