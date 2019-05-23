package com.algorithm.playground.data.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class SuffixArray {

	private int[] array;
	private String string;

	public SuffixArray(String string) {
		this.string = string;
		this.array = SuffixArrayUtils.buildSuffixArrayNaive(string);
	}

	public int getFirst(String s) {
		int idx = getIdx(s);
		return idx == -1 ? -1 : reduce(s, array[idx], idx, Math::min);
	}

	public int getLast(String s) {
		int idx = getIdx(s);
		return idx == -1 ? -1 : reduce(s, array[idx], idx, Math::max);
	}

	public int count(String s) {
		int idx = getIdx(s);
		return idx == -1 ? 0 : reduce(s, 1, idx, (count, ignored) -> count + 1);
	}

	public boolean contains(String s) {
		return getIdx(s) != -1;
	}

	@Override
	public String toString() {
		int len = countDigits(array.length);
		StringBuilder builder = new StringBuilder();
		for (int i : array) {
			builder.append("\t\t")
					.append(padding(i, len))
					.append(" : <")
					.append(string.substring(i))
					.append(">\n");
		}
		return "SuffixArray{\n" + builder + '}';
	}

	private int reduce(String s, int value, int idx, IntBinaryOperator op) {
		for (int l = idx - 1; l >= 0 && compareSubstrings(s, array[l]) == 0; l--) {
			value = op.applyAsInt(value, array[l]);
		}

		for (int r = idx + 1; r < array.length && compareSubstrings(s, array[r]) == 0; r++) {
			value = op.applyAsInt(value, array[r]);
		}

		return value;
	}

	private int getIdx(String s) {
		int lo = 0, hi = array.length - 1;
		while (lo <= hi) {
			int mid = (hi - lo >> 1) + lo;
			int compare = compareSubstrings(s, array[mid]);
			if (compare < 0) {
				lo = mid + 1;
			} else if (compare > 0) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	private int compareSubstrings(String pattern, int idx) {
		int i = 0;
		for (; i < pattern.length() && idx < string.length(); i++, idx++) {
			char ch1 = string.charAt(idx);
			char ch2 = pattern.charAt(i);
			if (ch1 != ch2) {
				return ch1 - ch2;
			}
		}
		return i == pattern.length() ? 0 : -1;
	}

	private String padding(int i, int len) {
		len = len - countDigits(i);
		StringBuilder builder = new StringBuilder();
		for (int j = 0; j < len; j++) {
			builder.append(' ');
		}
		return builder.append(i).toString();
	}

	private int countDigits(int i) {
		int count = i == 0 ? 1 : 0;
		//noinspection StatementWithEmptyBody
		for (; i > 0; count++, i /= 10) ;
		return count;
	}

	private static class SuffixArrayUtils {

		/**
		 * The simplest way to constract a suffix array, just to sort all substrings
		 *
		 * @param string
		 *
		 * @return
		 */
		private static int[] buildSuffixArrayNaive(String string) {
			int[] array = new int[string.length()];
			List<Integer> indexes = new ArrayList<>(string.length());
			for (int i = 0; i < array.length; i++) {
				indexes.add(i);
			}

			indexes.sort((i1, i2) -> compare(i1, i2, string));

			for (int i = 0; i < array.length; i++) {
				array[i] = indexes.get(i);
			}
			return array;
		}

		/**
		 * Performs sorting by rank in order to build a suffix array
		 *
		 * @param string
		 *
		 * @return
		 */
		private static int[] buildSuffixArrayRankSort(String string) {
			int[] array = new int[string.length()];
			Suffix[] suffixes = new Suffix[string.length()];
			int N = string.length();
			for (int i = 0; i < N; i++) {
				Suffix suffix = new Suffix();
				suffix.idx = i;
				suffix.rank = string.charAt(i);
				suffix.nextRank = i + 1 < N ? string.charAt(i + 1) : -1;
				suffixes[i] = suffix;
			}

			Arrays.sort(suffixes);

			for (int k = 4; k < N << 1; k <<= 1) {
				int rank = 0;
				int prev = suffixes[0].rank;
				suffixes[0].rank = rank;
				array[suffixes[0].idx] = rank;

				for (int i = 1; i < N; i++) {
					if (suffixes[i].rank == prev && suffixes[i].nextRank == suffixes[i - 1].nextRank) {
						prev = suffixes[i].rank;
						suffixes[i].rank = rank;
					} else {
						prev = suffixes[i].rank;
						suffixes[i].rank = ++rank;
					}
					array[suffixes[i].idx] = i;
				}

				for (int i = 0; i < N; i++) {
					int next = suffixes[i].idx + (k >> 1);
					suffixes[i].nextRank = next < N ? suffixes[array[next]].rank : -1;
				}

				Arrays.sort(suffixes);
			}

			for (int i = 0; i < N; i++) {
				array[i] = suffixes[i].idx;
			}
			return array;
		}

		/**
		 * Sort substrings by one character
		 *
		 * @param string
		 *
		 * @return
		 */
		private static int[] buildSuffixArrayRadixSort(String string) {
			int[] array = new int[string.length()];
			int[][] suffixes = new int[string.length()][2];
			int N = string.length();
			for (int i = 0; i < N; i++) {
				suffixes[i][0] = i;
			}

			Arrays.sort(suffixes, charComparator(0, string));

			for (int i = 0; i < N - 1; i++) {
				array[0] = suffixes[0][0];

				int rank = 0, prevRank = 0, len = 1;
				for (int j = 1; j < suffixes.length; j++) {
					array[j] = suffixes[j][0];
					int[] prev = suffixes[j - 1];
					int[] curr = suffixes[j];
					if (curr[0] + i < N && prev[0] + i < N && curr[1] == prevRank) {
						char ch1 = string.charAt(curr[0] + i);
						char ch2 = string.charAt(prev[0] + i);
						prevRank = curr[1];
						if (ch1 == ch2) {
							len++;
							curr[1] = rank;
						} else {
							if (len > 1) {
								Arrays.sort(suffixes, j - len, j, charComparator(i + 1, string));
							}
							len = 1;
							curr[1] = ++rank;
						}
					} else {
						if (len > 1) {
							Arrays.sort(suffixes, j - len, j, charComparator(i + 1, string));
						}
						len = 1;
						prevRank = curr[1];
						curr[1] = ++rank;
					}
				}
				if (len > 1) {
					Arrays.sort(suffixes, suffixes.length - len, suffixes.length, charComparator(i + 1, string));
				} else if (rank + 1 == N) {
					break;
				}

			}
			return array;
		}

		private static Comparator<int[]> charComparator(int idx, String string) {
			return (s1, s2) -> {
				if (s1[1] != s2[1]) {
					return s1[1] - s2[1];
				}
				if (s1[0] + idx >= string.length() || s2[0] + idx >= string.length()) {
					return s2[0] - s1[0];
				}
				char ch1 = string.charAt(s1[0] + idx);
				char ch2 = string.charAt(s2[0] + idx);
				return ch1 - ch2;
			};
		}

		private static int compare(int i1, int i2, String string) {
			while (i1 < string.length() && i2 < string.length()) {
				char ch1 = string.charAt(i1++);
				char ch2 = string.charAt(i2++);
				if (ch1 != ch2) {
					return ch1 - ch2;
				}
			}
			return i2 - i1;
		}

		private static class Suffix implements Comparable<Suffix> {

			private int idx;
			private int rank;
			private int nextRank;

			@Override
			public int compareTo(Suffix that) {
				if (rank == that.rank) {
					return nextRank - that.nextRank;
				} else {
					return rank - that.rank;
				}
			}

			@Override
			public String toString() {
				return "Suffix{" +
						"idx=" + idx +
						", rank=" + rank +
						", nextRank=" + nextRank +
						'}';
			}
		}

	}

}
