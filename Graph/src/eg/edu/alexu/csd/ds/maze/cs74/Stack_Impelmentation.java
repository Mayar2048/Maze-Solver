package eg.edu.alexu.csd.ds.maze.cs74;

import eg.edu.alexu.csd.ds.maze.MyLinkedList;
import eg.edu.alexu.csd.ds.maze.collect;


public class Stack_Impelmentation implements collect {
	private MyLinkedList myList = new singleList();

	public void add(Object element) {
		myList.add(0, element);
		
	}

	public Object remove() {
		Object value = myList.get(0);
		myList.remove(0);
		return value;
	}

	public boolean isEmpty() {
		if(myList.isEmpty()){
			return true;
		}
		return false;
	}

	public Object peek() {
		Object value = myList.get(0);
		return value;
	}

	

}
