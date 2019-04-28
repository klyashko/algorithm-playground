package com.algorithm.playground.sort;

import java.util.Arrays;

public class SortUtils {

	public static void mergeSort(int[] arr) {
		if (arr.length > 1) {
			int mid = arr.length / 2;
			int[] left = Arrays.copyOfRange(arr, 0, mid);
			int[] right = Arrays.copyOfRange(arr, mid, arr.length);

			mergeSort(left);
			mergeSort(right);

			int idx = 0, li = 0, ri = 0;
			while (li < left.length && ri < right.length) {
				if (right[ri] < left[li]) {
					arr[idx++] = right[ri++];
				} else {
					arr[idx++] = left[li++];
				}
			}

			while (li < left.length) {
				arr[idx++] = left[li++];
			}

			while (ri < right.length) {
				arr[idx++] = right[ri++];
			}
		}
	}

}
