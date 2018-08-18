package com.leetcode.problems.dynamic.programming.medium;

import java.util.Arrays;

public class MinimumASCIIDeleteSumForTwoStrings {

	class Solution {
		public int minimumDeleteSum(String s1, String s2) {
			System.out.println(lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
			//			boolean[] toDelete1 = toDelete(s1, s2);
			//			boolean[] toDelete2 = toDelete(s2, s1);
			//			System.out.println(deleteCharacters(toDelete1, s1));
			//			System.out.println(deleteCharacters(toDelete2, s2));
			return 0;
		}

		private int lcs(char[] X, char[] Y, int m, int n) {
			if (m == 0 || n == 0) {
				return 0;
			}
			if (X[m - 1] == Y[n - 1]) {
				return 1 + lcs(X, Y, m - 1, n - 1);
			} else {
				return Math.max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
			}
		}

		private String deleteCharacters(boolean[] marker, String s) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < marker.length; i++) {
				if (!marker[i]) {
					builder.append(s.charAt(i));
				}
			}
			return builder.toString();
		}

		private boolean[] toDelete(String s1, String s2) {
			int pos = 0;
			boolean[] rez = new boolean[s1.length()];
			Arrays.fill(rez, false);
			for (int i = 0; i < s1.length(); i++) {
				char toSearch = s1.charAt(i);
				int j = pos;
				for (; j < s2.length(); j++) {
					if (toSearch == s2.charAt(j)) {
						break;
					}
				}
				if (j != s2.length()) {
					pos = j;
				} else {
					rez[i] = true;
				}
			}

			return rez;
		}
	}

}
