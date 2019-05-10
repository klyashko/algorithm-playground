package com.algorithm.playground.google.codejam._2019.b.task3;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.numberOfLeadingZeros;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051706/0000000000122838
 */
@SuppressWarnings("Duplicates")
public class Solution {

    private static Scanner console;

    public static void main(String[] args) {
        try (Scanner console = new Scanner(System.in)) {
            Solution.console = console;
            int tests = console.nextInt();
            for (int test = 1; test <= tests; test++) {
                int p = console.nextInt();
                int k = console.nextInt();
                int[] c = read(p);
                int[] d = read(p);
                long ans = solve(c, d, k);
                System.out.println(String.format("Case #%s: %s", test, ans));
            }
        }
    }

    private static long solve(int[] c, int[] d, int k) {
        SparseMaxTable cTable = new SparseMaxTable(c);
        SparseMaxTable dTable = new SparseMaxTable(d);
        return dp(cTable, dTable, k, 0, c.length - 1);
    }

    private static long dp(SparseMaxTable c, SparseMaxTable d, int k, int lo, int hi) {
        if (lo > hi) {
            return 0;
        }
        int idx = c.getMaxIdx(lo, hi);
        int val = c.values[idx];

        long lInclude = idx - left(d, val + k + 1, lo, idx);
        long rInclude = right(d, val + k + 1, idx, hi) - idx;

        long lExclude = idx - left(d, val - k, lo, idx);
        long rExclude = right(d, val - k, idx, hi) - idx;

        long count = lInclude * rInclude - lExclude * rExclude;

        return count + dp(c, d, k, lo, idx - 1) + dp(c, d, k, idx + 1, hi);
    }

    private static int left(SparseMaxTable table, int val, int lo, int hi) {
        while (lo <= hi) {
            int mid = (hi - lo >> 1) + lo;
            if (table.getMaxVal(mid, hi) < val) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    private static int right(SparseMaxTable table, int val, int lo, int hi) {
        while (lo <= hi) {
            int mid = (hi - lo >> 1) + lo;
            if (table.getMaxVal(lo, mid) < val) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private static int[] read(int size) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = console.nextInt();
        }
        return data;
    }

    public static class SparseMaxTable {

        private int[] values;
        private int[][] table;

        public SparseMaxTable(int[] values) {
            int log = log2(values.length);
            this.values = values;
            this.table = new int[values.length - 1][log];
            buildTable(log);
        }

        public int getMaxVal(int lo, int hi) {
            return values[getMaxIdx(lo, hi)];
        }

        /**
         * @param lo
         * @param hi
         *
         * @return an index of max element in range between lo (inclusive) and hi (inclusive)
         */
        public int getMaxIdx(int lo, int hi) {
            int size = hi - lo + 1;
            if (size == 1) {
                return lo;
            }
            int log = log2(size);
            int k = lo + size - (1 << log);
            int i = table[lo][log - 1];
            int j = table[k][log - 1];
            return getMax(i, j);
        }

        private int log2(int i) {
            return 31 - numberOfLeadingZeros(i);
        }

        /**
         * @param idx1
         * @param idx2
         *
         * @return an index of max element with respect to it's value
         */
        private int getMax(int idx1, int idx2) {
            return values[idx2] > values[idx1] ? idx2 : idx1;
        }

        private void buildTable(int log) {
            for (int i = 0; i < table.length; i++) {
                table[i][0] = getMax(i, i + 1);
            }
            for (int i = 1; i < log; i++) {
                int size = 1 << (i + 1);
                for (int j = 0; j + size - 1 < values.length; j++) {
                    int idx1 = table[j][i - 1];
                    int idx2 = table[j + (1 << i)][i - 1];
                    table[j][i] = getMax(idx1, idx2);
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int[] r : table) {
                if (builder.length() != 0) {
                    builder.append("        ");
                }
                builder.append(Arrays.toString(r)).append('\n');
            }
            return "SparseMaxTable{\n" +
                    "values = " + Arrays.toString(values) + "\n" +
                    "table = " + builder.toString() + '}';
        }
    }

}