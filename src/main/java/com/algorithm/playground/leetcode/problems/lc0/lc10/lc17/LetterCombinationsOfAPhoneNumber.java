package com.algorithm.playground.leetcode.problems.lc0.lc10.lc17;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * <p>
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {

	/**
	 * 2 -> abc
	 * 3 -> def
	 * 4 -> ghi
	 * 5 -> jkl
	 * 6 -> mno
	 * 7 -> pqrs
	 * 8 -> tuv
	 * 9 -> wxyz
	 */
	class Solution {

		public List<String> letterCombinations(String digits) {
			char[][] letters = {
					{},
					{},
					{'a', 'b', 'c'},
					{'d', 'e', 'f'},
					{'g', 'h', 'i'},
					{'j', 'k', 'l'},
					{'m', 'n', 'o'},
					{'p', 'q', 'r', 's'},
					{'t', 'u', 'v'},
					{'w', 'x', 'y', 'z'}
			};
			if (digits.isEmpty()) {
				return Collections.emptyList();
			}
			return Arrays.asList(letterCombinations(digits, 0, letters));
		}

		private String[] letterCombinations(String digits, int idx, char[][] letters) {
			if (idx == digits.length()) {
				return new String[]{""};
			} else {
				int ch = digits.charAt(idx) - '0';
				String[] list = letterCombinations(digits, idx + 1, letters);
				String[] result = new String[list.length * letters[ch].length];

				int i = 0;
				for (char c : letters[ch]) {
					for (String s : list) {
						result[i++] = c + s;
					}
				}
				return result;
			}
		}
	}

}
