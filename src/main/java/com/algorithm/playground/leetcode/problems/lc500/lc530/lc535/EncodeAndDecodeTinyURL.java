package com.algorithm.playground.leetcode.problems.lc500.lc530.lc535;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 */
public class EncodeAndDecodeTinyURL {

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.decode(codec.encode(url));
	public class Codec {

		private Map<String, String> hashToUrl = new HashMap<>();
		private Random rnd = new Random();
		private String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		// Encodes a URL to a shortened URL.
		public String encode(String longUrl) {
			String key = getKey();
			String host = getHost(longUrl);

			while (hashToUrl.containsKey(key)) {
				key = getKey();
			}
			hashToUrl.put(key, longUrl);
			return host + key;
		}

		// Decodes a shortened URL to its original URL.
		public String decode(String shortUrl) {
			String host = getHost(shortUrl);
			return hashToUrl.get(shortUrl.replace(host, ""));
		}

		private String getKey() {
			StringBuilder builder = new StringBuilder(8);
			for (int i = 0; i < 8; i++) {
				builder.append(alphabet.charAt(rnd.nextInt(alphabet.length())));
			}
			return builder.toString();
		}

		private String getHost(String s) {
			int count = 0;
			int idx = 0;

			while (count < 3) {
				if (s.charAt(idx) == '/') {
					count++;
				}
				idx++;
			}
			return s.substring(0, idx);
		}
	}

}
