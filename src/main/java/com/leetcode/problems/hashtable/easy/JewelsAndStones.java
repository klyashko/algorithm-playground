package com.leetcode.problems.hashtable.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/jewels-and-stones/description/
 */
public class JewelsAndStones {

	class Solution {
		public int numJewelsInStones(String J, String S) {
			Set<Character> jewels = new HashSet<>();
			for (char ch : J.toCharArray()) {
				jewels.add(ch);
			}
			int count = 0;
			for (char ch : S.toCharArray()) {
				if (jewels.contains(ch)) {
					count++;
				}
			}

			return count;
		}
	}

}
