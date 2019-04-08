package com.algorithm.playground.utils;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtils {

	public static <T> Stream<T> stream(Iterable<T> source) {
		return StreamSupport.stream(source.spliterator(), false);
	}

}
