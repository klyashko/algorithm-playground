package com.leetcode.problems.dynamic.programming.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/description/
 */
public class ShortestPathVisitingAllNodes {

    class Solution {
        public int shortestPathLength(int[][] graph) {
            boolean[] visited = new boolean[graph.length];

            Queue<Node> queue = new ArrayDeque<>();
            Node start = new Node(0, null);
            Node end = null;

            visited[0] = true;

            queue.add(start);

            int cursor = 0;

            while (!queue.isEmpty() && end == null) {
                Node current = queue.poll();
                //noinspection ConstantConditions
                for (int i = 0; i < graph[current.id].length; i++) {
                    int val = graph[current.id][i];
                    Node n = new Node(val, current);
                    visited[val] = true;
                    while (cursor < visited.length && visited[cursor]) {
                        cursor++;
                    }
                    if (cursor == visited.length) {
                        end = n;
                        break;
                    }
                    queue.add(n);
                }
            }

            if (end == null) {
                return 0;
            }

            int count = 0;

            while (end != null) {
                count++;
                end = end.prev;
            }

            return count;
        }

        private class Node {
            int id;
            Node prev;

            private Node(int id, Node prev) {
                this.id = id;
                this.prev = prev;
            }
        }
    }

}
