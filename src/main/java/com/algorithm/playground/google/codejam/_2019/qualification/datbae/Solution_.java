package com.algorithm.playground.google.codejam._2019.qualification.datbae;

@SuppressWarnings("Duplicates")
public class Solution_ {

	public static void main(String[] args) {
		int n = 1024;
		int f = 10;
		for (int i = 0; i < f; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
//				System.out.println(String.format("j = %s, 1 << i = %s, j & (1 << i) = %s", j, 1 << i, j & (1 << i)));
				if ((j & (1 << i)) != 0) {
					sb.append(1);
				} else {
					sb.append(0);
				}
			}
			System.out.println(sb);
		}
	}

}
