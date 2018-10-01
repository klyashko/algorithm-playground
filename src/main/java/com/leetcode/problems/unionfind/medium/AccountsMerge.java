package com.leetcode.problems.unionfind.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/accounts-merge/description/
 */
public class AccountsMerge {

	class Solution {
		public List<List<String>> accountsMerge(List<List<String>> accounts) {
			Map<String, String> parents = new HashMap<>();
			Map<String, String> names = new HashMap<>();

			for (List<String> account : accounts) {
				if (account.isEmpty()) {
					continue;
				}
				String name = account.get(0);
				if (account.size() == 2) {
					names.put(account.get(1), name);
					find(parents, account.get(1));
				}
				for (int i = 1; i < account.size() - 1; i++) {
					String email1 = account.get(i);
					String email2 = account.get(i + 1);

					names.put(email1, name);
					names.put(email2, name);

					String p1 = find(parents, email1);
					String p2 = find(parents, email2);
					if (!p1.equals(p2)) {
						parents.put(p2, p1);
					}
				}
			}

			Map<String, Set<String>> output = new HashMap<>();
			for (String key : parents.keySet()) {
				String p = find(parents, key);
				if (!output.containsKey(p)) {
					output.put(p, new HashSet<>());
				}
				output.get(p).add(key);
			}

			List<List<String>> result = new ArrayList<>();
			for (String key : output.keySet()) {
				List<String> emails = new ArrayList<>(output.get(key));
				emails.sort(String::compareTo);
				emails.add(0, names.get(key));

				result.add(emails);
			}
			return result;
		}

		private String find(Map<String, String> parents, String key) {
			if (!parents.containsKey(key)) {
				parents.put(key, key);
				return key;
			} else if (parents.get(key).equals(key)) {
				return key;
			}
			String p = find(parents, parents.get(key));
			parents.put(key, p);
			return p;
		}
	}

}
