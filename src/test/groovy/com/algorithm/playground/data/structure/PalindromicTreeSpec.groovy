package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.nextInt
import static com.algorithm.playground.TestUtils.nextString

class PalindromicTreeSpec extends Specification {

	@Repeat(10)
	def "PalindromicTree#getAllPalindrome()"() {

		given:

			def p = nextString(nextInt(3, 10))
			def s = nextString(nextInt(3, 10)) + p + p.reverse() + nextString(nextInt(3, 10))
			def tree = new PalindromicTree(s)

		expect:

			findAllPalindromes(s) == tree.allPalindrome.toSet()

	}

	@Repeat(10)
	def "PalindromicTree#getMaxPalindrome()"() {

		given:

			def p = nextString(nextInt(5, 15))
			def left = nextString(nextInt(3, 8))
			def right = nextString(nextInt(3, 8))
			def palindrome = p + p.reverse()
			def s = left + palindrome + right

			int l = left.length()
			int r = l + palindrome.length() - 1

			while (l >= 0 && r < s.length() && s[l] == s[r]) {
				l--
				r++
			}

			def tree = new PalindromicTree(s.chars)

		expect:

			s.substring(l + 1, r) == tree.maxPalindrome

	}

	private static Set<String> findAllPalindromes(String s) {
		def set = new HashSet<>()
		for (int i = 0; i < s.length(); i++) {
			addAll(s, i, i, set)
			addAll(s, i, i + 1, set)
		}
		return set
	}

	private static addAll(String s, int l, int r, Set<String> set) {
		while (l >= 0 && r < s.length() && s[l] == s[r]) {
			set << s.substring(l, r + 1)
			l--
			r++
		}
	}

}