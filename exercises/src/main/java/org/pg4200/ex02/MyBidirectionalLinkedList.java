package org.pg4200.ex02;

import org.pg4200.les02.list.MyList;

public class MyBidirectionalLinkedList<T> implements MyList<T> {

	private class ListNode {
		T value;
		ListNode next;
		ListNode previous;
	}

	private ListNode head;
	private ListNode tail;
	private int size;

	@Override
	public void delete(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		/*ListNode node = head;

		for (int i = 1; i < index; i++) {
			node = node.next;
		}*/

		if (index == 0) { //delete head
			ListNode node = head.next;
			//node.previous = null;
			head = node;
			size--;
		} else if (index == (size() - 1)) { // delete tail
			ListNode node = tail.previous;
			//node.next = null;
			tail = node;
			size--;
		} else if (index <= size() / 2) { // delete before middle
			ListNode node = head;

			for (int i = 0; i < index; i++) {
				node = node.next;
			}

			ListNode previousNode = node.previous;
			ListNode nextNode = node.next;

			previousNode.next = nextNode;
			nextNode.previous = previousNode;

			size--;

		} else if (index > size() / 2) { //delete after middle
			ListNode node = tail;

			for (int i = (size() - 1); i > index; i--) {
				node = node.previous;
			}

			ListNode previousNode = node.previous;
			ListNode nextNode = node.next;

			previousNode.next = nextNode;
			nextNode.previous = previousNode;

			size--;
		}

		/*else { // delete nodes in the middle.
			ListNode node = null;

			for (int i = 1; i < index; i++) {
				node = node.next;
			}

			ListNode previousNode = node.previous;
			ListNode nextNode =  node.next;

			previousNode.next = nextNode;
			nextNode.previous = previousNode;

			size--;
		}*/
	}

	@Override
	public T get(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			return head.value;
		} else if (index == size) {
			return tail.value;
		} else if (index <= size() / 2) {
			ListNode node = head;

			for (int i = 0; i < index; i++) {
				node = node.next;
			}

			return node.value;
		} else if (index > size() / 2) {
			ListNode node = tail;

			for (int i = (size() - 1); i > index; i--) {
				node = node.previous;
			}

			return node.value;
		}
		return null;
	}

	@Override
	public void add(int index, T value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		ListNode node = new ListNode();
		node.value = value;

		if (head == null && size == 0) { //Empty list
			head = node;
			tail = node;
			size++;
		} else if (index == 0) { //add beginingto non-empty list
			node.next = head;
			head = node;

			ListNode nextNode = head.next;
			ListNode previousNode = null;

			for (int i = 0; i < size; i++) {
				if (i == 0) {
					nextNode.previous = head;
					previousNode = nextNode;
					nextNode = nextNode.next;
				} else {
					nextNode.previous = previousNode;
					previousNode = nextNode;
					nextNode = nextNode.next;
				}
			}
			size++;
		} else if (index == size) { //add at end of non-empty list
			tail.next = node;
			node.previous = tail;
			tail = node;

			size++;
		} else if (index <= size() / 2) { //add to first half of list. start
			// from head
			ListNode nodeAtIndex = head;

			for (int i = 0; i < index; i++) {
				nodeAtIndex = nodeAtIndex.next;
			}
			ListNode previousNode = nodeAtIndex.previous;

			previousNode.next = node;
			node.previous = previousNode;
			node.next = nodeAtIndex;
			nodeAtIndex.previous = node;

			size++;
		} else if (index > size() / 2) { //add to second half of list. start
			// from tail.
			ListNode nodeAtIndex = tail;

			for (int i = size() - 1; i > index; i--) {
				/*if (i == (index + 1)) {
					previousNode = nextNode.previous;
				}*/
				nodeAtIndex = nodeAtIndex.previous;
			}
			ListNode previousNode = nodeAtIndex.previous;

			previousNode.next = node;
			node.previous = previousNode;
			node.next = nodeAtIndex;
			nodeAtIndex.previous = node;

			size++;
		}
	}

	@Override
	public int size() {
		return size;
	}
}