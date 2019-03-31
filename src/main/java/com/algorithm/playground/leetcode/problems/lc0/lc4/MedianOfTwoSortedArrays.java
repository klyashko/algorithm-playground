package com.algorithm.playground.leetcode.problems.lc0.lc4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
@SuppressWarnings("Duplicates")
public class MedianOfTwoSortedArrays {

    public class SolutionWithHeaps {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            PriorityQueue<Integer> q1 = new PriorityQueue<>();
            PriorityQueue<Integer> q2 = new PriorityQueue<>(Comparator.reverseOrder());
            int i = nums1.length - 1, j = nums2.length - 1;
            while (i > -1 || j > -1) {
                int toInsert;
                if (i > -1 && j > -1) {
                    if (nums1[i] > nums2[j]) {
                        toInsert = nums1[i--];
                    } else {
                        toInsert = nums2[j--];
                    }
                } else if (i > -1) {
                    toInsert = nums1[i--];
                } else {
                    toInsert = nums2[j--];
                }

                if (q1.size() == q2.size()) {
                    q2.add(toInsert);
                } else {
                    q1.add(q2.poll());
                    q2.add(toInsert);
                }
            }
            if (q2.size() > q1.size()) {
                return q2.poll();
            } else {
                return (q1.poll() + q2.poll()) / 2.;
            }
        }

    }

    public class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length = nums1.length + nums2.length;
            int[] window = new int[length % 2 == 0 ? 2 : 1];
            int i = nums1.length - 1, j = nums2.length - 1;
            for (int until = length / 2 + 1; until > 0; until--) {
                int toInsert;
                if (i > -1 && j > -1) {
                    if (nums1[i] > nums2[j]) {
                        toInsert = nums1[i--];
                    } else {
                        toInsert = nums2[j--];
                    }
                } else if (i > -1) {
                    toInsert = nums1[i--];
                } else {
                    toInsert = nums2[j--];
                }

                if (window.length == 2) {
                    window[1] = window[0];
                }
                window[0] = toInsert;
            }
            if (window.length == 1) {
                return window[0];
            } else {
                return (window[0] + window[1]) / 2.;
            }
        }

    }

}
