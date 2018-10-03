package com.leetcode.problems.dynamicprogramming.hard

import spock.lang.Specification
import spock.lang.Unroll

class WildcardMatchingSpec extends Specification {

	@Unroll
	@SuppressWarnings("GroovyPointlessBoolean")
	def "isMatch"() {

		expect:

			new WildcardMatching.Solution().isMatch(str, pattern) == output

		where:

			str                                                                                                                                                                                                            || pattern                                                                                                   || output
			"abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb" || "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb" || false
			"c"                                                                                                                                                                                                            || "*?*"                                                                                                     || true
			"hi"                                                                                                                                                                                                           || "*?"                                                                                                      || true
			"a"                                                                                                                                                                                                            || "a*"                                                                                                      || true
			"aa"                                                                                                                                                                                                           || "a"                                                                                                       || false
			"aa"                                                                                                                                                                                                           || "*"                                                                                                       || true
			"a"                                                                                                                                                                                                            || "?"                                                                                                       || true
			"aa"                                                                                                                                                                                                           || "??"                                                                                                      || true
			"cb"                                                                                                                                                                                                           || "?a"                                                                                                      || false
			"adceb"                                                                                                                                                                                                        || "*a*b"                                                                                                    || true
			"acdcb"                                                                                                                                                                                                        || "a*c?b"                                                                                                   || false

	}

}