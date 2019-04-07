package com.algorithm.playground.google.codejam._2019.qualification.datbae;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				//nodes
				int N = console.nextInt();
				//broken
				int B = console.nextInt();
				//tries
				int F = console.nextInt();

				String[] requests = new String[F];
				String[] responses = new String[F];

				for (int i = 0; i < F; i++) {
					StringBuilder message = new StringBuilder(N);
					for (int j = 0; j < N; j++) {
						if ((j & (1 << i)) != 0) {
							message.append('0');
						} else {
							message.append('1');
						}
					}
					requests[i] = message.toString();
					System.out.println(requests[i]);
					responses[i] = readResponse(console);
				}

				int[] nodes = new int[B];
				int idx = 0;
				int cursor = 0;
				for (int i = 0; i < N; i++) {
					boolean broken = cursor >= responses[0].length();
					for (int j = 0; j < F && !broken; j++) {
						if (requests[j].charAt(i) != responses[j].charAt(cursor)) {
							broken = true;
						}
					}
					if (broken) {
						nodes[idx++] = i;
					} else {
						cursor++;
					}
				}

				System.out.println(join(nodes));
				if (console.nextInt() == -1) {
					throw new RuntimeException("WA");
				}

			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static String join(int[] nodes) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < nodes.length - 1; i++) {
			builder.append(i).append(" ");
		}
		return builder.append(nodes[nodes.length - 1]).toString();
	}

	private static String readResponse(Scanner console) {
		String response = "";
		while (response.isEmpty()) {
			response = console.nextLine().trim();
		}
		if (response.equals("-1")) {
			throw new RuntimeException("Wrong request");
		}
		return response;
	}

}
