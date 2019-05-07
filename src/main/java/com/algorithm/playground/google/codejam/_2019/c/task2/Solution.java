package com.algorithm.playground.google.codejam._2019.c.task2;

import java.util.*;
import java.util.Map.Entry;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/00000000000516b9/0000000000134e91#
 */
public class Solution {

    private static Scanner console;

    public static void main(String[] args) {
        try (Scanner console = new Scanner(System.in)) {
            Solution.console = console;
            int tests = console.nextInt();
            //skip number oa requests
            console.nextInt();
            for (int test = 1; test <= tests; test++) {
                String ans = solve();
                System.out.println(ans);
                if (console.next().equals("N")) {
                    throw new RuntimeException("WA");
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private static String solve() {
        char[] ans = new char[5];
        List<Integer> requests = new ArrayList<>();
        for (int i = 0; i < 595; i += 5) {
            requests.add(i);
        }
        Set<Character> expected = new HashSet<>(Arrays.asList('A', 'B', 'C', 'D', 'E'));
        for (int i = 0; i < 4; i++) {
            Entry<Character, List<Integer>> missing = getMissing(requests);
            expected.remove(missing.getKey());
            if (i != 3) {
                ans[i] = missing.getKey();
                requests = missing.getValue();
            } else {
                ans[3] = expected.iterator().next();
                ans[4] = missing.getKey();
            }
        }
        return new String(ans);
    }

    private static Entry<Character, List<Integer>> getMissing(List<Integer> requests) {
        Map<Character, List<Integer>> positions = new HashMap<>();
        for (Integer i : requests) {
            System.out.println(i + 1);
            Character response = console.next().charAt(0);
            if (!positions.containsKey(response)) {
                List<Integer> list = new ArrayList<>();
                list.add(i + 1);
                positions.put(response, list);
            } else {
                positions.get(response).add(i + 1);
            }
        }
        Entry<Character, List<Integer>> missing = null;
        for (Entry<Character, List<Integer>> entry : positions.entrySet()) {
            if (missing == null || missing.getValue().size() > entry.getValue().size()) {
                missing = entry;
            }
        }
        return missing;
    }

}
