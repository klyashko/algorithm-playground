package com.leetcode.problems.math.medium

import com.leetcode.problems.math.medium.EncodeAndDecodeTinyURL.Codec as C
import spock.lang.Specification
import spock.lang.Unroll

class EncodeAndDecodeTinyURLSpec extends Specification {

	@Unroll
	def "encodeAndDecodeTinyURL"() {

		given:

			def c = new C()

		when:

			def encoded = c.encode("https://leetcode.com/" + url)

		then:

			encoded
			c.decode(encoded) == "https://leetcode.com/" + url

		where:

			url                            || _
			"problems/design-tinyurl"      || _
			"?brother=agreement&beds=bird" || _
			"#badge"                       || _
			""                             || _

	}

}
