package com.leetcode.problems.array.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/description/
 */
public class WordLadderII {

    public class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return Collections.emptyList();
            }
            Map<String, List<String>> options = new HashMap<>();
            options.put(beginWord, findAllSimilar(beginWord, wordList));
            for (String word : wordList) {
                if (!word.equals(endWord)) {
                    options.put(word, findAllSimilar(word, wordList));
                }
            }

            Queue<Node> queue = new ArrayDeque<>();
            List<List<String>> result = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            int shortest = Integer.MAX_VALUE;

            Node node = new Node(beginWord, null);
            visited.add(beginWord);
            queue.add(node);

            while (!queue.isEmpty()) {
                Node current = queue.poll();
                if (shortest < current.size) {
                    break;
                } else if (current.value.equals(endWord)) {
                    LinkedList<String> way = new LinkedList<>();
                    result.add(way);
                    while (current != null) {
                        way.addFirst(current.value);
                        current = current.prev;
                    }
                    shortest = way.size();
                } else {
                    for (String next : options.get(current.value)) {
                        if (!visited.contains(next) || next.equals(endWord)) {
                            Node n = new Node(next, current);
                            visited.add(next);
                            queue.add(n);
                        }
                    }
                }
            }

            return result;
        }

        private List<String> findAllSimilar(String word, List<String> wordList) {
            List<String> list = new ArrayList<>();
            for (String option : wordList) {
                if (option.equals(word)) {
                    continue;
                }
                boolean diff = false;
                boolean add = true;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != option.charAt(i)) {
                        if (diff) {
                            add = false;
                            break;
                        } else {
                            diff = true;
                        }
                    }
                }
                if (add) {
                    list.add(option);
                }
            }
            return list;
        }

        private class Node {
            String value;
            Node prev;
            int size = 1;

            public Node(String value, Node prev) {
                this.value = value;
                this.prev = prev;
                if (prev != null) {
                    size += prev.size;
                }
            }
        }
    }

}
