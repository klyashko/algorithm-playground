package com.algorithm.playground.barclays.task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new InputStreamReader(System.in));

		int n = scanner.nextInt();

		List<Integer> indixes = new ArrayList<>();
		int[] counts = new int[n];
		int[] vals = new int[n];
		for (int i = 0; i < n; i++) {
			indixes.add(i);
			vals[i] = scanner.nextInt();
			counts[i] = count(vals[i]);
		}

		indixes.sort((i1, i2) -> {
			if (counts[i1] != counts[i2]) {
				return counts[i1] - counts[i2];
			}
			return vals[i1] - vals[i2];
		});

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		StringBuilder builder = new StringBuilder();
		for (Integer i : indixes) {
			builder.append(vals[i]).append('\n');
		}
		bufferedWriter.write(builder.toString());
//		bufferedWriter.write(
//				result.stream()
//						.map(Object::toString)
//						.collect(joining("\n"))
//						+ "\n"
//		);

		scanner.close();
		bufferedWriter.close();
	}

	private static int count(int number) {
		int count = 0;
		for (int i = 2; i < number; i++) {
			while (number % i == 0) {
				count++;
				number = number / i;
			}
		}
		if (number > 2) {
			count++;
		}
		return count;
	}

}
