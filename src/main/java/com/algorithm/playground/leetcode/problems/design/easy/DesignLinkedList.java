package com.algorithm.playground.leetcode.problems.design.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/design-linked-list/description/
 */
public class DesignLinkedList {

	class MyLinkedList {

		private Node head;
		private Node tail;
		private int size;

		/**
		 * Initialize your data structure here.
		 */
		public MyLinkedList() {
			head = new Node(-1);
			tail = new Node(-1);
			head.next = tail;
			tail.prev = head;
		}

		/**
		 * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
		 */
		public int get(int index) {
			Node n = getNode(index);
			return n != null ? n.val : -1;
		}

		/**
		 * Add a node of value val before the first element of the linked list.
		 * After the insertion, the new node will be the first node of the linked list.
		 */
		public void addAtHead(int val) {
			addAtIndex(0, val);
		}

		/**
		 * Append a node of value val to the last element of the linked list.
		 */
		public void addAtTail(int val) {
			addAtIndex(size, val);
		}

		/**
		 * Add a node of value val before the index-th node in the linked list.
		 * If index equals to the length of linked list, the node will be appended to the end of linked list.
		 * If index is greater than the length, the node will not be inserted.
		 */
		public void addAtIndex(int index, int val) {
			Node curr = getNode(index - 1);
			if (curr != null) {
				Node n = new Node(val, curr, curr.next);
				curr.next.prev = n;
				curr.next = n;
				size++;
			}
		}

		/**
		 * Delete the index-th node in the linked list, if the index is valid.
		 */
		public void deleteAtIndex(int index) {
			Node curr = getNode(index);
			if (curr != null) {
				curr.prev.next = curr.next;
				curr.next.prev = curr.prev;
				size--;
			}
		}

		private Node getNode(int idx) {
			if (idx >= size) {
				return null;
			}
			int mid = size / 2;
			Node curr;
			if (idx < mid) {
				curr = head;
				for (int i = -1; i < idx; i++) {
					curr = curr.next;
				}
			} else {
				curr = tail;
				for (int i = 0; i < size - idx; i++) {
					curr = curr.prev;
				}
			}
			return curr;
		}

		@Override
		public String toString() {
			List<String> strings = new ArrayList<>();
			Node curr = head;
			while (curr != null) {
				strings.add(Integer.toString(curr.val));
				curr = curr.next;
			}
			return "MyLinkedList{" +
					"size=" + size +
					", values=[" + String.join(", ", strings) +
					"]}";
		}

		private class Node {
			int val;
			Node prev, next;

			public Node(int val) {
				this.val = val;
			}

			public Node(int val, Node prev, Node next) {
				this(val);
				this.prev = prev;
				this.next = next;
			}

			@Override
			public String toString() {
				return "Node{" +
						"val=" + val +
						", next=" + next +
						'}';
			}
		}
	}

}
