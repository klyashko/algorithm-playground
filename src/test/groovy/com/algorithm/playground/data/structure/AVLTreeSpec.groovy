package com.algorithm.playground.data.structure

import spock.lang.Specification
import spock.lang.Unroll

@SuppressWarnings("GroovyAccessibility")
class AVLTreeSpec extends Specification {

	@Unroll("#name")
	def "avl tree"() {

		given:

			def tree = new AVLTree()

		when:

			data.each { tree.insert(it) }
			println(tree)

		then:

			checkDepth(tree.root) != -1
			tree.inOrder() == data.toSet().sort()

		where:

			name             || data
			"origin order"   || (1..16)
			"reversed order" || (16..1)
			"random order"   || randomList
			"empty list"     || []

	}

	def getRandomList() {
		def rnd = new Random()
		def list = []
		rnd.nextInt(50).times { list << rnd.nextInt(100) }
		return list
	}

	def checkDepth(AVLTree.Node root) {
		if (root == null) {
			return 0
		}
		int left = checkDepth(root.left)
		int right = checkDepth(root.right)
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1
		} else {
			return Math.max(left, right) + 1
		}
	}

}
