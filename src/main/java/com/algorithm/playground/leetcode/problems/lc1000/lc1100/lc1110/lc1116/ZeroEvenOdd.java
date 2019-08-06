package com.algorithm.playground.leetcode.problems.lc1000.lc1100.lc1110.lc1116;

import java.util.function.IntConsumer;

/**
 * https://leetcode.com/problems/print-zero-even-odd/
 * <p>
 * Suppose you are given the following code:
 * <p>
 * class ZeroEvenOdd {
 * public ZeroEvenOdd(int n) { ... }      // constructor
 * public void zero(printNumber) { ... }  // only output 0's
 * public void even(printNumber) { ... }  // only output even numbers
 * public void odd(printNumber) { ... }   // only output odd numbers
 * }
 * The same instance of ZeroEvenOdd will be passed to three different threads:
 * <p>
 * Thread A will call zero() which should only output 0's.
 * Thread B will call even() which should only ouput even numbers.
 * Thread C will call odd() which should only output odd numbers.
 * Each of the threads is given a printNumber method to output an integer. Modify the given program to output the series 010203040506... where the length of the series must be 2n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: "0102"
 * Explanation: There are three threads being fired asynchronously. One of them calls zero(), the other calls even(), and the last one calls odd(). "0102" is the correct output.
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: "0102030405"
 */
public class ZeroEvenOdd {

	private final int n;
	private final Object mutex = new Object();
	private volatile int current;

	public ZeroEvenOdd(int n) {
		this.n = n;
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			awaitFor(0);
			printNumber.accept(0);
			current = (i & 1) + 1;
			wakeup();
		}
	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		for (int i = 2; i <= n; i += 2) {
			awaitFor(2);
			printNumber.accept(i);
			current = 0;
			wakeup();
		}
	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		for (int i = 1; i <= n; i += 2) {
			awaitFor(1);
			printNumber.accept(i);
			current = 0;
			wakeup();
		}
	}

	private void awaitFor(int state) throws InterruptedException {
		while (current != state) {
			synchronized (mutex) {
				mutex.wait();
			}
		}
	}

	private void wakeup() {
		synchronized (mutex) {
			mutex.notifyAll();
		}
	}

}
