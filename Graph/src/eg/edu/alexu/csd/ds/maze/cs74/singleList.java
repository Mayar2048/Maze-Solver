package eg.edu.alexu.csd.ds.maze.cs74;

import java.util.EmptyStackException;

import eg.edu.alexu.csd.ds.maze.MyLinkedList;

public class singleList implements MyLinkedList {
	ListNode head = null;

	public void add(int index, Object element) {
		ListNode newnode = new ListNode(element);
		int length = size();

		if (index == 0) {
			newnode.next = head;
			head = newnode;
		} else if (index > length || index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			ListNode i = head;
			for (int counter = 0; counter < index - 1; counter++) {
				i = i.next;
			}
			newnode.next = i.next;
			i.next = newnode;
		}
	}

	public void add(Object element) {

		ListNode newnode = new ListNode(element);
		if (head == null) {
			head = newnode;
			newnode.next = null;
		} else {
			ListNode i = head;
			ListNode y = null;
			while (i != null) {
				y = i;
				i = i.next;
			}
			newnode.next = null;
			y.next = newnode;
		}

	}

	public Object get(int index) {
		ListNode i = head;
		int length = size();
		if (index >= length || index < 0)
			throw new IndexOutOfBoundsException();
		else {
			for (int counter = 0; counter < index; counter++) {
				i = i.next;
			}
		}
		Object element = i.element;
		return element;

	}

	public void set(int index, Object element) {
		int length = size();
		if (length <= index || index < 0)
			throw new IndexOutOfBoundsException();
		ListNode i = head;
		for (int counter = 0; counter < index; counter++) {
			i = i.next;
		}
		i.element = element;
	}

	public void clear() {
		if (head == null) {
			throw new EmptyStackException();
		}
		else {
			head = null;
		}
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	public void remove(int index) {
		ListNode i = head;
		int length = size();
		if (index < 0 || length <= index) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			head = head.next;
		} else {
			for (int counter = 0; counter < index - 1; counter++) {

				i = i.next;
			}
			ListNode j = i.next;
			i.next = j.next;
		}

	}

	public int size() {
		int length = 0;
		ListNode i = head;

		while (i != null) {
			length++;
			i = i.next;
		}
		return length;
	}

	public MyLinkedList sublist(int fromIndex, int toIndex) {
		MyLinkedList newlist = new singleList();
		if (fromIndex < 0 || fromIndex > size() - 1 || toIndex < 0
				|| toIndex > size() - 1 || fromIndex > toIndex) {
			throw new IndexOutOfBoundsException();
		}

		// else{
		ListNode y = head;
		for (int i = 0; i < fromIndex; i++) {
			y = y.next;
		}
		for (int i = fromIndex; i <= toIndex; i++) {
			newlist.add(y.element);
			y = y.next;
		}
		// }

		return newlist;
	}

	public boolean contains(Object o) {
		if (head == null) {
			return false;
		} else {
			ListNode i = head;
			while (i != null) {
				if (i.element == o)
					return true;
				else
					i = i.next;
			}
		}

		return false;
	}
}
