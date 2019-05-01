package com.algorithm.playground.leetcode.problems.lc100.lc130.lc132

import com.algorithm.playground.leetcode.problems.lc100.lc130.lc132.PalindromePartitioningII.Solution as S
import com.algorithm.playground.leetcode.problems.lc100.lc130.lc132.PalindromePartitioningII.SolutionCached as SC
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
			"abc"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  || 2
			"abcd"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 || 3
			"abcde"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                || 4
			"apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp" || 452
			"adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece" || 273

	}

	@Unroll
	def "minCut_cached"() {

		expect:

			new SC().minCut(s) == out

		where:

			s                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      || out
			"aab"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  || 1
			"bb"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   || 0
			"aaabaa"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               || 1
			"abc"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  || 2
			"abcd"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 || 3
			"abcde"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                || 4
			"apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp" || 452
			"adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece" || 273

	}

}
