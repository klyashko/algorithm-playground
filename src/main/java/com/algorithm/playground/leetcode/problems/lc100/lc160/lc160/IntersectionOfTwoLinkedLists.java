package com.algorithm.playground.leetcode.problems.lc100.lc160.lc160;

import com.algorithm.playground.leetcode.problems.utils.linkedlist.ListNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists {

	public class Solution {

		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			int sizeA = size(headA);
			int sizeB = size(headB);
			int min = Math.min(sizeA, sizeB);
			headA = scroll(headA, sizeA - min);
			headB = scroll(headB, sizeB - min);

			while (headA != null) {
				if (headA == headB) {
					return headA;
				}
				headA = headA.next;
				headB = headB.next;
			}

			return null;
		}

		private ListNode scroll(ListNode node, int count) {
			while (count-- > 0) {
				node = node.next;
			}
			return node;
		}

		private int size(ListNode node) {
			int size = 0;
			while (node != null) {
				size++;
				node = node.next;
			}
			return size;
		}

	}

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) {
	 * val = x;
	 * next = null;
	 * }
	 * }
	 */
	public class SolutionWithStack {

		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			LinkedList<ListNode> stackA = new LinkedList<>();
			LinkedList<ListNode> stackB = new LinkedList<>();

			while (headA != null) {
				stackA.push(headA);
				headA = headA.next;
			}

			while (headB != null) {
				stackB.push(headB);
				headB = headB.next;
			}

			ListNode node = null;

			while (!stackA.isEmpty() && !stackB.isEmpty()) {
				ListNode a = stackA.pop();
				ListNode b = stackB.pop();
				if (a == b) {
					node = a;
				} else {
					break;
				}
			}

			return node;
		}

	}

}
