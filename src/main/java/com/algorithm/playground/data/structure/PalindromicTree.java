package com.algorithm.playground.data.structure;

import java.util.*;

public class PalindromicTree {

	private final PalindromicNode[] tree;
	private final char[] value;
	private final int max;

	public PalindromicTree(String s) {
		this(s.toCharArray());
	}

	public PalindromicTree(char[] chars) {
		this.value = chars;
		Tuple2<PalindromicNode[], Integer> tuple = new PalindromicTreeBuilder().build();
		this.tree = tuple._1();
		this.max = tuple._2();
	}

	public String getMaxPalindrome() {
		if (tree[max].getLength() < 0) {
			return "";
		}
		return new String(value, tree[max].start, tree[max].getLength());
	}

	public List<String> getAllPalindrome() {
		List<String> list = new ArrayList<>();
		for (int i = 2; i < tree.length; i++) {
			list.add(new String(value, tree[i].start, tree[i].getLength()));
		}
		return list;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		int len = countDigits(tree.length);
		for (int i = 0; i < tree.length; i++) {
			builder.append("\t\t")
					.append(padding(i, len))
					.append(" : ")
					.append(tree[i])
					.append('\n');
		}
		return "PalindromicTree{\n" +
				"\tvalue = '" + new String(value) +
				"'\n\ttree : \n" + builder +
				'}';
	}

	private String padding(int i, int len) {
		len = len - countDigits(i);
		StringBuilder builder = new StringBuilder();
		for (int j = 0; j < len; j++) {
			builder.append(' ');
		}
		return builder.append(i).toString();
	}

	private int countDigits(int i) {
		int count = i == 0 ? 1 : 0;
		//noinspection StatementWithEmptyBody
		for (; i > 0; count++, i /= 10) ;
		return count;
	}

	private class PalindromicTreeBuilder {

		private final PalindromicNode[] tree;
		private int current;
		private int pointer;
		private int max;

		private PalindromicTreeBuilder() {
			this.tree = new PalindromicNode[value.length + 2];
			this.pointer = 2;
		}

		private Tuple2<PalindromicNode[], Integer> build() {
			tree[0] = new PalindromicNode(0, -2, 0);
			tree[1] = new PalindromicNode(0, -1, 0);
			for (int i = 0; i < value.length; i++) {
				int palindrome = getPalindrome(current, i);
				createIfNotExist(palindrome, i);
			}
			return new Tuple2<>(Arrays.copyOf(tree, pointer), max);
		}

		private void createIfNotExist(int node, int idx) {
			char ch = value[idx];
			Integer child = tree[node].edges.putIfAbsent(ch, pointer);
			if (child == null) {
				tree[pointer] = new PalindromicNode(idx - tree[node].getLength() - 1, idx);
				if (tree[pointer].getLength() == 1) {
					tree[pointer].maxPalindromicEdge = 1;
				} else {
					int edge = tree[node].maxPalindromicEdge;
					int palindrome = getPalindrome(edge, idx);
					tree[pointer].maxPalindromicEdge = tree[palindrome].edges.get(ch);
				}
				current = pointer++;
			} else {
				current = child;
			}

			if (tree[current].getLength() > tree[max].getLength()) {
				max = current;
			}
		}

		private int getPalindrome(int node, int idx) {
			while (true) {
				int curr = tree[node].getLength();
				if (idx - curr > 0 && value[idx] == value[idx - curr - 1]) {
					return node;
				}
				node = tree[node].maxPalindromicEdge;
			}
		}
	}

	private class PalindromicNode {

		private int start, end;
		private Map<Character, Integer> edges = new HashMap<>();
		private int maxPalindromicEdge;

		private PalindromicNode(int start, int end, int maxPalindromicEdge) {
			this(start, end);
			this.maxPalindromicEdge = maxPalindromicEdge;
		}

		private PalindromicNode(int start, int end) {
			this.start = start;
			this.end = end;
		}

		private int getLength() {
			return end - start + 1;
		}

		@Override
		public String toString() {
			return "PalindromicNode{" +
					"start=" + start +
					", end=" + end +
					", maxPalindromicEdge=" + maxPalindromicEdge +
					", edges=" + edges +
					'}';
		}
	}
}
