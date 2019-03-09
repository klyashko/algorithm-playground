package com.algorithm.playground.data.structure

import spock.lang.Specification

class BinaryIndexedSumTreeSpec extends Specification {

	private static final Random rnd = new Random()

	def "binaryIndexedSumTree"() {

		given:

			def nums = (0..25).collect { rnd.nextInt(10) }
			println("Numbers: ${nums}")
			def sums = sum(nums)
			println("Sums: ${sums}")
			def tree = new BinaryIndexedSumTree(nums as int[])

		when:

			def result = produce(tree, sums)
			println("Result: ${result}")

		then:

			result
			result.each { assert it[0] == it[1] }

		when:

			println("\nUpdate of tree: \n")
			nums = nums.collect { rnd.nextBoolean() ? it : rnd.nextInt(10) }
			println("Numbers: ${nums}")
			nums.size().times { tree.update(it, nums[it]) }
			sums = sum(nums)
			println("Sums: ${sums}")

			result = produce(tree, sums)
			println("Result: ${result}")

		then:

			result
			result.each { assert it[0] == it[1] }

	}

	private static List<List<Integer>> produce(BinaryIndexedSumTree tree, int[] sums) {
		def len = sums.size() - 1
		return (0..10).collect {
			def from = rnd.nextInt(len - 1)
			def to = rnd.nextInt(len - from) + from
			def expected = sums[to] - (from == 0 ? 0 : sums[from - 1])
			return [expected, tree.sum(from, to)]
		}
	}

	private static int[] sum(List<Integer> nums) {
		def sums = []
		def sum = 0
		nums.size().times {
			sum += nums[it]
			sums[it] = sum
		}
		return sums
	}

}
