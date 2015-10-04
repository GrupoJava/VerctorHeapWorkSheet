// TODO: Auto-generated Javadoc
/**
 * The Interface PriorityQueue.
 *
 * @param <E> the element type
 */
public interface PriorityQueue<E extends Comparable<E>>
{
	
	/**
	 * Gets the first.
	 *
	 * @return the first
	 */
	public E getFirst();
	// pre: !isEmpty()
	// post: returns the minimum value in priority queue
	
	/**
	 * Removes the.
	 *
	 * @return the e
	 */
	public E remove();
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	
	/**
	 * Adds the.
	 *
	 * @param value the value
	 */
	public void add(E value);
	// pre: value is non-null comparable
	// post: value is added to priority queue
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty();
	// post: returns true iff no elements are in queue
	
	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size();
	// post: returns number of elements within queue
	
	/**
	 * Clear.
	 */
	public void clear();
	// post: removes all elements from queu

}