package com.algorithm.playground.leetcode.problems.lc300.lc350.lc355

import spock.lang.Specification
import spock.lang.Unroll

class TwitterSpec extends Specification {

	@Unroll
	def "twitter"() {

		given:

			def t = new Twitter()

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					assert t."$method"(arg) == result
			}

		where:

			methods                                                                                                                                                                    | args                                                                                                         || results
			["postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]                                                                              | [[1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]                                                              || [null, [5], null, null, [6, 5], null, [5]]
			["postTweet", "follow", "getNewsFeed"]                                                                                                                                     | [[1, 5], [1, 1], [1]]                                                                                        || [null, null, [5]]
			["postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "postTweet", "getNewsFeed", "follow", "getNewsFeed"] | [[2, 5], [1, 3], [1, 101], [2, 13], [2, 10], [1, 2], [2, 94], [2, 505], [1, 333], [1, 22], [2], [2, 1], [2]] || [null, null, null, null, null, null, null, null, null, null, [505, 94, 10, 13, 5], null, [22, 333, 505, 94, 2, 10, 13, 101, 3, 5]]

	}

}
