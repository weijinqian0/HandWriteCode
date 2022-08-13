package com.weijinqian.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    /**
     * 139. 单词拆分
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
     *
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
