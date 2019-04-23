package com.algorithm.playground.leetcode.problems.lc900.lc981;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 * <p>
 * Create a timebased key-value store class TimeMap, that supports two operations.
 * <p>
 * 1. set(string key, string value, int timestamp)
 * <p>
 * Stores the key and value, along with the given timestamp.
 * 2. get(string key, int timestamp)
 * <p>
 * Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
 * If there are multiple such values, it returns the one with the largest timestamp_prev.
 * If there are no values, it returns the empty string ("").
 */
public class TimeBasedKeyValueStore {

	/**
	 * Your TimeMap object will be instantiated and called as such:
	 * TimeMap obj = new TimeMap();
	 * obj.set(key,value,timestamp);
	 * String param_2 = obj.get(key,timestamp);
	 */
	class TimeMap {

		private Map<String, TreeMap<Integer, String>> timestampsMap = new HashMap<>();

		/** Initialize your data structure here. */
		public TimeMap() {}

		public void set(String key, String value, int timestamp) {
			timestampsMap.computeIfAbsent(key, ignored -> new TreeMap<>()).put(timestamp, value);
		}

		public String get(String key, int timestamp) {
			return Optional.ofNullable(timestampsMap.get(key))
					.map(map -> map.floorEntry(timestamp))
					.map(Map.Entry::getValue)
					.orElse("");
		}
	}

}
