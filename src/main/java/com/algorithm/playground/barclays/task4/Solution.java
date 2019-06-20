package com.algorithm.playground.barclays.task4;

import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));

		int n = scanner.nextInt();
		List<Command> commands = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Command c = new Command(
					scanner.next().charAt(0),
					scanner.nextInt(),
					scanner.nextInt()
			);
			commands.add(c);
		}
		process(commands);
		scanner.close();
	}

	private static void process(List<Command> list) {
		List<Integer> data = new ArrayList<>();
		data.add(0);
		TreeMap<Integer, Integer> index = new TreeMap<>();

		for (Command c : list) {
			if (c.c == 'I') {
				data.add(c.i2);
				index.put(c.i2, index.getOrDefault(c.i2, 0) + 1);
			} else if (c.c == 'U') {
				Integer old = data.get(c.i1);
				Integer count = index.get(old);
				if (count > 1) {
					index.put(old, count - 1);
				} else {
					index.remove(old);
				}
				data.set(c.i1, c.i2);
				index.put(c.i2, index.getOrDefault(c.i2, 0) + 1);
			} else if (c.c == 'S') {
				if (c.i2 < c.i1) {
					System.out.println(0);
					continue;
				}
				long sum = 0;
				for (Map.Entry<Integer, Integer> e : index.subMap(c.i1, true, c.i2, true).entrySet()) {
					sum += ((long) e.getKey() * (long) e.getValue());
				}
				System.out.println(sum);
			} else if (c.c == 'C') {
				if (c.i2 < c.i1) {
					System.out.println(0);
					continue;
				}
				int count = 0;
				for (Map.Entry<Integer, Integer> e : index.subMap(c.i1, true, c.i2, true).entrySet()) {
					count += e.getValue();
				}
				System.out.println(count);
			}
		}
	}

	private static class Command {

		private char c;
		private int i1, i2;

		private Command(char c, int i1, int i2) {
			this.c = c;
			this.i1 = i1;
			this.i2 = i2;
		}

		@Override
		public String toString() {
			return "Command{" +
					"c=" + c +
					", i1=" + i1 +
					", i2=" + i2 +
					'}';
		}
	}

}
