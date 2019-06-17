package com.algorithm.playground.google.codejam._2019.round3.task4;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static java.util.Collections.emptyList;

/**
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051707/0000000000159170
 * <p>
 * Original solution https://codingcompetitions.withgoogle.com/codejam/submissions/0000000000051707/ZWF0bW9yZQ
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				int n = console.nextInt();
				console.nextInt();
				int[] x = new int[n];
				int[] y = new int[n];
				for (int i = 0; i < n; i++) {
					x[i] = console.nextInt();
					y[i] = console.nextInt();
				}
				List<Rational> ans = solve(x, y);
				if (ans.isEmpty()) {
					System.out.println(String.format("Case #%s: IMPOSSIBLE", test));
				} else {
					System.out.println(String.format("Case #%s: POSSIBLE", test));
					for (Rational r : ans) {
						System.out.print(r);
						System.out.print(' ');
					}
					System.out.println();
				}
			}
		}
	}

	private static List<Rational> solve(int[] x, int[] y) {
		int n = x.length;
		Rational[] xs = new Rational[n << 1];
		Rational[] ys = new Rational[n << 1];
		for (int i = 0; i < n; i++) {
			xs[i << 1] = new Rational(x[i], 1);
			xs[(i << 1) + 1] = new Rational(x[i] + x[(i + 1) % n], 2);

			ys[i << 1] = new Rational(y[i], 1);
			ys[(i << 1) + 1] = new Rational(y[i] + y[(i + 1) % n], 2);
		}

		for (int i = 0; i < n; i++) {
			Rational a = ys[i + n].subtract(ys[i]);
			Rational b = xs[i].subtract(xs[i + n]);
			Rational c = Rational.ZERO.subtract(a.multiply(xs[i])).subtract(b.multiply(ys[i]));

			boolean good = true;

			for (int j = 1; j < n; j++) {
				int k = i + j;
				int l = i - j;
				if (l < 0) {
					l += n << 1;
				}

				Rational aa = ys[l].subtract(ys[k]);
				Rational bb = xs[k].subtract(xs[l]);
				if (!a.multiply(aa).add(b.multiply(bb)).equals(Rational.ZERO)) {
					good = false;
					break;
				}

				Rational v1 = a.multiply(xs[k]).add(b.multiply(ys[k])).add(c);
				Rational v2 = a.multiply(xs[l]).add(b.multiply(ys[l])).add(c);
				if (!v1.add(v2).equals(Rational.ZERO)) {
					good = false;
					break;
				}
			}
			if (good) {
				return Arrays.asList(xs[i], ys[i], xs[i + n], ys[i + n]);
			}
		}
		return emptyList();
	}

	private static class Rational {

		private static final Rational ZERO = new Rational(0, 1);

		private final long numerator;
		private final long denominator;

		private Rational(long numerator, long denominator) {
			long gcd = gcd(Math.abs(numerator), Math.abs(denominator));
			if (denominator > 0) {
				this.numerator = numerator / gcd;
				this.denominator = denominator / gcd;
			} else {
				this.numerator = -numerator / gcd;
				this.denominator = -denominator / gcd;
			}
		}

		private static long gcd(long a, long b) {
			while (b != 0) {
				long tmp = a % b;
				a = b;
				b = tmp;
			}
			return a;
		}

		private Rational add(Rational other) {
			long numerator = this.numerator * other.denominator + this.denominator * other.numerator;
			long denominator = this.denominator * other.denominator;
			return new Rational(numerator, denominator);
		}

		private Rational multiply(Rational other) {
			long numerator = this.numerator * other.numerator;
			long denominator = this.denominator * other.denominator;
			return new Rational(numerator, denominator);
		}

		private Rational subtract(Rational other) {
			long numerator = this.numerator * other.denominator - this.denominator * other.numerator;
			long denominator = this.denominator * other.denominator;
			return new Rational(numerator, denominator);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Rational rational = (Rational) o;
			return numerator == rational.numerator && denominator == rational.denominator;
		}

		@Override
		public int hashCode() {
			return Objects.hash(numerator, denominator);
		}

		@Override
		public String toString() {
			return numerator + "/" + denominator;
		}
	}

}
