package com.leetcode.problems.array.hard;

/**
 * https://leetcode.com/problems/jump-game-ii/description/
 */
public class JumpGameII {

    class Solution {
        public int jump(int[] nums) {
            //Already there :)
            if (nums.length == 1) {
                return 0;
            }
            int jumps = 0;

            for (int i = 0; i < nums.length; ) {
                jumps++;
                if (i + nums[i] + 1 >= nums.length) {
                    return jumps;
                }
                int next = i + 1;
                int nextGain = nums[next] + i;
                for (int j = next; j < nums[i] + i + 1; j++) {
                    if (nums[j] + j > nextGain) {
                        next = j;
                        nextGain = nums[j] + j;
                    }
                }
                i = next;
            }
            return jumps;
        }
    }

}
