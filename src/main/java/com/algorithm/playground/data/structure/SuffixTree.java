package com.algorithm.playground.data.structure;

import java.util.*;

import static java.lang.System.arraycopy;

public class SuffixTree {

	private static final char END = '$';
	private SuffixNode root;
	private char[] values;

	public SuffixTree(String input) {
		this.values = new char[input.length() + 1];
		arraycopy(input.toCharArray(), 0, this.values, 0, input.length());
		this.values[input.length()] = END;
		this.root = new SuffixTreeBuilder(this.values).build();
	}

	public boolean contains(String p) {
		SuffixNode curr = root;
		for (int i = 0; i < p.length() && curr != null; i++) {
			for (int j = curr.start + 1; j <= curr.end.end && i < p.length(); i++, j++) {
				if (values[j] != p.charAt(i)) {
					return false;
				}
			}
			if (i < p.length()) {
				curr = curr.getChild(p.charAt(i));
			}
		}
		return curr != null;
	}

	private String[] dfs(SuffixNode node, StringBuilder builder, String[] list) {
		int len = builder.length();
		for (int i = node.start; i <= node.end.end; i++) {
			builder.append(values[i]);
		}
		if (node.index != -1) {
			list[node.index] = builder.toString();
		} else {
			for (SuffixNode next : node.children.values()) {
				dfs(next, builder, list);
			}
		}
		builder.setLength(len);
		return list;
	}

	private String paddingRight(String s, int len) {
		StringBuilder builder = new StringBuilder(s);
		for (int i = s.length(); i < len; i++) {
			builder.append(' ');
		}
		return builder.toString();
	}

	@Override
	public String toString() {
		String[] values = dfs(root, new StringBuilder(), new String[this.values.length]);
		List<String> result = new ArrayList<>();
		for (int i = 0; i < values.length; i++) {
			result.add(paddingRight('\'' + values[i] + '\'', values[0].length() + 2) + " : " + i);
		}
		return "SuffixTree{\n\t\t" +
				String.join("\n\t\t", result) +
				"\n}";
	}

	private class SuffixNode {

		private Map<Character, SuffixNode> children;
		private int start, index;
		private End end;
		private SuffixNode link;

		private SuffixNode(int start, End end) {
			this.children = new HashMap<>();
			this.start = start;
			this.end = end;
		}

		private SuffixNode getChild(Character ch) {
			return children.get(ch);
		}

		private void addChild(Character ch, SuffixNode node) {
			children.put(ch, node);
		}

		private boolean hasChild(Character ch) {
			return children.containsKey(ch);
		}

		private int length() {
			return end.end - start;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			SuffixNode node = (SuffixNode) o;
			return start == node.start &&
					index == node.index &&
					Objects.equals(children, node.children) &&
					Objects.equals(end, node.end) &&
					Objects.equals(link, node.link);
		}

		@Override
		public int hashCode() {
			return Objects.hash(children, start, index, end, link);
		}

		@Override
		public String toString() {
			return "SuffixNode{" +
					"index=" + index +
					", start=" + start +
					", end=" + end +
					", children=" + children +
					'}';
		}
	}

	private class End {
		private int end;

		private End(int end) {
			this.end = end;
		}

		private void increment() {
			end++;
		}

		@Override
		public String toString() {
			return "End{" +
					"end=" + end +
					'}';
		}
	}

	private class SuffixTreeBuilder {

		private char[] input;
		private Active active;
		private End end;
		private SuffixNode root;
		private int remaining;

		private SuffixTreeBuilder(char[] input) {
			this.input = input;
		}

		private SuffixNode build() {
			this.root = new SuffixNode(1, new End(0));
			this.root.index = -1;
			this.active = new Active(root);
			this.end = new End(-1);
			for (int i = 0; i < input.length; i++) {
				phase(i);
			}
			setIndexes(root, 0, input.length);
			return root;
		}

		private void phase(int i) {
			//Keep track of nodes created during this iteration
			SuffixNode lastCreated = null;
			end.increment();
			remaining++;
			while (remaining > 0) {
				if (active.length == 0) {
					SuffixNode child = active.getChild(i);
					//If child is not null it's the 3th extension rule and 2 trick
					if (child != null) {
						active.edge = child.start;
						active.length++;
						break;
					} else {
						//If the 2th extension rule
						root.addChild(input[i], new SuffixNode(i, end));
						remaining--;
					}
				} else {
					Character curr = next(i);
					if (curr != null) {
						if (curr == input[i]) {
							//TODO - Could be wrong here. Do we only do this if when walk down goes past a node or we do it every time.
							updateLink(lastCreated, active.getChild());
							walkDown(i);
							break;
						} else {
							SuffixNode node = active.getChild();
							SuffixNode newInternalNode = new SuffixNode(node.start, new End(node.start + active.length - 1));
							node.start = node.start + active.length;
							SuffixNode newLeafNode = new SuffixNode(i, end);

							newInternalNode.addChild(input[newInternalNode.start + active.length], node);
							newInternalNode.addChild(input[i], newLeafNode);
							newInternalNode.index = -1;

							active.node.addChild(input[newInternalNode.start], newInternalNode);
							updateLink(lastCreated, newInternalNode);

							lastCreated = newInternalNode;
							newInternalNode.link = root;
						}
					} else {
						SuffixNode node = active.getChild();
						node.addChild(input[i], new SuffixNode(i, end));
						updateLink(lastCreated, node);
						lastCreated = node;
					}
					if (active.node.equals(root)) {
						active.edge++;
						active.length--;
					} else {
						active.node = active.node.link;
					}
					remaining--;
				}
			}
		}

		private void updateLink(SuffixNode node, SuffixNode link) {
			if (node != null) {
				node.link = link;
			}
		}

		private void walkDown(int i) {
			SuffixNode node = active.getChild();
			int len = node.length();
			if (len < active.length) {
				active.node = node;
				active.length = active.length - len;
				active.edge = node.getChild(input[i]).start;
			} else {
				active.length++;
			}
		}

		private Character next(int i) {
			SuffixNode node = active.getChild();
			int len = node.length();
			if (len >= active.length) {
				char child = input[active.edge];
				int idx = active.getChild(child).start + active.length;
				return input[idx];
			} else if (len + 1 == active.length) {
				if (node.hasChild(input[i])) {
					return input[i];
				}
			} else {
				active.node = node;
				active.length = active.length - len - 1;
				active.edge = active.edge + len + 1;
				return next(i);
			}
			return null;
		}

		private void setIndexes(SuffixNode node, int val, int size) {
			if (node != null) {
				val += node.length() + 1;
				if (node.index != -1) {
					node.index = size - val;
					return;
				}
				for (SuffixNode next : node.children.values()) {
					setIndexes(next, val, size);
				}
			}
		}

		private class Active {

			private SuffixNode node;
			private int edge, length;

			private Active(SuffixNode node) {
				this.node = node;
				this.edge = -1;
			}

			private SuffixNode getChild() {
				return node.getChild(input[edge]);
			}

			private SuffixNode getChild(int i) {
				return node.getChild(input[i]);
			}

			private SuffixNode getChild(char ch) {
				return node.getChild(ch);
			}

			@Override
			public String toString() {
				return "Active{" +
						"node=" + node +
						", edge=" + edge +
						", length=" + length +
						'}';
			}
		}

	}

}
