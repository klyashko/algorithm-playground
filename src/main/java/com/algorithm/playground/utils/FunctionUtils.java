package com.algorithm.playground.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class FunctionUtils {

	public static <K, V> Function<K, Set<V>> newHashSet() {
		return ignored -> new HashSet<>();
	}

	public static <K, V> Function<K, List<V>> newArrayList() {
		return ignored -> new ArrayList<>();
	}

}
