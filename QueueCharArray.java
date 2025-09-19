/*
 * QueueCharArray.java
 * fall 2025
 * prof. lehman
 * caroline smith 
 * 
 * Queue approach has first and last point
 * to first and last elements in array.
 * The variable size is used to denote
 * an empty vs. full queue
 */
public class QueueCharArray {

	// data
	char data[];
	int front;
	int back;
	int size;
	int MAX;

	// default constructor
	public QueueCharArray() {
		MAX = 5; 				//max is set to 5 characters
		data = new char[MAX];	//array will be made of characters no longer than the MAX that is set (5)
		front = 0; 				//position 0
		back = -1;				//1 before the front
		size = 0;				//0 characters (initially)
	}

	// alternate constructor
	public QueueCharArray(int max) {
		MAX = max;				//this allows the user to change the max capacity later
		data = new char[MAX];
		front = 0;
		back = -1;
		size = 0;
	}

	// delete all items in queue
	public void clear() {
		front = 0;
		back = -1;
		size = 0;
	}

	// add to back of queue
	public void add(char v) {
		if (full()) {
			System.out.println("Queue is full. Cannot add " + v);
		}
		back = (back + 1) % MAX;		//the % MAX is used to make sure that if the position exeeds the max, it will wrap back around to the back
		data[back] = v;					//puts new character v in the position where back is stored
		size++;
	}

	// see if queue is empty
	public boolean empty() {
		return size == 0;
	}

	// see if queue is full
	public boolean full() {
		return size == MAX;
	}

	// return element from front of queue
	public char front() {
		if (empty())
			return '?';
		else
			return data[front];
	}

	// remove element from front of queue
	public boolean remove() {
		if (empty()) {
			return false;
		}
		front = (front + 1) % MAX;		//this moves front forward after old front was removed, % MAX is still used to wrap around if position exceeds max size
		size--;							//when the element is removed, the size reduces by one
		return true;
	}

	public int size() {
		return size;
	}

	 /**
     * use with println to display queue
     * 
     * @return set as a String
     */
    public String toString() 
	{
		if (empty())
			return "[]";
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size; i++) {				//for position is 0 and position is less than size, add one to position
			int index = (front + i) % MAX;				//the index is equal to front plus position mod max (which wraps around if needed)
			sb.append(data[index]);						//the character at this index is added to array
		if (i < size - 1) sb.append(", ");			//if the element is not the last in the array, add a comma
		}
		sb.append("]");
		return sb.toString();
    }
}// class
