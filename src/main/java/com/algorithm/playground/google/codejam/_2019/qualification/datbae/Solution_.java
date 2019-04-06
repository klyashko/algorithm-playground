package com.algorithm.playground.google.codejam._2019.qualification.datbae;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution_ {

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
				Node root = new Node(0, N, '0');
				root.missing = B;
				root.fork();

				for (int i = 0; i < F; i++) {
					char[] toSend = new char[N];
					root.fill(toSend);
					System.out.println(String.valueOf(toSend));
					String response = readResponse(console);
//					System.out.println(response);
					root.set(response.toCharArray(), new int[]{0});
					if (root.count() == B) {
						for (; i < F; i++) {
							for (int j = 0; j < N; j++) {
								System.out.print('0');
							}
							System.out.println();
							readResponse(console);
						}
						break;
					}
				}
				List<Integer> nodes = new ArrayList<>();
				root.getMissing(nodes);
				String ans = nodes.stream()
						.map(Object::toString)
						.collect(Collectors.joining(" "));
				System.out.println(ans);
				int result = console.nextInt();
				if (result == -1) {
					throw new RuntimeException("Didn't happened");
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static String readResponse(Scanner console) {
		String response = "";
		while (response.isEmpty()) {
			response = console.nextLine().trim();
		}
		return response;
	}

	private static class Node {

		private final int li, ri;
		private final int size;
		private final char val;
		private int missing;
		private Node left, right;
		private boolean closed = false;

		private Node(int li, int ri, char val) {
			this.li = li;
			this.ri = ri;
			this.val = val;
			this.size = ri - li;
		}

		private void fill(char[] values) {
			if (left != null && right != null) {
				left.fill(values);
				right.fill(values);
			} else {
				for (int i = li; i < ri; i++) {
					values[i] = val;
				}
			}
		}

		private void set(char[] values, int[] idx) {
			int left = this.left.set(values, idx, missing);
			this.right.set(values, idx, missing - left);
		}

		private int set(char[] values, int[] idx, int missing) {
			if (closed) {
				return this.missing;
			} else if (missing == this.missing && left == null && right == null) {
				if (missing == 0) {
					idx[0] += size;
				}
				return this.missing;
			} else if (this.val != '0' && this.size == missing) {
				this.missing = missing;
				return missing;
			} else if (left != null && right != null) {
				int left = this.left.set(values, idx, this.missing);
				return left + right.set(values, idx, this.missing - left);
			} else {
				int count = 0;
				for (int i = 0; i < size && idx[0] < values.length; i++) {
					if (values[idx[0]] == val) {
						count++;
						idx[0]++;
					} else {
						break;
					}
				}
				this.missing = size - count;
				if (this.missing == size) {
					closed = true;
				} else {
					fork();
				}
				return this.missing;
			}
		}

		private void fork() {
			if (this.missing != 0 && this.missing != size) {
				int mid = (ri - li) / 2 + li;
				this.left = new Node(li, mid, '0');
				this.right = new Node(mid, ri, '1');
			}
		}

		private int count() {
			if (left != null && right != null) {
				return left.count() + right.count();
			} else {
				return this.size == this.missing ? this.missing : 0;
			}
		}

		private void getMissing(List<Integer> nodes) {
			if (left != null && right != null) {
				left.getMissing(nodes);
				right.getMissing(nodes);
			} else {
				for (int i = li, m = missing; i < ri && m > 0; i++, m--) {
					nodes.add(i);
				}
			}
		}

	}

}
