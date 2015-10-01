import java.util.PriorityQueue;
import java.util.Vector;

public class VectorHeap < E extends Comparable<E>> extends PriorityQueue<E>{
	protected Vector<E> data; // the data, kept in heap order
	/*Comparator<E> comparadorPacientes = new Comparator<E>(){

		public int compare(E paciente1, E paciente2) {
			
			return ((Paciente) paciente1).getPrioridad().compareTo(((Paciente) paciente2).getPrioridad());
		}
		
	};*/
	
	public VectorHeap()
	// post: constructs a new priority queue
	{
	data = new Vector<E>();
	}
	public VectorHeap(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
	int i;
	data = new Vector<E>(v.size()); // we know ultimate size
	for (i = 0; i < v.size(); i++)
	{ // add elements to heap
	add(v.get(i));
	}
	}
	protected static int parent(int i)
	// pre: 0 <= i < size
	// post: returns parent of node at location i
	{
	return (i-1)/2;
	}
	protected static int left(int i)
	// pre: 0 <= i < size
	// post: returns index of left child of node at location i
	{
	return 2*i+1;
	}
	protected static int right(int i)
	// pre: 0 <= i < size
	// post: returns index of right child of node at location i
	{
	return 2*(i+1);
	}
}