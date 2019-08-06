package com.algorithm.playground.leetcode.problems.lc1000.lc1100.lc1125

import com.algorithm.playground.leetcode.problems.lc1000.lc1100.lc1125.SmallestSufficientTeam.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Example 1:
 *
 * Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
 * Output: [0,2]
 *
 * Example 2:
 *
 * Input: req_skills = ["algorithms","math","java","reactjs","csharp","aws"],
 * people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
 * Output: [1,2]
 */
class SmallestSufficientTeamSpec extends Specification {

	@Unroll
	def "smallestSufficientTeam"() {

		expect:

			new S().smallestSufficientTeam(skills as String[], people).toSet() == out.toSet()

		where:

			skills                                                                   | people                                                                                                                    || out
			["java", "nodejs", "reactjs"]                                            | [["java"], ["nodejs"], ["nodejs", "reactjs"]]                                                                             || [0, 2]
			["algorithms", "math", "java", "reactjs", "csharp", "aws"]               | [["algorithms", "math", "java"], ["algorithms", "math", "reactjs"],
																						["java", "csharp", "aws"], ["reactjs", "csharp"], ["csharp", "math"], ["aws", "java"]]                                   || [1, 2]
			["zp", "jpphhnhwpw", "pscleb", "arn", "acrsxqvus", "fseqih",
			 "fpqbjbbxglivyonn", "cjozlkyodt", "mvtwffgkhjrtibto",
			 "kumdvfwsvrht", "i", "s", "ucr", "oo", "yqkqkhhhwngyjrg", "odiwidzqw"] || [["acrsxqvus"], ["zp"], [], ["fpqbjbbxglivyonn"], [], [], ["kumdvfwsvrht"], [], ["oo"], [], ["fseqih"], [], ["arn"], [],
																						[], ["yqkqkhhhwngyjrg"], [], [], [], ["kumdvfwsvrht"], ["s"], [], [], ["zp", "ucr"], [], ["pscleb"], [], [], [], [], [], [],
																						[], ["jpphhnhwpw"], [], [], [], ["oo"], [], ["i"], ["pscleb"], [], [], [], [], [], [], ["i"], [],
																						["mvtwffgkhjrtibto", "odiwidzqw"], [], ["cjozlkyodt", "odiwidzqw"], ["arn"], [], [], ["acrsxqvus"], [], [], [], ["ucr"]] || [23, 49, 51, 0, 3, 6, 8, 10, 12, 15, 20, 25, 33, 39]

	}

}