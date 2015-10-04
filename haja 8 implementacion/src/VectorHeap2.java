
import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class VectorHeap2.
 *
 * @param <E> the element type
 */
public class VectorHeap2<E extends Comparable<E>> implements PriorityQueue<E>{

	/** The data. */
	protected Vector<E> data; // the data, kept in heap order
	
	/**
	 * Instantiates a new vector heap2.
	 */
	public VectorHeap2()
	// post: constructs a new priority queue
	{
		data = new Vector<E>();
	}
	
	/**
	 * Instantiates a new vector heap2.
	 *
	 * @param v the v
	 */
	public VectorHeap2(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
			{ // add elements to heap
			add(v.get(i));
			}
	}
	
	/**
	 * Parent.
	 *
	 * @param i the i
	 * @return the int
	 */
	protected static int parent(int i)
	// pre: 0 <= i < size
	// post: returns parent of node at location i
	{
		return (i-1)/2;
	}
	
	/**
	 * Left.
	 *
	 * @param i the i
	 * @return the int
	 */
	protected static int left(int i)
	// pre: 0 <= i < size
	// post: returns index of left child of node at location i
	{
		return 2*i+1;
	}
	
	/**
	 * Right.
	 *
	 * @param i the i
	 * @return the int
	 */
	protected static int right(int i)
	// pre: 0 <= i < size
	// post: returns index of right child of node at location i
	{
		return 2*(i+1);
	}

	/**
	 * Percolate up.
	 *
	 * @param leaf the leaf
	 */
	protected void percolateUp(int leaf)
	// pre: 0 <= leaf < size
	// post: moves node at index leaf up to appropriate position
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 && (value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}
	
	/**
	 * Push down root.
	 *
	 * @param root the root
	 */
	protected void pushDownRoot(int root)
	// pre: 0 <= root < size
	// post: moves node at index root down
	// to appropriate position in subtree
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) 
		{
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) && ((data.get(childpos+1)).compareTo (data.get(childpos)) < 0))
				{
					childpos++;
				}
				// Assert: childpos indexes smaller of two children
				if ((data.get(childpos)).compareTo (value) < 0)
				{
					data.set(root,data.get(childpos));
					root = childpos; // keep moving down
			} else { // found right location
				data.set(root,value);
				return;
			}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}

	
	/* (non-Javadoc)
	 * @see PriorityQueue#add(java.lang.Comparable)
	 */
	public void add(E value)
	// pre: value is non-null comparable
	// post: value is added to priority queue
	{
		data.add(value);
		percolateUp(data.size()-1);
	}
	
	/* (non-Javadoc)
	 * @see PriorityQueue#remove()
	 */
	@Override
	public E remove() {
		//pre: !isEmpty()
		//post: removes and returns the minimum value in priority queue
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if(data.size()>1){pushDownRoot(0);};
		return minVal;
	}


	/* (non-Javadoc)
	 * @see PriorityQueue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see PriorityQueue#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see PriorityQueue#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see PriorityQueue#getFirst()
	 */
	@Override
	public E getFirst() {
		// TODO Auto-generated method stub
		return data.get(0);
	}
}
