package com.algorithm.playground.utils;

import com.algorithm.playground.data.structure.Tuple2;

import java.util.*;

import static com.algorithm.playground.utils.StreamUtils.stream;
import static java.util.stream.Collectors.toList;

public class CollectionUtils {

	public static <V> List<V> sort(Iterable<V> source, Comparator<V> comparator) {
		return stream(source).sorted(comparator).collect(toList());
	}

	@SafeVarargs
	public static <V> List<V> list(V... values) {
		return new ArrayList<>(Arrays.asList(values));
	}

	public static <V> V last(List<V> source) {
		if (source.isEmpty()) {
			throw new NoSuchElementException();
		}
		return source.get(source.size() - 1);
	}

	public static <V> List<Tuple2<V, V>> combinations(List<V> source) {
		List<Tuple2<V, V>> result = new ArrayList<>();
		for (int i = 0; i < source.size(); i++) {
			V curr = source.get(i);
			for (int j = i + 1; j < source.size(); j++) {
				result.add(new Tuple2<>(curr, source.get(j)));
			}
		}
		return result;
	}

	public static <V> List<List<V>> permutation(List<V> source) {
		List<List<V>> result = new ArrayList<>();
		permutation(source, new ArrayList<>(), new HashSet<>(), result);
		return result;
	}

	private static <V> void permutation(List<V> source, List<V> curr, Set<Integer> used, List<List<V>> result) {
		if (curr.size() == source.size()) {
			result.add(new ArrayList<>(curr));
			return;
		}
		int last = curr.size();
		for (int i = 0; i < source.size(); i++) {
			if (used.add(i)) {
				curr.add(source.get(i));
				permutation(source, curr, used, result);
				curr.remove(last);
				used.remove(i);
			}
		}
	}

}
