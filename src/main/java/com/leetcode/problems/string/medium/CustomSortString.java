package com.leetcode.problems.string.medium;

import java.util.Arrays;
import java.util.Comparator;

public class CustomSortString {

	public static void main(String[] args) {
		int count = 0;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.print((int) ch + ", ");
			count++;
		}

		System.out.println();

		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.print((ch - 97) + ", ");
		}

		System.out.println();
		System.out.println(count);
	}

	class Solution {
		public String customSortString(String S, String T) {
			int[] weights = new int[26];

			Arrays.fill(weights, Integer.MAX_VALUE);

			for (int i = 0; i < S.length(); i++) {
				int idx = S.charAt(i) - 97;
				weights[idx] = i;
			}

			StringBuilder builder = new StringBuilder();
			T.chars()
				.boxed()
				.sorted(Comparator.comparingInt(ch -> weights[ch - 97]))
				.forEach(i -> builder.append(Character.toChars(i)));

			return builder.toString();
		}
	}

}
