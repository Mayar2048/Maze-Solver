package eg.edu.alexu.csd.ds.maze.cs74;

import javax.management.RuntimeErrorException;

import eg.edu.alexu.csd.ds.maze.MyLinkedList;
import eg.edu.alexu.csd.ds.maze.collect;

public class LinkedList_implementation implements collect {
	MyLinkedList queue = new singleList();

	public void add(Object element) {
		// TODO Auto-generated method stub
		queue.add(element);

	}

	public Object remove() {
		// TODO Auto-generated method stub
		if (queue.isEmpty()) {
			throw new IllegalStateException("Queue is Empty !!!");
		} else {
			Object store = queue.get(0);
			queue.remove(0);
			return store;
		}
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (queue.isEmpty());
	}

	public Object peek() throws RuntimeErrorException {
		// TODO Auto-generated method stub
		throw new RuntimeErrorException(null, "Invalid");
	}

}
