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
            Map<String, Set<String>> options = new HashMap<>();
            options.put(beginWord, findAllSimilar(beginWord, wordList));
            for (String word : wordList) {
                if (!word.equals(endWord)) {
                    options.put(word, findAllSimilar(word, wordList));
                }
            }

            Map<String, List<String>> map = new HashMap<>();
            Queue<String> queue = new ArrayDeque<>();
            Set<String> unvisited = new HashSet<>(wordList);
            Set<String> visited = new HashSet<>();

            queue.add(beginWord);
            unvisited.add(endWord);
            unvisited.remove(beginWord);

            int currentStepSize = 1;
            int nextStepSize = 0;
            boolean found = false;

            while (!queue.isEmpty()) {
                String current = queue.poll();
                currentStepSize--;
                for (String nextWord : options.getOrDefault(current, new HashSet<>())) {
                    if (unvisited.contains(nextWord)) {
                        if (visited.add(nextWord)) {
                            nextStepSize++;
                            queue.add(nextWord);
                        }

                        map.computeIfAbsent(nextWord, ignored -> new ArrayList<>()).add(current);
                        found = nextWord.equals(endWord);
                    }
                }
                if (currentStepSize == 0) {
                    if (found) {
                        break;
                    }
                    currentStepSize = nextStepSize;
                    nextStepSize = 0;
                    unvisited.removeAll(visited);
                    visited.clear();
                }
            }

            List<List<String>> results = new ArrayList<>();
            backtrace(endWord, beginWord, new LinkedList<>(), results, map);
            return results;
        }

        private void backtrace(String word, String start, List<String> list, List<List<String>> results, Map<String, List<String>> map) {
            if (word.equals(start)) {
                List<String> way = new ArrayList<>(list.size() + 1);
                way.add(start);
                way.addAll(list);
                results.add(way);
            } else {
                list.add(0, word);
                for (String s : map.getOrDefault(word, new ArrayList<>())) {
                    backtrace(s, start, list, results, map);
                }
                list.remove(0);
            }
        }

        private Set<String> findAllSimilar(String word, List<String> wordList) {
            Set<String> set = new HashSet<>();
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
                    set.add(option);
                }
            }
            return set;
        }
    }

}
