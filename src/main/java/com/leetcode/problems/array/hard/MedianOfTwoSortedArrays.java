package com.leetcode.problems.array.hard;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {

    public class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length != 0 && nums2.length == 0) {
                int middle = nums1.length / 2;
                if (nums1.length % 2 == 0) {
                    return (nums1[middle - 1] + nums1[middle]) / 2.;
                } else {
                    return nums1[middle];
                }
            } else if (nums1.length == 0 && nums2.length != 0) {
                int middle = nums2.length / 2;
                if (nums2.length % 2 == 0) {
                    return (nums2[middle - 1] + nums2[middle]) / 2.;
                } else {
                    return nums2[middle];
                }
            } else if (nums1.length == 1 && nums2.length == 1) {
                return (nums1[0] + nums2[0]) / 2.;
            } else if (nums1.length == 1 && nums2.length == 2) {
                return Math.min(Math.max(nums1[0], nums2[0]), nums2[1]);
            } else if (nums1.length == 2 && nums2.length == 1) {
                return Math.min(Math.max(nums1[0], nums2[0]), nums1[1]);
            }
            int length = nums1.length + nums2.length;
            int middle = length / 2;
            if (length % 2 == 0) {
                middle--;
            }
            int i = 0, j = 0;
            int lastUpdate = -1;

            while ((i + j) < middle) {
                if (i + 1 < nums1.length && j + 1 < nums2.length) {
                    if (nums1[i] < nums2[j]) {
                        i++;
                        lastUpdate = 0;
                    } else {
                        j++;
                        lastUpdate = 1;
                    }
                } else if (i + 1 < nums1.length) {
                    i++;
                    lastUpdate = 0;
                } else {
                    j++;
                    lastUpdate = 1;
                }
            }

            System.out.println(i);
            System.out.println(j);
            System.out.println(middle);
            System.out.println(lastUpdate);

            if (length % 2 == 0) {
                int first, second;
                if (nums1[i] < nums2[j]) {
                    System.out.println("first = nums1[i]");
                    first = nums1[i];
                    if (lastUpdate == 0) {
                        i++;
                    } else {
                        lastUpdate = 0;
                    }
                } else {
                    first = nums2[j];
                    if (lastUpdate == 1) {
                        j++;
                    } else {
                        lastUpdate = 1;
                    }
                }
//                System.out.println(i);
//                System.out.println(j);
                if (i + 1 < nums1.length && j + 1 < nums2.length) {
//                    System.out.println("i + 1 < nums1.length && j + 1 < nums2.length");
                    if (lastUpdate == 0) {
                        i++;
                    } else {
                        j++;
                    }
                    if (nums1[i] < nums2[j]) {
                        second = nums1[i];
                    } else {
                        second = nums2[j];
                    }
                } else if (i + 1 < nums1.length) {
//                    System.out.println("i + 1 < nums1.length");
                    if (lastUpdate == 0) {
                        i++;
                    }
                    second = nums1[i];
                } else if (j + 1 < nums2.length) {
//                    System.out.println("else");
                    if (lastUpdate == 1) {
                        j++;
                    }
                    second = nums2[j];
                } else {
                    second = lastUpdate == 0 ? nums2[j] : nums1[i];
                }

                System.out.println(first);
                System.out.println(second);
                return (first + second) / 2.;

            } else {
//                if (lastUpdate == 0) {
//                    return nums1[i];
//                } else {
//                    return nums2[j];
//                }
                return nums1[i] < nums2[j] ? nums1[i] : nums2[j];
            }
        }
    }

}
