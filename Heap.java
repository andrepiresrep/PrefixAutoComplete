import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Queue;
/**
 * This class represents a Binary Minimum Heap.
 * @param <E> The type of elements to be in the Generic Heap.
 */
public class Heap<E extends Comparable<E>> extends AbstractQueue<E> implements Queue<E> {
	private ArrayList<E> aq;
	public Heap() {
		aq = new ArrayList<E>();
	}
	/**
	 * @return the Data structure to hold the Heap.
	 */
	public ArrayList<E> getArrayList(){
		return aq;
	}
	
	/**
	 * @param i The element in the heap we want to know the parent of
	 * @return The parent of the element with index i
	 * If i is even, the parent is index (i-2)/2
	 * Else the parent is index(i-1)/2
	 */
	public int parent(int i) {
		if(i % 2 == 0) {
			return (i-2)/2;
		}
		return (i-1)/2;
	}
	
	/**
	 * This method swaps elements if it's parent is lower.
	 * @param i The index of the element in the heap.
	 */
	public void upHeap(int i) {
		if(i > 0 && aq.get(i).compareTo(aq.get(parent(i))) > 0) {
			Collections.swap(aq, i, parent(i));
			upHeap(parent(i));
		}
	}
	
	/**
	 * Checks if the children of an element is greater than the parent.
	 * If it is set that element to be the largest.
	 * At last if the largest element is not the same as the element we started with, swap them and apply this method again to the largest.
	 * @param i The index of the element in the heap.
	 */
	public void downHeap(int i) {
		int l = (2*i+1);
		int r = (2*i+2);
		int largest = (i);
		if(l <= aq.size()-1 && aq.get(l).compareTo(aq.get(largest))> 0) {
			largest = l;
		}
		if(r <= aq.size()-1 && aq.get(r).compareTo(aq.get(largest))> 0) {
			largest = r;
		}
		if(largest != i) {
			Collections.swap(aq, i, largest);
			downHeap(largest);
		}
	}
	@Override
	/**
	 * This method inserts an element in the heap and afterwards runs the method upHeap on that element.
	 * @return boolean that is True if an element was not null and False if it was.
	 * Our heap does not allow the insertion of null elements.
	 */
	public boolean offer(E item) {
		if(item == null) {
			return false;
		}
			aq.add(item);
			upHeap(aq.size()-1);
			return true;
	}

	@Override
	/**
	 * @return The array's iterator.
	 */
	public Iterator<E> iterator() {
		return aq.iterator();
	}
	
	@Override
	/**
	 * @return The minimum element of the heap.
	 */
	public E peek(){
		if(isEmpty()) {
			return null;
		}
		return aq.get(0);
	}

	@Override
	/**
	 * @return The minimum element of the heap and remove it.
	 */
	public E poll() {
		if(isEmpty()) {
			return null;
		}
		E min = peek();
		delete();
		return min;
	}
	
	/**
	 * Sets the element with index 0 to the last element of the heap.
	 * Removes the last element from the heap and applies downHeap to the first element of the heap.
	 */
	public void delete() {
		aq.set(0, aq.get(aq.size()-1));
		aq.remove(aq.size()-1);
		downHeap(0);
	}
	/**
	 * @return boolean from the array's isEmpty method.
	 */
	public boolean isEmpty() {
		return aq.isEmpty();
	}

	@Override
	/**
	 * @return the size of the array.
	 */
	public int size() {
		return aq.size();
	}
	/**
	 * @return String representation of the array.
	 */
	public String toString() {
		return aq.toString();
	}
}