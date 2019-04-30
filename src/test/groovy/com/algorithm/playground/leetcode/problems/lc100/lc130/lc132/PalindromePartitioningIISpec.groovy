package com.algorithm.playground.leetcode.problems.lc100.lc130.lc132

import com.algorithm.playground.leetcode.problems.lc100.lc130.lc132.PalindromePartitioningII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
class PalindromePartitioningIISpec extends Specification {

	@Unroll
	def "minCut"() {

		expect:

			new S().minCut(s) == out

		where:

			s                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      || out
			"aab"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  || 1
			"bb"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   || 0
			"aaabaa"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               || 1
			"apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp" || 452
			"adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece" || 273

	}

}
