package com.algorithm.playground.sort;

import java.util.Arrays;

public class SortUtils {

	public static int[] min(int[] arr, int k) {
		min(arr, 0, arr.length, k);
		return Arrays.copyOfRange(arr, 0, k);
	}

	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length);
	}

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

	private static void min(int[] arr, int lo, int hi, int k) {
		if (lo < hi) {
			int i = partition(arr, lo, hi);
			min(arr, lo, i - 1, k);
			if (i < k) {
				min(arr, i, hi, k);
			}
		}
	}

	private static void quickSort(int[] arr, int lo, int hi) {
		if (lo < hi) {
			int i = partition(arr, lo, hi);
			quickSort(arr, lo, i - 1);
			quickSort(arr, i, hi);
		}
	}

	private static int partition(int[] arr, int lo, int hi) {
		int pivot = arr[lo];
		int i = lo + 1;
		for (int j = i; j < hi; j++) {
			if (arr[j] < pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i - 1, lo);
		return i;
	}

	private static void swap(int[] arr, int i1, int i2) {
		int tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
	}

}
