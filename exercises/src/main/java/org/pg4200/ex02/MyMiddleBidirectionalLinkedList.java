package org.pg4200.ex02;

import org.pg4200.les02.list.MyList;

public class MyMiddleBidirectionalLinkedList<T> implements MyList<T> {

	private class ListNode {
		T value;
		ListNode next;
		ListNode previous;
	}

	private ListNode head;
	private ListNode middle;
	private ListNode tail;
	private int size;

	@Override
	public void delete(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

			int quarter = size() / 4;
			int half = size() / 2;
			int threeFourths = quarter * 3;

		if (index == 0) { //delete head
			ListNode node = head.next;
			head = node;
			size--;
		} else if (index == (size() - 1)) { // delete tail
			ListNode node = tail.previous;
			tail = node;
			size--;
		} else if (index >= quarter && index <= half) { // index is in the range 25%-50%
			ListNode node = middle;

			for (int i = (half - 1); i > index; i--) {
				node = node.previous;
			}

			ListNode previousNode = node.previous;
			ListNode nextNode = node.next;

			previousNode.next = nextNode;
			nextNode.previous = previousNode;

			size--;
		} else if (index > half && index <= threeFourths) { // index in 50%-75% range
			ListNode node = middle;

			if ((size() % 2) == 0) { // if size is even
				for (int i = (half - 1); i < index; i++) {
					node = node.next;
				}
			} else { // if size is odd
				for (int i = half; i < index; i++) {
					node = node.next;
				}
			}

			ListNode previousNode = node.previous;
			ListNode nextNode = node.next;

			previousNode.next = nextNode;
			nextNode.previous = previousNode;

			size--;
		} else if (index < quarter) { //delete before range.
			ListNode node = head;

			for (int i = 0; i < index; i++) {
				node = node.next;
			}

			ListNode previousNode = node.previous;
			ListNode nextNode = node.next;

			previousNode.next = nextNode;
			nextNode.previous = previousNode;

			size--;
		} else if (index > threeFourths) { //delete after range.
			ListNode node = tail;

			for (int i = size() - 1; i > index; i--) {
				node = node.previous;
			}

			ListNode previousNode = node.previous;
			ListNode nextNode = node.next;

			previousNode.next = nextNode;
			nextNode.previous = previousNode;

			size--;
		}

		if ((size() % 2) == 0 && size() != 1) { //if the size is an even number
			ListNode middleNode = head;

			for (int i = 0; i < (size() / 2) - 1; i++) {
				middleNode = middleNode.next;
			}

			middle = middleNode;
		} else if ((size() % 2) != 0 && size() != 1) { // size is odd
			ListNode middleNode = head;

			for (int i = 0; i < ((size() + 1) / 2) - 1; i++) {
				middleNode = middleNode.next;
			}

			middle = middleNode;
		}
	}

	@Override
	public T get(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		int quarter = 0;
		int half = 0;
		int threeFourths = 0;

		if (size() != 0) {
			quarter = size() / 4;
			half = size() / 2;
			threeFourths = quarter * 3;
		}

		if (index == 0) {
			return head.value;
		} else if (index == size) {
			return tail.value;
		} else if (index >= quarter && index < half) { // index is in the range 25%-50%
			ListNode node = middle;

			/*for (int i = (half - 1); i > index; i--) {
				node = node.previous;
			}*/

			if ((size() % 2) == 0) { // if size is even
				for (int i = (half - 1); i > index; i--) {
					node = node.previous;
				}
			} else { // if size is odd
				for (int i = half; i > index; i--) {
					node = node.previous;
				}
			}

			return node.value;
		} else if (index >= half && index <= threeFourths) { // index in 50%-75% range
			ListNode node = middle;

			if ((size() % 2) == 0) { // if size is even
				for (int i = (half - 1); i < index; i++) {
					node = node.next;
				}
			} else { // if size is odd
				for (int i = half; i < index; i++) {
					node = node.next;
				}
			}

			return node.value;
		} else if (index < quarter) { //get before range.
			ListNode node = head;

			for (int i = 0; i < index; i++) {
				node = node.next;
			}

			return node.value;
		} else if (index > threeFourths) { //get after range.
			ListNode node = tail;

			for (int i = size() - 1; i > index; i--) {
				node = node.previous;
			}

			return node.value;
		}

		/*else if (index <= size() / 2) {
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
		}*/
		return null;
	}

	@Override
	public void add(int index, T value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		int quarter = 0;
		int half = 0;
		int threeFourths = 0;

		if (size() != 0) {
			quarter = size() / 4;
			half = size() / 2;
			threeFourths = quarter * 3;
		}

		ListNode node = new ListNode();
		node.value = value;

		if (head == null && size == 0) { //Empty list
			head = node;
			middle = node;
			tail = node;
			size++;
		} else if (index == 0) { //add begining to non-empty list
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
		} else if (index >= quarter && index < half) { // index is in the range 25%-50%
			ListNode nodeAtIndex = middle;

			for (int i = (half - 1); i > index; i--) {
				nodeAtIndex = nodeAtIndex.previous;
			}

			ListNode nodeAtIndexPrevious = nodeAtIndex.previous;

			node.previous = nodeAtIndexPrevious;
			nodeAtIndexPrevious.next = node;
			nodeAtIndex.previous = node;

			size++;
		} else if (index >= half && index <= threeFourths) { // index in 50%-75% range
			ListNode nodeAtIndex = middle;

			for (int i = half; i <= index; i++) {
				nodeAtIndex = nodeAtIndex.next;
			}

			ListNode nodeAtIndexPrevious = nodeAtIndex.previous;

			node.previous = nodeAtIndexPrevious;
			nodeAtIndexPrevious.next = node;
			nodeAtIndex.previous = node;

			size++;
		} else if (index < quarter) { //add to first quarter of list.
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
		} else if (index > threeFourths) { //add to second half of list. start
			// from tail.
			ListNode nodeAtIndex = tail;

			for (int i = size() - 1; i > index; i--) {
				nodeAtIndex = nodeAtIndex.previous;
			}

			ListNode previousNode = nodeAtIndex.previous;

			previousNode.next = node;
			node.previous = previousNode;
			node.next = nodeAtIndex;
			nodeAtIndex.previous = node;

			size++;
		}

		if ((size() % 2) == 0 && size() != 1) { //if the size is an even number
				ListNode middleNode = head;

				for (int i = 0; i < (size() / 2) - 1; i++) {
					middleNode = middleNode.next;
				}

				middle = middleNode;
			} else if ((size() % 2) != 0 && size() != 1) { // size is odd
				ListNode middleNode = head;

				for (int i = 0; i < ((size() + 1) / 2) - 1; i++) {
					middleNode = middleNode.next;
				}

				middle = middleNode;
			}
	}

	@Override
	public int size() {
		return size;
	}
}