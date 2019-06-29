package com.algorithm.playground.data.structure

import com.algorithm.playground.Repeat
import spock.lang.Specification

import static com.algorithm.playground.TestUtils.*
import static com.algorithm.playground.utils.CollectionUtils.combinations

class HeavyLightDecompositionSpec extends Specification {

	@Repeat(10)
	def "max edge"() {

		given:

			def tree = nextTree(nextInt(5, 25))
			def values = nextList(tree.size(), { nextSmallInt })

			def parents = [-1] * tree.size()
			def depth = [0] * tree.size()
			calculateParents(tree, 0, parents, depth)

		when:

			def hld = new HeavyLightDecomposition(tree, values as int[])

		then:

			combinations(0..tree.size() - 1).each {
				assert max(it._1(), it._2(), parents, depth, values) == hld.max(it._1(), it._2())
			}

	}

	@Repeat(10)
	def "max edge with update"() {

		given:

			def tree = nextTree(nextInt(5, 25))
			def values = nextList(tree.size(), { nextSmallInt })

			def parents = [-1] * tree.size()
			def depth = [0] * tree.size()

			calculateParents(tree, 0, parents, depth)

			def updates = (1..nextInt(tree.size())).collect { [nextInt(tree.size()), nextSmallInt] }
			def valuesCopy = values.collect()
			def expected = (0..nextInt(tree.size() << 2)).collect {
				def interval = nextQueryInterval(tree.size())
				def val = max(interval[0], interval[1], parents, depth, valuesCopy)
				if (it < updates.size()) {
					IntITuple2 update = updates[it]
					valuesCopy[update._1()] = update._2()
				}
				return new Tuple2<>(interval, val)
			}

		when:

			def hld = new HeavyLightDecomposition(tree, values as int[])

		then:

			expected.eachWithIndex { Tuple2<int[], Integer> entry, int idx ->
				assert entry._2() == hld.max(entry._1()[0], entry._1()[1])
				if (idx < updates.size()) {
					IntITuple2 update = updates[idx]
					hld.update(update._1(), update._2())
				}
			}

	}

	private static int max(int a, int b, List<Integer> parents, List<Integer> depth, List<Integer> values) {
		int max = Math.max(values[a], values[b])
		while (a != b) {
			if (depth[a] < depth[b]) {
				int t = b
				b = a
				a = t
			}
			a = parents[a]
			max = Math.max(max, values[a])
		}
		return max
	}

	private static void calculateParents(List<List<Integer>> tree, int node, List<Integer> parents, List<Integer> depth) {
		tree[node].findAll { it != parents[node] }
				.each {
					parents[it] = node
					depth[it] = depth[node] + 1
					calculateParents(tree, it, parents, depth)
				}
	}


	private static List<List<Integer>> nextTree(int size) {
		int[] parents = new int[size]
		size.times {
			int j = nextInt(it + 1)
			parents[it] = parents[j]
			parents[j] = it
		}

		List<List<Integer>> tree = (1..size).collect { [] }
		for (int i = 1; i < size; i++) {
			int parent = parents[nextInt(i)]
			tree[parent] << parents[i]
			tree[parents[i]] << parent
		}
		return tree
	}

}