package com.algorithm.playground.leetcode.problems.lc900.lc900.lc901;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/online-stock-span/
 * <p>
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 * <p>
 * Write a class StockSpanner which collects daily price quotes for some stock,
 * and returns the span of that stock's price for the current day.
 * <p>
 * The span of the stock's price today is defined as the maximum number of consecutive days
 * (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
 * <p>
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85],
 * then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 * <p>
 * Note:
 * <p>
 * Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
 * There will be at most 10000 calls to StockSpanner.next per test case.
 * There will be at most 150000 calls to StockSpanner.next across all test cases.
 * The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.
 */
public class StockSpanner {

	private LinkedList<int[]> stack = new LinkedList<>();

	public int next(int price) {
		int count = 1;
		while (!stack.isEmpty() && stack.peek()[0] <= price) {
			count += stack.pop()[1];
		}
		stack.push(new int[]{price, count});
		return count;
	}

}
