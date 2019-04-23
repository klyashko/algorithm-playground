package com.algorithm.playground.leetcode.problems.lc900.lc981

import com.algorithm.playground.leetcode.problems.lc900.lc981.TimeBasedKeyValueStore.TimeMap as TM
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Input: inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * Output: [null,null,"bar","bar",null,"bar2","bar2"]
 * Explanation:
 * TimeMap kv;
 * kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
 * kv.get("foo", 1);  // output "bar"
 * kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"
 * kv.set("foo", "bar2", 4);
 * kv.get("foo", 4); // output "bar2"
 * kv.get("foo", 5); //output "bar2"
 *
 * Input: inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
 * Output: [null,null,null,"","high","high","low","low"]
 *
 * All key/value strings are lowercase.
 * All key/value strings have length in the range [1, 100]
 * The timestamps for all TimeMap.set operations are strictly increasing.
 * 1 <= timestamp <= 10^7
 * TimeMap.set and TimeMap.get functions will be called a total of 120000 times (combined) per test case
 */
class TimeBasedKeyValueStoreSpec extends Specification {

	@Unroll
	def "timeMap"() {

		given:

			def tm = new TM()

		expect:

			[methods, args, results].transpose().each {
				method, arg, result ->
					println("$method with ($arg) expect $result")
					assert tm."$method"(arg) == result
			}

		where:

			methods                                                                                                                                      | args                                                                                                                                                                                                                                                                                                                                                                                                                                                          || results
			["set", "get", "get", "set", "get", "get"]                                                                                                   | [["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]                                                                                                                                                                                                                                                                                                                                                                       || [null, "bar", "bar", null, "bar2", "bar2"]
			["set", "set", "get", "get", "get", "get", "get"]                                                                                            | [["love", "high", 10], ["love", "low", 20], ["love", 5], ["love", 10], ["love", 15], ["love", 20], ["love", 25]]                                                                                                                                                                                                                                                                                                                                              || [null, null, "", "high", "high", "low", "low"]
			["set", "set", "set", "set", "get"]                                                                                                          | [["ctondw", "ztpearaw", 1], ["vrobykydll", "hwliiq", 2], ["gszaw", "ztpearaw", 3], ["ctondw", "gszaw", 4], ["gszaw", 5]]                                                                                                                                                                                                                                                                                                                                      || [null, null, null, null, "ztpearaw"]
			["set", "set", "set", "set", "get", "get", "get", "get", "get", "get", "set", "get", "get", "get", "set", "set", "set", "set", "get", "get"] | [["ctondw", "ztpearaw", 1], ["vrobykydll", "hwliiq", 2], ["gszaw", "ztpearaw", 3], ["ctondw", "gszaw", 4], ["gszaw", 5], ["ctondw", 6], ["ctondw", 7], ["gszaw", 8], ["vrobykydll", 9], ["ctondw", 10], ["vrobykydll", "kcvcjzzwx", 11], ["vrobykydll", 12], ["ctondw", 13], ["vrobykydll", 14], ["ztpearaw", "zondoubtib", 15], ["kcvcjzzwx", "hwliiq", 16], ["wtgbfvg", "vrobykydll", 17], ["hwliiq", "gzsiivks", 18], ["kcvcjzzwx", 19], ["ztpearaw", 20]] || [null, null, null, null, "ztpearaw", "gszaw", "gszaw", "ztpearaw", "hwliiq", "gszaw", null, "kcvcjzzwx", "gszaw", "kcvcjzzwx", null, null, null, null, "hwliiq", "zondoubtib"]

	}

}
