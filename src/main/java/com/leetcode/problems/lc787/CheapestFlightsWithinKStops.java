package com.leetcode.problems.lc787;

import java.util.*;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightsWithinKStops {

	public class SolutionDijkstra {
		public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

			int[][] prices = new int[n][n];
			for (int[] flight : flights) {
				prices[flight[0]][flight[1]] = flight[2];
			}

			PriorityQueue<City> queue = new PriorityQueue<>();
			queue.offer(new City(0, src, -1));

			int[] costs = new int[n];
			Arrays.fill(costs, Integer.MAX_VALUE);
			costs[src] = 0;
			int[] stops = new int[n];

			while (!queue.isEmpty()) {
				City city = queue.poll();
				if (city.stops > K) {
					continue;
				} else if (city.curr == dst) {
					return city.price;
				} else {
					int[] next = prices[city.curr];
					for (int i = 0; i < next.length; i++) {
						if (next[i] != 0) {
							int price = next[i];
							if (costs[i] > city.price + price) {
								stops[i] = city.stops + 1;
								costs[i] = city.price + price;
								queue.offer(new City(costs[i], i, stops[i]));
							} else if (stops[i] > city.stops + 1) {
								stops[i] = city.stops + 1;
								costs[i] = city.price + price;
								queue.offer(new City(costs[i], i, stops[i]));
							}
						}
					}
				}
			}

			return -1;
		}

		private class City implements Comparable<City> {

			private int price, curr, stops;

			City(int price, int curr, int stops) {
				this.price = price;
				this.curr = curr;
				this.stops = stops;
			}

			@Override
			public int compareTo(City o) {
				return Integer.compare(price, o.price);
			}

			@Override
			public String toString() {
				return "City{" +
						"price=" + price +
						", curr=" + curr +
						", stops=" + stops +
						'}';
			}
		}

	}

	/**
	 * Bellman Fold
	 */
	public class Solution {
		public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
			int[] prices = new int[n];
			Arrays.fill(prices, Integer.MAX_VALUE);
			prices[src] = 0;

			for (int i = 0; i <= K; i++) {
				int[] tmp = Arrays.copyOf(prices, prices.length);
				for (int[] flight : flights) {
					int curr = flight[0], next = flight[1], price = flight[2];
					if (prices[curr] != Integer.MAX_VALUE) {
						tmp[next] = Math.min(tmp[next], prices[curr] + price);
					}
				}
				prices = tmp;
			}

			return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
		}
	}

	class DFSSolution {
		public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
			if (src == dst) {
				return 0;
			}
			Map<Integer, List<int[]>> nodes = new HashMap<>();
			for (int[] f : flights) {
				int from = f[0];
				f[0] = from == src ? 1 : 0;
				if (!nodes.containsKey(from)) {
					nodes.put(from, new ArrayList<>());
				}
				nodes.get(from).add(f);
			}

			int max = dfs(nodes, Integer.MAX_VALUE, 0, src, dst, K, new boolean[n]);
			return max != Integer.MAX_VALUE ? max : -1;
		}

		private int dfs(Map<Integer, List<int[]>> nodes, int max, int sum, int curr, int dst, int K, boolean[] seen) {
			if (curr == dst) {
				return sum;
			} else if (K == -1) {
				return max;
			} else {
				for (int[] next : nodes.getOrDefault(curr, Collections.emptyList())) {
					if (sum + next[2] < max && !seen[next[1]]) {
						seen[next[1]] = true;
						max = dfs(nodes, max, sum + next[2], next[1], dst, K - 1, seen);
						seen[next[1]] = false;
					}
				}
			}
			return max;
		}
	}

}
