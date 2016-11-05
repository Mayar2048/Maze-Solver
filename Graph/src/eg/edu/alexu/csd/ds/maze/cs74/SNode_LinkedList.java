package eg.edu.alexu.csd.ds.maze.cs74;

import eg.edu.alexu.csd.ds.maze.MyLinkedList;

public class SNode_LinkedList implements MyLinkedList {
	SNode head, tail;
	int size;

	public SNode_LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	// done
	public void add(int index, Object element) throws RuntimeException {//edit exception
		// TODO Auto-generated method stub
		// add first
		if (index == 1) {
			SNode first_index = new SNode(element, null);
			if (head == null) {
				head = first_index;
				tail = head;
			} else {
				first_index.setlink(head);
				head = first_index;
			}
			size++;
		} else if ((index > 1) && (index <= size + 1)) { // edit size + 1
			index = index - 1;
			SNode temp = head;
			for (int i = 1; i < size + 1; i++) {// edit size + 1
				if (i == index) {
					SNode index_Node = new SNode(element, temp.getLink());
					temp.setlink(index_Node);
					break;
				}
				temp = temp.getLink();
			}
			size++;
		} else {
			throw new RuntimeException("add : Index is Out Of Bounds!");
		}
	}

	// done
	public void add(Object element) {
		// TODO Auto-generated method stub
		SNode last_node = new SNode(element, null);

		if (head == null) { // means that it's an empty list
			head = last_node;
			tail = head;
		} else {
			tail.setlink(last_node);
			tail = last_node;
		}
		size++;
	}

	// done
	public Object get(int index) throws RuntimeException {//edit exception
		// TODO Auto-generated method stub
		if ((index >= 1) && (index <= size)) {
			SNode temp = head;
			Object store = null;

			for (int i = 1; i <= size; i++) {
				if (i == index) {
					store = temp.getData();
					break;
				}
				temp = temp.getLink();
			}
			return store;
		} else {
			throw new RuntimeException("get : Index is Out Of Bounds!");
		}
	}

	// done
	public void set(int index, Object element) throws RuntimeException {// edit exception
		// TODO Auto-generated method stub
		if ((index >= 1) && (index <= size)) {
			SNode temp = head;
			for (int i = 1; i <= size; i++) {
				if (i == index) {
					temp.setData(element);
				}
				temp = temp.getLink();
			}
		} else {
			throw new RuntimeException("set : Index is Out Of Bounds!");
		}
	}

	// done
	public void clear() {
		// TODO Auto-generated method stub
		if (size > 0) {
			while (head != tail) {
				SNode temp = head;
				head = head.getLink();
				temp.setlink(null);
				size--;
			}
			head = head.getLink();
			tail = tail.getLink();
			size--;
		}
	}

	// done
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (head == null);
	}

	// done
	public void remove(int index) throws RuntimeException {// edit exception
		// TODO Auto-generated method stub
		if (index == 1) { // delete first node
			head = head.getLink();
			size--;
			return;
		} else if (index == size) { // delete last node
			SNode temp = head;
			SNode follow = head;
			while (temp != tail) {
				follow = temp;
				temp = temp.getLink();
			}
			tail = follow;
			tail.setlink(null);
			size--;
			return;
		} else if ((index > 1) && (index < size)) {
			SNode temp = head;
			index = index - 1;
			for (int i = 1; i < size; i++) {
				if (i == index) {
					SNode follow = temp.getLink();
					follow = follow.getLink();
					temp.setlink(follow);
					break;
				}
				temp = temp.getLink();
			}
			size--;
		} else {
			throw new RuntimeException("remove : Index is Out Of Bounds!");
		}
	}

	// done
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	// done
	public MyLinkedList sublist(int fromIndex, int toIndex) throws RuntimeException {// edit exception 
		// TODO Auto-generated method stub
		SNode_LinkedList sublist = new SNode_LinkedList();
		if (fromIndex >= 1 && toIndex <= size && fromIndex <= toIndex) {
			SNode temp = head;
			for (int i = 1; i <= size; i++) {
				if ((i >= fromIndex) && (i <= toIndex)) {
					sublist.add(temp.getData());
				}
				temp = temp.getLink();
			}
		} else {
			throw new RuntimeException("sublist : Index is Out Of Bounds!");
		}
		return sublist;
	}

	// done
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		SNode temp = head;
		for (int i = 1; i <= size; i++) {
			if (temp.getData() == o) {
				return true;
			}
			temp = temp.getLink();
		}
		return false;
	}

}
