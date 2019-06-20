package com.algorithm.playground.barclays.task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		TreeMap<Long, Integer> a = new TreeMap<>();
		TreeMap<Long, Integer> b = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			String name = scanner.next();
			long size = scanner.nextInt();
			if ("A".equals(name)) {
				a.put(size, a.getOrDefault(size, 0) + 1);
			} else {
				b.put(size, b.getOrDefault(size, 0) + 1);
			}
		}

		long result = solve(a, b);

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		scanner.close();
		bufferedWriter.close();
	}

	private static long solve(TreeMap<Long, Integer> a, TreeMap<Long, Integer> b) {
		while (!a.isEmpty() && !b.isEmpty()) {
			long aa = getFirst(a);
			long bb = getFirst(b);
			if (aa != bb) {
				long size = aa + bb;
				if (aa > bb) {
					a.put(size, a.getOrDefault(size, 0) + 1);
				} else {
					b.put(size, b.getOrDefault(size, 0) + 1);
				}
			}
		}
		if (a.isEmpty() && b.isEmpty()) {
			return 0;
		} else if (a.isEmpty()) {
			return b.lastKey();
		} else {
			return a.lastKey();
		}
	}

	private static long getFirst(TreeMap<Long, Integer> map) {
		Map.Entry<Long, Integer> e = map.firstEntry();
		if (e.getValue() > 1) {
			map.put(e.getKey(), e.getValue() - 1);
		} else {
			map.remove(e.getKey());
		}
		return e.getKey();
	}

}
