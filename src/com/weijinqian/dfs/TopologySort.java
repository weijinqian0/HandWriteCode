package com.weijinqian.dfs;

import java.util.ArrayList;
import java.util.List;

public class TopologySort {
    List<List<Integer>> graph;
    List<Integer> res = new ArrayList<>();

    boolean dfs(int c, int[] isVistied) {
        isVistied[c] = 1;//c正在搜索
        for (int i = 0; i < graph.get(c).size(); i++) {
            if (isVistied[graph.get(c).get(i)] == 1) {
                return false;
            } else if (isVistied[graph.get(c).get(i)] == 0) {
                if (!dfs(graph.get(c).get(i), isVistied))
                    return false;
            }
            //如果后继节点next已经出现在当前dfs正在搜索路径的之上，next状态为1，证明存在环
            //如果后继节点next在其后代结点搜索过程中因为存在环退出搜索，也需要向上返回false
        }
        isVistied[c] = 2;//搜索完成
        res.add(c);
        return true;
    }

    public List<Integer> findOrder(int numCourses, int[][] prerequisites) {
        int[] isVistied = new int[numCourses];
        graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] r : prerequisites) {
            graph.get(r[0]).add(r[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (isVistied[i] == 0) {
                if (!dfs(i, isVistied))
                    return new ArrayList<>();
            }
        }
        return res;

    }

//    BFS
//    class Solution {
//        public:
//        vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
//            queue<int> q;
//            vector<int> res;
//            vector<int> inDegree(numCourses,0);
//            vector<vector<int>> graph(numCourses,vector<int>());
//            for(auto r: prerequisites)
//            {
//                graph[r[1]].push_back(r[0]);
//                inDegree[r[0]]++;
//            }
//            for(int i=0;i<numCourses;i++)
//            {
//                if(inDegree[i]==0)
//                {
//                    q.push(i);
//                }
//            }
//            while(!q.empty())
//            {
//                int t=q.front();
//                q.pop();
//                res.push_back(t);
//                for(int i=0;i<graph[t].size();i++)
//                {
//                    inDegree[graph[t][i]]--;
//                    if(inDegree[graph[t][i]]==0)
//                    {
//                        q.push(graph[t][i]);
//                    }
//                }
//            }
//            if(res.size()!=numCourses)
//                res={};
//            return res;
//        }
//    };


}
