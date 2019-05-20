package com.algorithm.playground.data.structure;

import java.nio.ByteBuffer;
import java.util.PriorityQueue;
import java.util.Queue;

import static java.lang.System.arraycopy;
import static java.nio.ByteBuffer.allocate;

public class HuffmanTree {

	private String[] codes = new String[26];
	private Node root;

	public HuffmanTree(String template) {
		this(buildTree(template));
	}

	private HuffmanTree(Node root) {
		this.root = root;
		buildCodes(root, new StringBuilder());
	}

	public static HuffmanTree deserializeTree(String tree) {
		return new HuffmanTree(deserializeTree(new Cursor(tree)));
	}

	private static Node deserializeTree(Cursor tree) {
		if (tree.hasNext()) {
			char ch = tree.next();
			if (ch != 0) {
				return new Node(ch);
			} else {
				Node node = new Node();
				node.left = deserializeTree(tree);
				node.right = deserializeTree(tree);
				return node;
			}
		}
		return null;
	}

	private static Node buildTree(String template) {
		int[] frequencies = new int[26];
		for (char ch : template.toCharArray()) {
			frequencies[ch - 'a']++;
		}
		Queue<Node> queue = new PriorityQueue<>();
		for (int i = 0; i < frequencies.length; i++) {
			if (frequencies[i] > 0) {
				char ch = (char) (i + 'a');
				queue.offer(new Node(frequencies[i], ch));
			}
		}

		while (queue.size() > 1) {
			Node left = queue.poll();
			Node right = queue.poll();

			//noinspection ConstantConditions
			Node parent = new Node(left.score + right.score);
			parent.left = left;
			parent.right = right;

			queue.offer(parent);
		}

		return queue.poll();
	}

	public String encode(String s) {
		StringBuilder builder = new StringBuilder();
		for (char ch : s.toCharArray()) {
			builder.append(codes[ch - 'a']);
		}
		return builder.toString();
	}

	public String decode(String s) {
		StringBuilder builder = new StringBuilder();
		Cursor cursor = new Cursor(s);
		while (cursor.hasNext()) {
			builder.append(getNext(root, cursor));
		}
		return builder.toString();
	}

	public byte[] serialize(String encoded) {
		int len = encoded.length();
		long[] values = new long[len / 63 + (len % 63 == 0 ? 0 : 1)];
		long curr = 0;
		int idx = 0;
		for (int i = 0; i < len; i++) {
			if (i != 0 && i % 63 == 0) {
				values[idx++] = curr;
				curr = 0;
			}
			if (encoded.charAt(i) == '1') {
				curr |= getMask(i);
			}
		}
		values[idx] = curr;
		byte[] data = new byte[Integer.BYTES + values.length * Long.BYTES];
		ByteBuffer buffer = allocate(Long.BYTES);
		buffer.putInt(len);
		arraycopy(buffer.array(), 0, data, 0, Integer.BYTES);
		int offset = Integer.BYTES;
		for (long l : values) {
			buffer.clear();
			buffer.putLong(l);
			arraycopy(buffer.array(), 0, data, offset, Long.BYTES);
			offset += Long.BYTES;
		}

		return data;
	}

	public String deserialize(byte[] serialized) {
		ByteBuffer buffer = allocate(Long.BYTES);
		buffer.put(serialized, 0, Integer.BYTES);
		buffer.flip();
		int len = buffer.getInt();
		long[] values = new long[(serialized.length - Integer.BYTES) / Long.BYTES];
		for (int i = 0, offset = Integer.BYTES; i < values.length; i++, offset += Long.BYTES) {
			buffer.clear();
			buffer.put(serialized, offset, Long.BYTES);
			buffer.flip();
			values[i] = buffer.getLong();
		}

		long curr = 0;
		StringBuilder builder = new StringBuilder();
		for (int i = 0, idx = 0; i < len; i++) {
			if (i % 63 == 0) {
				curr = values[idx++];
			}
			long mask = getMask(i);
			if ((curr & mask) == mask) {
				builder.append("1");
			} else {
				builder.append("0");
			}
		}

		return builder.toString();
	}

	public String serializeTree() {
		return serializeTree(root, new StringBuilder()).toString();
	}

	private long getMask(int idx) {
		int pos = 62 - (idx % 63);
		return 1L << pos;
	}

	private char getNext(Node node, Cursor cursor) {
		while (node.left != null && node.right != null) {
			char curr = cursor.next();
			node = curr == '0' ? node.left : node.right;
		}
		return node.value;
	}

	private StringBuilder serializeTree(Node node, StringBuilder builder) {
		if (node != null) {
			builder.append(node.value);
			serializeTree(node.left, builder);
			serializeTree(node.right, builder);
		}
		return builder;
	}

	private void buildCodes(Node node, StringBuilder code) {
		if (node.left == null && node.right == null) {
			codes[node.value - 'a'] = code.toString();
		} else {
			int len = code.length();
			//noinspection ConstantConditions
			buildCodes(node.left, code.append('0'));
			code.setLength(len);
			buildCodes(node.right, code.append('1'));
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < codes.length; i++) {
			if (codes[i] != null) {
				char ch = (char) (i + 'a');
				builder.append('\t').append('\t').append(ch).append(" : ").append(codes[i]).append(",\n");
			}
		}
		builder.setLength(Math.max(0, builder.length() - 2));
		return "HuffmanTree{\n" + builder + "\n}";
	}

	private static class Node implements Comparable<Node> {

		private int score;
		private char value;
		private Node left, right;

		private Node() { }

		private Node(char value) {
			this.value = value;
		}

		private Node(int score) {
			this.score = score;
		}

		private Node(int score, char value) {
			this(score);
			this.value = value;
		}

		@Override
		public int compareTo(Node that) {
			return Integer.compare(this.score, that.score);
		}

		@Override
		public String toString() {
			return "Node{" +
					"score=" + score +
					", value=" + value +
					'}';
		}
	}

	private static class Cursor {

		private char[] chars;
		private int pos = 0;

		private Cursor(String string) {
			this.chars = string.toCharArray();
		}

		private boolean hasNext() {
			return pos < chars.length;
		}

		private char next() {
			return chars[pos++];
		}

	}

}
