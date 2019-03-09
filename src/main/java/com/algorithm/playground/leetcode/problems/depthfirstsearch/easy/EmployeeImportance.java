package com.algorithm.playground.leetcode.problems.depthfirstsearch.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/employee-importance/description/
 */
public class EmployeeImportance {

	public static Employee e(int id, int importance, List<Integer> subordinates) {
		return new EmployeeImportance().employee(id, importance, subordinates);
	}

	private Employee employee(int id, int importance, List<Integer> subordinates) {
		Employee e = new Employee();
		e.id = id;
		e.importance = importance;
		e.subordinates = subordinates;
		return e;
	}

	class Solution {
		public int getImportance(List<Employee> employees, int id) {
			Map<Integer, Employee> map = new HashMap<>();
			for (Employee e : employees) {
				map.put(e.id, e);
			}
			return dfs(map, id);
		}

		private int dfs(Map<Integer, Employee> employees, int id) {
			Employee e = employees.get(id);
			int importance = e.importance;
			if (e.subordinates != null) {
				for (Integer s : e.subordinates) {
					importance += dfs(employees, s);
				}
			}
			return importance;
		}
	}

	class Employee {
		// It's the unique id of each node;
		// unique id of this employee
		public int id;
		// the importance value of this employee
		public int importance;
		// the id of direct subordinates
		public List<Integer> subordinates;
	}

}
