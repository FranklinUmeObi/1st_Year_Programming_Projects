import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 "
        		+ "- expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8"
        		+ " - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700"
        		+ " - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }

    @Test
    public void testEmpty()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        assertTrue(testDLL.isEmpty());
        testDLL.insertBefore(0,1);
        assertFalse(testDLL.isEmpty());

    }
    
    
    
    @Test
    public void testGet()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        assertNull( null,testDLL.get(8));
        assertNull( null,testDLL.get(-4));
        assertNotNull(testDLL.get(0));
        assertNotNull(testDLL.get(1));
        assertNotNull(testDLL.get(2));
        
        testDLL = new DoublyLinkedList<Integer>();
        assertNull(testDLL.get(-2));
        assertNull(testDLL.get(0));
        
    }
    
    @Test
    public void testDelete()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        assertTrue(testDLL.deleteAt(1));
        assertTrue(testDLL.deleteAt(0));
        assertEquals( "3", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        assertTrue(testDLL.deleteAt(1));
        assertTrue(testDLL.deleteAt(1));
        assertEquals( "1", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        assertTrue(testDLL.deleteAt(2));
        assertTrue(testDLL.deleteAt(0));
        assertEquals( "2", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        assertTrue(testDLL.deleteAt(0));
        assertEquals( "2,3", testDLL.toString() );
        
        assertFalse(testDLL.deleteAt(2));
        assertFalse(testDLL.deleteAt(-34));
        assertFalse(testDLL.deleteAt(200));
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        assertFalse(testDLL.deleteAt(-1));
        assertEquals( "1,2,3", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        assertTrue(testDLL.deleteAt(0));
        assertEquals( "", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        assertFalse(testDLL.deleteAt(-1));
        
        testDLL = new DoublyLinkedList<Integer>();
        assertFalse(testDLL.deleteAt(8));
        
    }
    
    @Test
    public void testReverse()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.reverse();
        assertEquals( "", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.reverse();
        assertEquals( "1", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        assertEquals( "1,2", testDLL.toString() );
        testDLL.reverse();
        assertEquals( "2,1", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,5);
        testDLL.insertBefore(5,6);
        assertEquals( "1,2,3,4,5,6", testDLL.toString() );
        testDLL.reverse();
        assertEquals( "6,5,4,3,2,1", testDLL.toString() );
    }
    
    @Test
    public void testUnique()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,5);
        testDLL.insertBefore(5,6);
        testDLL.makeUnique();
        assertEquals( "1,2,3,4,5,6", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,1);
        testDLL.insertBefore(2,1);
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,5);
        testDLL.insertBefore(5,6);
        testDLL.makeUnique();
        assertEquals( "1,4,5,6", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,1);
        testDLL.insertBefore(2,1);
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,4);
        testDLL.insertBefore(5,4);
        testDLL.makeUnique();
        assertEquals( "1,4", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,1);
        testDLL.insertBefore(2,1);
        testDLL.insertBefore(3,1);
        testDLL.insertBefore(4,1);
        testDLL.insertBefore(5,1);
        testDLL.makeUnique();
        assertEquals( "1", testDLL.toString() );

    }
    
    @Test
    public void testStack()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(3);
    	assertEquals( "3", testDLL.toString() );
    	
    	testDLL.push(2);
    	assertEquals( "2,3", testDLL.toString() );
    	
    	testDLL.push(1);
    	assertEquals( "1,2,3", testDLL.toString() );
    	
    	testDLL.pop();
    	assertEquals( "2,3", testDLL.toString() );
    	
    	testDLL.pop();
    	assertEquals( "3", testDLL.toString() );
    	
    	testDLL.pop();
    	assertEquals( "", testDLL.toString() );
    	
    	assertNull(testDLL.pop());
    	
    }
    
    @Test
    public void testQueue()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(3);
    	assertEquals( "3", testDLL.toString() );
    	
    	testDLL.enqueue(2);
    	assertEquals( "2,3", testDLL.toString() );
    	
    	testDLL.enqueue(1);
    	assertEquals( "1,2,3", testDLL.toString() );
    	
    	testDLL.dequeue();
    	assertEquals( "1,2", testDLL.toString() );
    	
    	testDLL.dequeue();
    	assertEquals( "1", testDLL.toString() );
    	
    	testDLL.dequeue();
    	assertEquals( "", testDLL.toString() );
    	
    	assertNull(testDLL.dequeue());
    	
    	testDLL = new DoublyLinkedList<Integer>();
    	assertNull(testDLL.dequeue());
    	testDLL.enqueue(3);
    	
    }
    
    @Test
    public void testGetSize()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(55);
    	assertEquals( 1, testDLL.getListSize());
    	
    	 testDLL = new DoublyLinkedList<Integer>();
    	 assertEquals( 0, testDLL.getListSize());
    	 
    	 testDLL = new DoublyLinkedList<Integer>();
     	testDLL.push(55);
     	testDLL.push(55);
     	assertEquals( 2, testDLL.getListSize());
    }
    
    @Test
    public void testnodeShift()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertNull(testDLL.nodeToShift(55));
    }
    
    @Test
    public void testdeleteNode()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertFalse(testDLL.deleteNode(testDLL.nodeToShift(0)));
    	testDLL.push(8);
    	assertFalse(testDLL.deleteNode(testDLL.nodeToShift(3)));
    	
    	testDLL.push(7);
    	testDLL.push(6);
    	assertTrue(testDLL.deleteNode(testDLL.nodeToShift(0)));
    	assertTrue(testDLL.deleteNode(testDLL.nodeToShift(1)));
    }
    
    
    
    
    
    

}