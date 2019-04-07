package com.algorithm.playground.google.codejam._2019.qualification.datbae;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("Duplicates")
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

				Queue<Region> queue = new ArrayDeque<>();

				int len = B * 2;

				int nRegions = N / len + (N % len == 0 ? 0 : 1);
				nRegions = Math.min(nRegions, N);
				int idx = 0;

				for (int r = 0; r < nRegions; r++) {
					int start = idx;
					int end = Math.min(start + len, N);
					queue.offer(new Region(start, end));
					idx = end;
				}

				TreeSet<Integer> missing = new TreeSet<>();

				for (int i = 0; i < F; i++) {

					int size = queue.size();
					StringBuilder message = new StringBuilder();
					Queue<Region> next = new ArrayDeque<>();
					for (int j = 0; j < size; j++) {
						Region region = queue.poll();
						//noinspection ConstantConditions
						region.append(message);
						next.offer(region);
					}

					System.out.println(message.toString());

					char[] response = readResponse(console).toCharArray();
					int[] idxArr = {0};

					while (!next.isEmpty()) {
						Region curr = next.poll();
						for (Region region : curr.split(response, idxArr)) {
							if (region.isMissing()) {
								missing.addAll(region.members());
							}
							queue.offer(region);
						}

					}

					if (missing.size() == B) {
						break;
					}
				}
				String message = missing.stream().map(Objects::toString).collect(Collectors.joining(" "));
				System.out.println(message);
				int response = console.nextInt();
				if (response == -1) {
					throw new RuntimeException("Try again");
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

	private static class Region {
		private final int li, ri, mid;
		private int missing;

		private Region(int li, int ri) {
			this(li, ri, -1);
		}

		private Region(int li, int ri, int missing) {
			this.li = li;
			this.ri = ri;
			this.mid = (ri - li) / 2 + li;
			this.missing = missing;
		}

		private void append(StringBuilder builder) {
			for (int i = li; i < mid; i++) {
				builder.append('0');
			}
			for (int i = mid; i < ri; i++) {
				builder.append('1');
			}
		}

		private int size() {
			return ri - li;
		}

		private boolean isMissing() {
			return size() == missing;
		}

		private Set<Integer> members() {
			Set<Integer> set = new HashSet<>();
			for (int i = li; i < ri; i++) {
				set.add(i);
			}
			return set;
		}

		private List<Region> split(char[] response, int[] idx) {
			if (missing == 0) {
				idx[0] += ri - li;
				return Collections.singletonList(this);
			} else if (isMissing()) {
				return Collections.singletonList(this);
			}
			int zeros = read(response, idx, mid - li, '0');
			int size = ri - mid;
			if (missing != -1) {
				size -= missing - zeros;
			}
			int ones = read(response, idx, size, '1');

			if (zeros == 0 && ones == 0) {
				missing = 0;
				return Collections.singletonList(this);
			} else {
				return Arrays.asList(
						new Region(li, mid, zeros),
						new Region(mid, ri, ones)
				);
			}
		}

		private int read(char[] response, int[] idx, int size, char val) {
			for (; size > 0 && idx[0] < response.length; ) {
				if (response[idx[0]] == val) {
					size--;
					idx[0]++;
				} else {
					break;
				}
			}
			return size;
		}

		@Override
		public String toString() {
			return "Region{" +
					"li=" + li +
					", ri=" + ri +
					", mid=" + mid +
					", missing=" + missing +
					'}';
		}
	}

}
