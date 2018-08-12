package com.leetcode.problems.array.hard;

/**
 * https://leetcode.com/problems/first-missing-positive/description/
 */
public class FirstMissingPositive {

    class Solution {
        public int firstMissingPositive(int[] nums) {
            int missing = 1;
            for (int i = 0; i < nums.length; ) {
                if (missing == nums[i]) {
                    swap(nums, missing - 1, i);
                    while (missing <= nums.length && nums[missing - 1] == missing) {
                        missing++;
                    }
                }
                int current = nums[i];
                if (current > 0 && current < nums.length && nums[current - 1] != current) {
                    swap(nums, current - 1, i);
                } else {
                    i++;
                }
            }
            return missing;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
