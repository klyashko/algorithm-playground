package com.algorithm.playground.data.structure;

import java.util.*;
import java.util.Map.Entry;

import static java.util.Collections.emptyList;
import static java.util.Comparator.comparingInt;

public class SuffixAutomation {

	private String string;
	private State[] states;

	public SuffixAutomation(String string) {
		this.string = string;
		this.states = build(string);
	}

	private static State[] build(String input) {
		State[] states = new State[input.length() + 1 << 1];
		states[0] = new State(-1, -1, true);
		int last = 0, size = 1;
		for (char ch : input.toCharArray()) {
			int curr = size++;
			states[curr] = new State(states[last].len + 1, states[last].len);
			int parent = last;
			for (; parent != -1 && !states[parent].next.containsKey(ch); parent = states[parent].link) {
				states[parent].next.put(ch, curr);
			}
			if (parent == -1) {
				states[curr].link = 0;
			} else {
				int next = states[parent].next.get(ch);
				if (states[parent].len + 1 == states[next].len) {
					states[curr].link = next;
				} else {
					int clone = size++;
					states[clone] = new State(states[next], states[parent].len + 1);
					for (; parent != -1 && states[parent].next.getOrDefault(ch, -1) == next; parent = states[parent].link) {
						states[parent].next.put(ch, clone);
					}
					states[next].link = clone;
					states[curr].link = clone;
				}
			}
			last = curr;
		}
		for (int i = 1; i < size; i++) {
			states[states[i].link].links.add(i);
		}
		return Arrays.copyOf(states, size);
	}

	public int firstIndexOf(String s) {
		int state = findState(s);
		if (state == -1) {
			return -1;
		}
		return states[state].end - s.length() + 1;
	}

	public List<Integer> allIndexesOf(String s) {
		int state = findState(s);
		if (state == -1) {
			return emptyList();
		}
		return allIndexesOf(state, s.length(), new ArrayList<>());
	}

	public int count(String s) {
		int state = findState(s);
		if (state == -1) {
			return 0;
		}
		int[] counts = new int[states.length];
		Queue<int[]> queue = new PriorityQueue<>(comparingInt((int[] a) -> a[1]).reversed());
		for (int i = 0; i < states.length; i++) {
			queue.offer(new int[]{i, states[i].len});
			if (!states[i].clone) {
				counts[i] = 1;
			}
		}
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (states[curr[0]].link != -1) {
				counts[states[curr[0]].link] += counts[curr[0]];
			}
		}
		return counts[state];
	}

	public String substring(int k) {
		int[] paths = countDistinctPaths();
		if (k >= paths[0]) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		TreeMap<Character, Integer> curr = new TreeMap<>(states[0].next);
		for (; !curr.isEmpty() && k >= 0; k--) {
			for (Entry<Character, Integer> entry : curr.entrySet()) {
				if (paths[entry.getValue()] <= k) {
					k -= paths[entry.getValue()];
				} else {
					builder.append(entry.getKey());
					curr = new TreeMap<>(states[entry.getValue()].next);
					break;
				}
			}
		}
		return builder.toString();
	}

	public String minCyclicShift(int len) {
		StringBuilder builder = new StringBuilder();
		TreeMap<Character, Integer> curr = new TreeMap<>(states[0].next);
		for (int i = 0; i < len; i++) {
			if (curr.isEmpty()) {
				return "";
			}
			Entry<Character, Integer> min = curr.firstEntry();
			builder.append(min.getKey());
			curr = new TreeMap<>(states[min.getValue()].next);
		}
		return builder.toString();
	}

	public int countDistinct() {
		return countDistinctPaths()[0];
	}

	public int countDistinctSizes() {
		int[] counts = new int[states.length];
		int[] dp = new int[states.length];
		for (int i = dp.length - 1; i >= 0; i--) {
			dp[i] = countDistinctSizes(i, counts, dp);
		}
		return dp[0];
	}

	public boolean contains(String string) {
		int state = 0;
		for (char ch : string.toCharArray()) {
			if (!states[state].next.containsKey(ch)) {
				return false;
			}
			state = states[state].next.get(ch);
		}
		return true;
	}

	public String lcs(String string) {
		int len = 0, maxLen = 0, idx = -1;
		for (int i = 0, curr = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			if (!states[curr].next.containsKey(ch)) {
				for (; curr != -1 && !states[curr].next.containsKey(ch); ) {
					curr = states[curr].link;
				}
				if (curr == -1) {
					curr = 0;
					len = 0;
					continue;
				}
				len = states[curr].len;
			}
			len++;
			curr = states[curr].next.getOrDefault(ch, -1);
			if (len > maxLen) {
				maxLen = len;
				idx = i - maxLen + 1;
			}
		}
		return idx == -1 ? "" : string.substring(idx, idx + maxLen);
	}

	private int findState(String s) {
		int state = 0;
		for (char ch : s.toCharArray()) {
			state = states[state].next.getOrDefault(ch, -1);
			if (state == -1) {
				return -1;
			}
		}
		return state;
	}

	private List<Integer> allIndexesOf(int state, int len, List<Integer> result) {
		if (!states[state].clone) {
			result.add(states[state].end - len + 1);
		}
		for (Integer next : states[state].links) {
			allIndexesOf(next, len, result);
		}
		return result;
	}

	private int[] countDistinctPaths() {
		int[] dp = new int[states.length];
		for (int i = dp.length - 1; i >= 0; i--) {
			dp[i] = countDistinct(i, dp);
		}
		dp[0]--;
		return dp;
	}

	private int countDistinctSizes(int state, int[] counts, int[] cache) {
		if (cache[state] == 0) {
			for (Integer n : states[state].next.values()) {
				cache[state] += countDistinct(n, counts) + countDistinctSizes(n, counts, cache);
			}
		}
		return cache[state];
	}

	private int countDistinct(int state, int[] cache) {
		if (cache[state] == 0) {
			cache[state] = 1;
			for (Integer n : states[state].next.values()) {
				cache[state] += countDistinct(n, cache);
			}
		}
		return cache[state];
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\t\tlength: ").append(states.length).append('\n');
		for (int i = 0; i < states.length; i++) {
			builder.append("\t\t").append(i).append(" : ").append(states[i]).append("\n");
		}
		return "SuffixAutomation{\n" +
				"\tstring='" + string + '\'' +
				"\n\tstates:\n" + builder +
				'}';
	}

	private static class State {

		private int len, link, end;
		private boolean clone;
		private Map<Character, Integer> next = new HashMap<>();
		private List<Integer> links = new ArrayList<>();

		private State(State state, int len) {
			this.next.putAll(state.next);
			this.link = state.link;
			this.end = state.end;
			this.len = len;
			this.clone = true;
		}

		private State(int len, int end) {
			this.len = len;
			this.end = end;
		}

		private State(int link, int end, boolean clone) {
			this.link = link;
			this.end = end;
			this.clone = clone;
		}

		@Override
		public String toString() {
			return "State{" +
					"len=" + len +
					", link=" + link +
					", end=" + end +
					", clone=" + clone +
					", next=" + next +
					", links=" + links +
					'}';
		}
	}

}
