package com.leetcode.problems.array.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfTwoSortedArrays {

    public class Solution {
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

}
