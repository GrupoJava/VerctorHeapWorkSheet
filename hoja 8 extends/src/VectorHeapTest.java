import static org.junit.Assert.*;

import org.junit.Test;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert.*;
import java.util.Vector;
import junit.framework.TestCase;
// TODO: Auto-generated Javadoc

/**
 * The Class VectorHeapTest.
 *
 * @author Admin
 */

public class VectorHeapTest extends TestCase{
	    
    	/**
    	 * Instantiates a new vector heap test.
    	 */
    	public VectorHeapTest(){
	    }
	    
	    /** The heap. */
    	VectorHeap<String> heap = new VectorHeap();
	    
	    /**
    	 * Test add.
    	 */
    	@Test
	    public void testAdd(){
	        System.out.println("add");
	        String prioridad = "A";
	        heap.add(prioridad);
	        assertEquals(prioridad,heap.remove());
	    }
	    
	    /**
    	 * Test remove.
    	 */
    	@Test
	    public void testRemove(){
	        System.out.println("remove");
	        
	        String prioridad1="A";
	        String prioridad2="B";
	        heap.add(prioridad1);
	        heap.add(prioridad2);
	        String Result = "B";
	        String result = heap.remove();  // "A"
	        result = heap.remove();         // "B"
	        assertEquals(Result, result);   ///"B"="B"
	    }
	        
	    }

