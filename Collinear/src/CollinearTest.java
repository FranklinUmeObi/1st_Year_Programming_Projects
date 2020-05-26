import static org.junit.Assert.*;

import org.junit.*; 

public class CollinearTest 
{
	
	
	
	@Test
	public void testCountCollinear() 
	{
		//Set up data to test: an unsorted array
		int[] a1 = new int[] {3,2,1}; //array of size N = 3
		int[] a2 = new int[] {2,3,1}; //array of size N = 3
		int[] a3 = new int[] {1,3,2}; //array of size N = 3
		
		//Run Method
		int count = Collinear.countCollinear(a1,a2,a3);
		
		//Test
		assertEquals(5, count);
		assertNotEquals(0, count);
		assertNotEquals(7, count);
		
	}
	
	public void testCountCollinearFast() 
	{
		//Set up data to test: an unsorted array
				int[] a1 = new int[] {3,2,1}; //array of size N = 3
				int[] a2 = new int[] {2,3,1}; //array of size N = 3
				int[] a3 = new int[] {1,3,2}; //array of size N = 3
				
				//Run Method
				int count = Collinear.countCollinearFast(a1,a2,a3);
				
				//Test
				assertEquals(5, count);
				assertNotEquals(0, count);
				assertNotEquals(6, count);
	}
	
	public void testSort() 
	{
		//Set up data to test: an unsorted array
		int[] testArray = new int[] {5,10,4,3,2,1}; //array of size N = 6
		
		//Run Method
		Collinear.sort(testArray);
		
		//Test
		assertEquals(1, testArray[0]);
		assertEquals(2, testArray[1]);
		assertEquals(3, testArray[2]);
		assertEquals(4, testArray[3]);
		assertEquals(5, testArray[4]);
		assertEquals(10, testArray[5]);	
		
		assertNotEquals(5, testArray[0]);
		assertNotEquals(10, testArray[1]);
		assertNotEquals(1, testArray[5]);
	}
	
	public void testBinarySearch() 
	{
		//Set up data to test: a sorted array
		int[] testArray = new int[] {5,13,54,23,76}; //array of size N = 5
		Collinear.sort(testArray);
					
		//Test
		assertTrue(Collinear.binarySearch(testArray,5));
		assertFalse(Collinear.binarySearch(testArray,6));
		
		assertTrue(Collinear.binarySearch(testArray,13));
		assertFalse(Collinear.binarySearch(testArray,12));
		
		assertTrue(Collinear.binarySearch(testArray,54));
		assertFalse(Collinear.binarySearch(testArray,55));
		
		assertTrue(Collinear.binarySearch(testArray,23));
		assertFalse(Collinear.binarySearch(testArray,28));
		
		assertTrue(Collinear.binarySearch(testArray,76));
		assertFalse(Collinear.binarySearch(testArray,1));					
	}
	
	
	

}
