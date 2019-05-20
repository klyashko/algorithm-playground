package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.getNextStringWithLettersOnly
import static com.algorithm.playground.data.structure.HuffmanTree.deserializeTree

class HuffmanTreeSpec extends Specification {

	@Repeat(10)
	def "huffmanTree_encode_decode"() {

		given:

			def str = nextStringWithLettersOnly
			def tree = new HuffmanTree(str)

		expect:

			str == tree.decode(tree.encode(str))

	}

	@Repeat(10)
	def "huffmanTree_serialize_deserialize"() {

		given:

			def str = nextStringWithLettersOnly
			def tree = new HuffmanTree(str)
			def encoded = tree.encode(str)

		expect:

			encoded == tree.deserialize(tree.serialize(encoded))

	}

	@Repeat(10)
	def "huffmanTree_serialize_deserialize_tree"() {

		given:

			def str = nextStringWithLettersOnly
			def tree = new HuffmanTree(str)
			def encoded = tree.encode(str)
			tree = deserializeTree(tree.serializeTree())

		expect:

			str == tree.decode(encoded)

	}

}