package com.weijinqian.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    /**
     * 139. 单词拆分
     * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
     *
     * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     *
     *
     *
     * 示例 1：
     *
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
     * 示例 2：
     *
     * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
     * 输出: true
     * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     *      注意，你可以重复使用字典中的单词。
     * 示例 3：
     *
     * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * 输出: false
     *
     * @param s
     * @param wordDict
     * @return
     */
    Map<String, Boolean> memory = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (memory.containsKey(s)) {
            return memory.get(s);
        }
        if (wordDict.contains(s)) {
            memory.put(s, true);
            return true;
        }
        boolean success = false;
        for (int i = 1; i < s.length(); i++) {
            String sub = s.substring(0, i);
            if (!wordDict.contains(sub)) {
                continue;
            }
            success = success || wordBreak(s.substring(i), wordDict);
        }
        memory.put(s, success);
        return success;
    }


    /**
     * 140. 单词拆分 II
     * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
     *
     * 注意：词典中的同一个单词可能在分段中被重复使用多次。
     * 示例 1：
     *
     * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
     * 输出:["cats and dog","cat sand dog"]
     * 示例 2：
     *
     * 输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
     * 输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
     * 解释: 注意你可以重复使用字典中的单词。
     * 示例 3：
     *
     * 输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * 输出:[]
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak1(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        DFS(s, wordDict, new ArrayList<>(), res);
        return res;
    }

    public void DFS(String s, List<String> wordDict, List<String> cur, List<String> res) {
        if (s.equals("")) {
            res.add(listToStr(cur));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (!wordDict.contains(sub)) {
                continue;
            }
            cur.add(sub);
            DFS(s.substring(i), wordDict, cur, res);
            cur.remove(cur.size() - 1);
        }

    }

    /**
     * list 转换为字符串
     *
     * @param list
     * @return
     */
    public String listToStr(List<String> list) {
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                cur.append(" ");
            }
            cur.append(list.get(i));
        }
        return cur.toString();
    }

}
