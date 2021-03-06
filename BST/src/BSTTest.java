import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
*  Test class for Doubly Linked List
*
*  @version 3.1 09/11/15 11:32:15
*
*  @author  TODO
*/
@RunWith(JUnit4.class)
public class BSTTest {

	@Test
	public void testIsEmpty() {
		 BST<Integer, Integer> bst = new BST<Integer, Integer>();
		 assertTrue(bst.isEmpty());
		 bst.put(3, 3); 
		 assertFalse(bst.isEmpty());
	}

	@Test
	public void testSize() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals(0, bst.size());
		bst.put(3, 3); 
		assertEquals(1, bst.size());
		bst.put(2, 2); 
		assertEquals(2, bst.size());
		bst.put(1, 1); 
		assertEquals(3, bst.size());
		bst.put(6, 6); 
		assertEquals(4, bst.size());
	}

	@Test
	public void testContains() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		 assertFalse(bst.contains(3));
		bst.put(3, 3); 
		 assertTrue(bst.contains(3));
		 assertFalse(bst.contains(4));
	}

	@Test
	public void testGet() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertNull(bst.get(3));
	   bst.put(7, 7);    
	   bst.put(8, 8);  
	   bst.put(3, 3);  
	   bst.put(1, 1); 
	   bst.put(2, 2);  
	   int L = bst.get(2);
		assertEquals(2, L);
		int R = bst.get(8);
		assertEquals(8, R);
	}

	@Test
	public void testPut() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(null, null);
		assertTrue(bst.isEmpty());
		bst.put(10, null);
		assertTrue(bst.isEmpty());

		 bst = new BST<Integer, Integer>();
		bst.put(7, 7); 
	     int abc =   bst.get(7);
	     assertEquals(7, abc);
		
	     bst = new BST<Integer, Integer>();
	     bst.put(7, 7); 
	     int a =   bst.get(7);
	     assertEquals(7, a);
	     bst.put(8, 8);
	     int b =   bst.get(8);
	     assertEquals(8, b);
	     bst.put(3, 3);  
	     int c =   bst.get(3);
	     assertEquals(3, c);
	     bst.put(1, 1);  
	     int d =   bst.get(1);
	     assertEquals(1, d);
	     bst.put(2, 2); 
	     int e =   bst.get(2);
	     assertEquals(2,e);
	     bst.put(10,10); 
	     int f =   bst.get(10);
	     assertEquals(10,f);
	     bst.put(11,11); 
	     int g =   bst.get(11);
	     assertEquals(11,g);

	}

	@Test
	public void testHeight() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals(-1, bst.height());
		bst.put(7, 7); 
		assertEquals(0, bst.height());
		bst.put(3, 3); 
		assertEquals(1, bst.height());
		bst.put(8, 8); 
		assertEquals(1, bst.height());
		bst.put(1, 1); 
		assertEquals(2, bst.height());
		bst.put(2, 2); 
		assertEquals(3, bst.height());
	}

	@Test
	public void testMedian() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertNull(bst.median());
		   bst.put(7, 7);    
		   bst.put(8, 8);  
		   bst.put(3, 3);  
		   bst.put(1, 1); 
		   bst.put(2, 2); 
		assertEquals(3, bst.median().intValue());
		
		bst = new BST<Integer, Integer>();
		   bst.put(7, 7);    
		   bst.put(8, 8);  
		   bst.put(9, 9);  
		   bst.put(10, 10); 
		   bst.put(2, 2); 
		assertEquals(8, bst.median().intValue());
	}

	@Test
	public void testPrintKeysInOrder() {
		 BST<Integer, Integer> bst = new BST<Integer, Integer>();
	     assertEquals("()", bst.printKeysInOrder());
	     bst.put(7, 7); 
	     bst.put(8, 8);
	     bst.put(3, 3);
	     bst.put(9, 9);
	     assertEquals("((()3())7(()8(()9())))", bst.printKeysInOrder());
	}

	 /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
    
	 @Test
	 public void testPrettyPrint() {
	     BST<Integer, Integer> bst = new BST<Integer, Integer>();
	     assertEquals("Checking pretty printing of empty tree",
	             "-null\n", bst.prettyPrintKeys());
	      
	     							//  -7
	     							//   |-3
	     							//   | |-1
	     							//   | | |-null
	     bst.put(7, 7); //   | |  -2
	     bst.put(8, 8); //   | |   |-null
	     bst.put(3, 3); //   | |    -null
	     bst.put(1, 1);  //   |  -6
	     bst.put(2, 2); //   |   |-4
	     bst.put(6, 6);//   |   | |-null
	     bst.put(4, 4);//   |   |  -5
	     bst.put(5, 5); //   |   |   |-null
	                          		//   |   |    -null
	     							//   |    -null
	                          		//    -8
	                          		//     |-null
	                          		//      -null
	     
	     String result = 
	      "-7\n" +
	      " |-3\n" + 
	      " | |-1\n" +
	      " | | |-null\n" + 
	      " | |  -2\n" +
	      " | |   |-null\n" +
	      " | |    -null\n" +
	      " |  -6\n" +
	      " |   |-4\n" +
	      " |   | |-null\n" +
	      " |   |  -5\n" +
	      " |   |   |-null\n" +
	      " |   |    -null\n" +
	      " |    -null\n" +
	      "  -8\n" +
	      "   |-null\n" +
	      "    -null\n";
	     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
	     }

	  
	     /** <p>Test {@link BST#delete(Comparable)}.</p> */
	     @Test
	     public void testDelete() {
	         BST<Integer, Integer> bst = new BST<Integer, Integer>();
	         bst.delete(1);
	         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
	         
	         bst.put(7, 7);   //        _7_
	         bst.put(8, 8);   //      /     \
	         bst.put(3, 3);   //    _3_      8
	         bst.put(1, 1);   //  /     \
	         bst.put(2, 2);   // 1       6
	         bst.put(6, 6);   //  \     /
	         bst.put(4, 4);   //   2   4
	         bst.put(5, 5);   //            \
	         								//             5
	         
	         assertEquals("Checking order of constructed tree",
	                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
	         
	         bst.delete(9);
	         assertEquals("Deleting non-existent key",
	                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
	 
	         bst.delete(8);
	         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
	 
	         bst.delete(6);
	         assertEquals("Deleting node with single child",
	                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
	 
	         bst.delete(3);
	         assertEquals("Deleting node with two children",
	                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
	         
	         bst.delete(1);
	         assertEquals("Deleting node with two children",
	                 "((()2(()4(()5())))7())", bst.printKeysInOrder());
	         
	     }
	     

}
