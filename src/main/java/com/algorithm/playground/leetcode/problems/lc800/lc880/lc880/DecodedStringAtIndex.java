package com.algorithm.playground.leetcode.problems.lc800.lc880.lc880;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/decoded-string-at-index/
 * <p>
 * An encoded string S is given.  To find and write the decoded string to a tape,
 * the encoded string is read one character at a time and the following steps are taken:
 * <p>
 * If the character read is a letter, that letter is written onto the tape.
 * If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
 * Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.
 * <p>
 * Note:
 * <p>
 * 2 <= S.length <= 100
 * S will only contain lowercase letters and digits 2 through 9.
 * S starts with a letter.
 * 1 <= K <= 10^9
 * The decoded string is guaranteed to have less than 2^63 letters.
 */
public class DecodedStringAtIndex {

	class Solution {
		public String decodeAtIndex(String S, int K) {
			K--;
			LinkedList<int[]> stack = new LinkedList<>();
			int[] multipliers = new int[S.length()];

			stack.push(new int[]{0, 0});

			long len = 0;
			int idx = 0;

			for (int i = 0; i < S.length(); i++) {
				char curr = S.charAt(i);
				if (Character.isDigit(curr)) {
					int multiplier = curr - '0';
					multipliers[++idx] = multiplier;
					len *= multiplier;
					if (len > K) {
						break;
					} else {
						stack.push(new int[]{i + 1, i + 1});
					}
				} else {
					//noinspection ConstantConditions
					stack.peek()[1]++;
					len++;
				}
			}

			while (idx != 0) {

				len /= multipliers[idx--];
				K %= len;

				int[] right = stack.pop();
				len -= right[1] - right[0];
				if (len <= K) {
					return String.valueOf(S.charAt((int) (right[0] + K - len)));
				}
			}
			return String.valueOf(S.charAt(K));
		}
	}

}
