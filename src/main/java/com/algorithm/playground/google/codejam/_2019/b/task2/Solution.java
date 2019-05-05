package com.algorithm.playground.google.codejam._2019.b.task2;

import java.util.Scanner;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051706/0000000000122837
 */
public class Solution {

    private static Scanner console;

    public static void main(String[] args) {
        try (Scanner console = new Scanner(System.in)) {
            Solution.console = console;
            int tests = console.nextInt();
            // number of queries
            int w = console.nextInt();
            for (int test = 1; test <= tests; test++) {
                if (w == 6) {
                    solveTestSet1();
                } else {
                    solveTestSet2();
                }
                if (console.nextInt() == -1) {
                    while (console.hasNext()) {
                        console.next();
                    }
                    throw new RuntimeException("WA");
                }
            }
        }
    }

    private static void solveTestSet1() {
        long[] days = new long[6];
        for (int i = 0; i < days.length - 1; i++) {
            System.out.println((i + 1) * 63);
            days[i] = console.nextLong();
        }
        System.out.println(1);
        days[5] = console.nextLong();
        long[] ans = new long[6];
        long sum = 0;
        for (int i = ans.length - 1; i > 0; i--) {
            ans[i] = calculate(days, ans, i + 1);
            sum += ans[i];
        }
        ans[0] = (days[5] - sum) >> 1;
        for (long l : ans) {
            System.out.print(l + " ");
        }
        System.out.println();
    }

    private static void solveTestSet2() {
        int day = 220;
        long response = sendAndGet(day);
        long[] ans = new long[6];

        for (int i = 4; i <= 6; i++) {
            ans[i - 1] = response >> (day / i) & 127;
        }

        day = 48;
        response = sendAndGet(day);

        for (int i = 4; i <= 6; i++) {
            response -= ans[i - 1] << (day / i);
        }

        for (int i = 1; i <= 3; i++) {
            ans[i - 1] = response >> (day / i) & 127;
        }

        for (long l : ans) {
            System.out.print(l + " ");
        }
        System.out.println();
    }

    private static long sendAndGet(int day) {
        System.out.println(day);
        return console.nextLong();
    }

    private static long calculate(long[] days, long[] ans, int day) {
        long y = days[day - 2];
        for (int i = day + 1; i <= 6; i++) {
            y -= ans[i - 1] * (long) Math.pow(2, getPower(day - 1, i));
        }
        return y / (long) Math.pow(2, getPower(day - 1, day));
    }

    private static int getPower(int queryDay, int day) {
        return queryDay * 63 / day;
    }

}
