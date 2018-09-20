package com.leetcode.problems.design.easy;

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
			Node curr = head;
			for (int i = -1; i < index && curr != tail; i++) {
				curr = curr.next;
			}
			return curr.val;
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
			if (index <= size) {
				Node curr = head;
				for (int i = 0; i < index; i++) {
					curr = curr.next;
				}
				Node n = new Node(val);
				n.next = curr.next;
				n.prev = curr;
				curr.next.prev = n;
				curr.next = n;
				size++;
			}
		}

		/**
		 * Delete the index-th node in the linked list, if the index is valid.
		 */
		public void deleteAtIndex(int index) {
			if (index >= size) {
				return;
			}
			Node curr = head.next;
			for (int i = 0; i < index; i++) {
				curr = curr.next;
			}

			curr.prev.next = curr.next;
			curr.next.prev = curr.prev;
			size--;
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
