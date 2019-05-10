package com.algorithm.playground.google.codejam._2019.c.task1;

import java.util.*;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/00000000000516b9/0000000000134c90
 */
public class Solution {

    public static void main(String[] args) {
        try (Scanner console = new Scanner(System.in)) {
            int tests = console.nextInt();
            for (int test = 1; test <= tests; test++) {
                int a = console.nextInt();
                Set<String> rows = new HashSet<>();
                for (int i = 0; i < a; i++) {
                    rows.add(shrink(console.next()));
                }
                String ans = solve(rows);
                System.out.println(String.format("Case #%s: %s", test, ans));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private static String shrink(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length, i = 0, j = -1;
        int[] dp = new int[len + 1];
        dp[0] = -1;
        while (i < len) {
            while (j >= 0 && chars[i] != chars[j]) {
                j = dp[j];
            }
            i++;
            j++;
            dp[i] = j;
        }
        int length = (len % (len - dp[len])) == 0 ? len / (len - dp[len]) : 1;
        return new String(Arrays.copyOf(chars, len / length));
    }

    private static String solve(Set<String> rows) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; !rows.isEmpty(); i++) {
            Set<Character> opts = new HashSet<>(Arrays.asList('P', 'S', 'R'));
            for (String str : rows) {
                opts.remove(getLoser(str.charAt(i % str.length())));
                if (opts.isEmpty()) {
                    return "IMPOSSIBLE";
                }
            }
            if (opts.size() == 1) {
                char curr = opts.iterator().next();
                builder.append(curr);
                Character looser = getLoser(curr);
                int finalI = i;
                rows.removeIf(s -> s.charAt(finalI % s.length()) == looser);
            } else {
                Iterator<Character> it = opts.iterator();
                builder.append(getWinner(it.next(), it.next()));
                rows.clear();
            }
        }

        return builder.toString();
    }

    private static char getWinner(Character ch1, Character ch2) {
        return getLoser(ch1) == ch2 ? ch1 : ch2;
    }

    private static Character getLoser(char ch) {
        switch (ch) {
            case 'P':
                return 'R';
            case 'R':
                return 'S';
            default:
                return 'P';
        }
    }

}
