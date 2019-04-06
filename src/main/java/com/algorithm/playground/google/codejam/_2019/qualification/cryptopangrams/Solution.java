package com.algorithm.playground.google.codejam._2019.qualification.cryptopangrams;

import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		try (Scanner console = new Scanner(System.in)) {
			int tests = console.nextInt();
			for (int test = 1; test <= tests; test++) {
				//skip n
				console.next();
				//len
				int k = console.nextInt();
				// skip the rest of line
				console.nextLine();
				String line = console.nextLine().trim();
				String ans = solve(line, k);
				System.out.println(String.format("Case #%s: %s", test, ans));
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	static String solve(String line, int k) {
		String[] parts = line.split(" ");
		BigInteger[] integers = new BigInteger[parts.length];
		for (int i = 0; i < parts.length; i++) {
			integers[i] = new BigInteger(parts[i]);
		}

		BigInteger[] phrase = new BigInteger[k + 1];

		int idx = 0;
		while (integers[idx].equals(integers[idx + 1])) {
			idx++;
		}

		BigInteger first = integers[idx];
		BigInteger second = integers[idx + 1];

		BigInteger gcb = first.gcd(second);
		TreeMap<BigInteger, String> letters = new TreeMap<>();

		first = first.divide(gcb);
		phrase[idx] = first;
		letters.put(first, "");

		phrase[idx + 1] = gcb;
		letters.put(gcb, "");

		second = second.divide(gcb);
		phrase[idx + 2] = second;
		letters.put(second, "");

		BigInteger prev = second;

		for (int i = idx + 2; i < k; i++) {
			BigInteger curr = integers[i].divide(prev);
			phrase[i + 1] = curr;
			letters.put(curr, "");
			prev = curr;
		}

		for (int i = idx - 1; i >= 0; i--) {
			BigInteger curr = integers[i].divide(phrase[i + 1]);
			phrase[i] = curr;
			letters.put(curr, "");
		}

		char ch = 'A';

		for (Map.Entry<BigInteger, String> entry : letters.entrySet()) {
			entry.setValue(String.valueOf(ch++));
		}

		StringBuilder ans = new StringBuilder();
		for (BigInteger integer : phrase) {
			ans.append(letters.get(integer));
		}

		return ans.toString();
	}

}
