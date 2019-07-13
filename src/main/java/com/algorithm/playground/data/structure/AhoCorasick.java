package com.algorithm.playground.data.structure;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.ToIntFunction;

import static java.util.Comparator.comparingInt;

public class AhoCorasick {

	private AhoCorasickNode root;

	public AhoCorasick(Iterable<String> dictionary) {
		this.root = new AhoCorasickNode();
		build(dictionary);
	}

	private static int numerate(AhoCorasickNode node, Map<AhoCorasickNode, Integer> ids, int curr) {
		ids.put(node, curr++);
		for (AhoCorasickNode next : node.children.values()) {
			curr = numerate(next, ids, curr);
		}
		return curr;
	}

	private static String toString(AhoCorasickNode node, char ch, int level, Set<Integer> last, Map<AhoCorasickNode, Integer> ids) {
		StringBuilder curr = new StringBuilder("\t\t");
		if (level == 1) {
			curr.append(" ");
		} else {
			int l = level + 3 * level;
			for (int i = 0; i < l; i++) {
				int charLevel = i == 1 ? 1 : i / 4;
				if (!last.contains(charLevel) && (i == 1 || (i > 6 && i % 4 == 0 && l - i > 3))) {
					curr.append("|");
				} else {
					curr.append(" ");
				}
			}
		}
		String tmp = curr.toString();
		curr.append("|\n")
				.append(tmp)
				.append("|---> ")
				.append(ch)
				.append(": {")
				.append(ids.get(node))
				.append("} Node{words=")
				.append(node.words)
				.append(", fail=")
				.append(ids.get(node.fail))
				.append("}\n");

		if (node.children.isEmpty()) {
			return curr.toString();
		}

		int size = node.children.size();
		for (Entry<Character, AhoCorasickNode> e : node.children.entrySet()) {
			if (--size == 0) {
				last.add(level + 1);
			}
			curr.append(toString(e.getValue(), e.getKey(), level + 1, last, ids));
		}
		last.remove(level + 1);
		return curr.toString();
	}

	public List<Tuple2<String, Integer>> findAll(String text) {
		List<Tuple2<String, Integer>> result = new ArrayList<>();

		AhoCorasickNode curr = root;
		for (int i = 0; i < text.length(); i++) {
			curr = curr.next(text.charAt(i));

			for (String s : curr.words) {
				result.add(new Tuple2<>(s, i - s.length() + 1));
			}
		}

		Comparator<Tuple2<String, Integer>> comparator = comparingInt((ToIntFunction<Tuple2<String, Integer>>) Tuple2::_2)
				.thenComparingInt(t -> t._1().length());
		result.sort(comparator);

		return result;
	}

	private void build(Iterable<String> dictionary) {
		for (String word : dictionary) {
			insert(word);
		}
		createLinks();
	}

	private void createLinks() {
		root.fail = root;
		Queue<AhoCorasickNode> queue = new ArrayDeque<>();

		for (AhoCorasickNode next : root.children.values()) {
			next.fail = root;
			queue.offer(next);
		}

		while (!queue.isEmpty()) {
			AhoCorasickNode curr = queue.poll();

			for (Entry<Character, AhoCorasickNode> e : curr.children.entrySet()) {
				queue.offer(e.getValue());

				AhoCorasickNode failure = curr.fail;
				while (failure != root && failure.doesntHaveChild(e.getKey())) {
					failure = failure.fail;
				}

				AhoCorasickNode newFailure = failure.getOrDefault(e.getKey(), root);
				e.getValue().fail = newFailure;
				e.getValue().words.addAll(newFailure.words);
			}
		}
	}

	private void insert(String word) {
		AhoCorasickNode curr = root;
		for (char ch : word.toCharArray()) {
			curr = curr.getOrCreate(ch);
		}
		curr.words.add(word);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("\t\t___\n");
		Map<AhoCorasickNode, Integer> ids = new HashMap<>();
		numerate(root, ids, 0);
		int size = root.children.size();
		Set<Integer> last = new HashSet<>();
		for (Entry<Character, AhoCorasickNode> e : root.children.entrySet()) {
			if (--size == 0) {
				last.add(1);
			}
			builder.append(toString(e.getValue(), e.getKey(), 1, last, ids));
		}
		return "AhoCorasick{\n" + builder.toString() + "}";
	}

	private class AhoCorasickNode {

		private Map<Character, AhoCorasickNode> children = new HashMap<>();
		private Set<String> words = new HashSet<>();
		private AhoCorasickNode fail;

		private AhoCorasickNode getOrCreate(Character ch) {
			return children.computeIfAbsent(ch, key -> new AhoCorasickNode());
		}

		private AhoCorasickNode getOrDefault(Character ch, AhoCorasickNode node) {
			return children.getOrDefault(ch, node);
		}

		private boolean doesntHaveChild(Character ch) {
			return !children.containsKey(ch);
		}

		private AhoCorasickNode next(char ch) {
			AhoCorasickNode node = this;

			while (node.doesntHaveChild(ch) && node != root) {
				node = node.fail;
			}
			return node.getOrDefault(ch, root);
		}

		@Override
		public String toString() {
			String fail = this.fail != null ? this.fail.words.toString() : "null";
			return "AhoCorasickNode{" +
					"words=" + words +
					", fail=" + fail +
					'}';
		}
	}

}
