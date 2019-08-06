package com.algorithm.playground.leetcode.problems.lc1000.lc1100.lc1110.lc1115;

/**
 * https://leetcode.com/problems/print-foobar-alternately/
 * <p>
 * Suppose you are given the following code:
 * <p>
 * class FooBar {
 * public void foo() {
 * for (int i = 0; i < n; i++) {
 * print("foo");
 * }
 * }
 * <p>
 * public void bar() {
 * for (int i = 0; i < n; i++) {
 * print("bar");
 * }
 * }
 * }
 * The same instance of FooBar will be passed to two different threads.
 * Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: "foobar"
 * Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: "foobarfoobar"
 * Explanation: "foobar" is being output 2 times.
 */
public class FooBar {

	private final Object mutex = new Object();
	private final int n;

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {
		for (int i = 0; i < n; i++) {
			// printFoo.run() outputs "foo". Do not change or remove this line.
			synchronized (mutex) {
				printFoo.run();
				mutex.notifyAll();
				mutex.wait();
			}
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {
		for (int i = 1; i <= n; i++) {
			// printBar.run() outputs "bar". Do not change or remove this line.
			synchronized (mutex) {
				printBar.run();

				mutex.notifyAll();
				if (i != n) {
					mutex.wait();
				}
			}
		}
	}

}
