package com.algorithm.playground.barclays.task1;

import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String word = bufferedReader.readLine();

		String censured = Result.censure(word);

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		bufferedWriter.write(censured);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

}

class Result {

	/*
	 * Complete the 'censure' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts STRING word as parameter.
	 */

	public static String censure(String word) {
		// Write your code here
		int[] counts = new int[26];

		for (int i = 0; i < word.length(); i++) {
			int idx = word.charAt(i) - 'a';
			counts[idx]++;
			if (counts[idx] == 2) {
				return censure(word.length());
			}
		}
		return word;
	}

	private static String censure(int len) {
		StringBuilder builder = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			builder.append('X');
		}
		return builder.toString();
	}

}
