package com.algorithm.playground.leetcode.problems.lc1000.lc1125;

import java.util.*;

/**
 * https://leetcode.com/problems/smallest-sufficient-team/
 * <p>
 * In a project, you have a list of required skills req_skills, and a list of people.
 * The i-th person people[i] contains a list of skills that person has.
 * <p>
 * Consider a sufficient team: a set of people such that for every required skill in req_skills,
 * there is at least one person in the team who has that skill.
 * We can represent these teams by the index of each person: for example,
 * team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].
 * <p>
 * Return any sufficient team of the smallest possible size, represented by the index of each person.
 * <p>
 * You may return the answer in any order.  It is guaranteed an answer exists.
 * <p>
 * Constraints:
 * <p>
 * 1 <= req_skills.length <= 16
 * 1 <= people.length <= 60
 * 1 <= people[i].length, req_skills[i].length, people[i][j].length <= 16
 * Elements of req_skills and people[i] are (respectively) distinct.
 * req_skills[i][j], people[i][j][k] are lowercase English letters.
 * It is guaranteed a sufficient team exists.
 */
public class SmallestSufficientTeam {

	class Solution {
		public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
			Map<String, Integer> indexes = new HashMap<>();
			for (int i = 0; i < req_skills.length; i++) {
				indexes.put(req_skills[i], i);
			}
			List<int[]> p = new ArrayList<>();
			for (int i = 0; i < people.size(); i++) {
				int mask = 0;
				for (String skill : people.get(i)) {
					Integer idx = indexes.get(skill);
					if (idx != null) {
						mask |= 1 << idx;
					}
				}
				if (mask != 0) {
					p.add(new int[]{i, mask, Integer.bitCount(mask)});
				}
			}
			p.sort(Comparator.comparingInt((int[] i) -> i[2]).reversed());
			int mask = (1 << indexes.size()) - 1;
			Holder holder = new Holder();
			collectTeam(p, 0, mask, new ArrayList<>(), holder);
			int[] result = new int[holder.list.size()];
			for (int i = 0; i < holder.list.size(); i++) {
				result[i] = holder.list.get(i);
			}
			return result;
		}

		private void collectTeam(List<int[]> people, int idx, int mask, List<Integer> curr, Holder holder) {
			if (mask == 0) {
				if (holder.isBetter(curr)) {
					holder.list = new ArrayList<>(curr);
				}
			} else if (idx < people.size() && holder.isBetter(curr)) {
				while (idx < people.size()) {
					int[] person = people.get(idx++);
					int newMask = mask ^ (mask & person[1]);
					if (newMask != mask) {
						curr.add(person[0]);
						collectTeam(people, idx, newMask, curr, holder);
						curr.remove(curr.size() - 1);
						collectTeam(people, idx, mask, curr, holder);
						break;
					}
				}
			}
		}

		private class Holder {

			private List<Integer> list;

			private boolean isBetter(List<Integer> list) {
				return this.list == null || list.size() < this.list.size();
			}

		}
	}

}
