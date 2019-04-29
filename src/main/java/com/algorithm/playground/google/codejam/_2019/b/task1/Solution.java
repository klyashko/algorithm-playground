package com.algorithm.playground.google.codejam._2019.b.task1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

@SuppressWarnings("Duplicates")
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				//rows
				int p = console.nextInt();
				//grid
				int q = console.nextInt();
				TreeMap<Integer, Integer> vertical = new TreeMap<>();
				TreeMap<Integer, Integer> horizontal = new TreeMap<>();
				int south = 0;
				int west = 0;
				for (int i = 0; i < p; i++) {
					int x = console.nextInt();
					int y = console.nextInt();
					String d = console.next();
					switch (d) {
						case "S":
							if (y != 0) {
								vertical.put(y - 1, vertical.getOrDefault(y - 1, 0) - 1);
								south++;
							}
							break;
						case "N":
							if (y != q) {
								vertical.put(y, vertical.getOrDefault(y, 0) + 1);
							}
							break;
						case "E":
							if (x != q) {
								horizontal.put(x, horizontal.getOrDefault(x, 0) + 1);
							}
							break;
						case "W":
							if (x != 0) {
								horizontal.put(x - 1, horizontal.getOrDefault(x - 1, 0) - 1);
								west++;
							}
							break;
					}
				}
				int y = 0;
				int max = south;
				int curr = south;
				for (Map.Entry<Integer, Integer> entry : vertical.entrySet()) {
					curr += entry.getValue();
					if (curr > max) {
						max = curr;
						y = entry.getKey() + 1;
					}
				}

				int x = 0;
				max = west;
				curr = west;
				for (Map.Entry<Integer, Integer> entry : horizontal.entrySet()) {
					curr += entry.getValue();
					if (curr > max) {
						max = curr;
						x = entry.getKey() + 1;
					}
				}

				System.out.println(String.format("Case #%s: %s %s", test, x, y));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

}
