package com.leetcode.problems.hash.table.hard

import com.leetcode.problems.hash.table.hard.InsertDeleteGetRandomDuplicatesAllowed.RandomizedCollection as RC
import spock.lang.Specification

class InsertDeleteGetRandomDuplicatesAllowedSpec extends Specification {

	def "RandomizedCollection"() {

		given:

			def rc = new RC()

		expect:

			rc.insert(1)
			rc.remove(1)
			rc.insert(1)

	}

}
