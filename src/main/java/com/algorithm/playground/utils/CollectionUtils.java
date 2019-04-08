package com.algorithm.playground.utils;

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

}
