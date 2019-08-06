package com.algorithm.playground.leetcode.problems.lc200.lc230.lc234;

import com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * <p>
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

	class Solution {

		public boolean isPalindrome(ListNode head) {
			boolean[] ans = {true};
			isPalindrome(head, head, ans);
			return ans[0];
		}

		private ListNode isPalindrome(ListNode tail, ListNode head, boolean[] ans) {
			if (tail == null) {
				return head;
			}
			head = isPalindrome(tail.next, head, ans);
			if (head.val != tail.val) {
				ans[0] = false;
			}
			return head.next;
		}
	}

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) { val = x; }
	 * }
	 */
	class SolutionWithStack {

		public boolean isPalindrome(ListNode head) {
			LinkedList<ListNode> stack = new LinkedList<>();

			ListNode node = head;

			while (node != null) {
				stack.push(node);
				node = node.next;
			}

			int half = stack.size() >> 1;

			for (int i = 0; i < half; i++, head = head.next) {
				if (head.val != stack.pop().val) {
					return false;
				}
			}

			return true;
		}
	}

}
