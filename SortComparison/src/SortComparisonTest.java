/* 											|	Insertion			Selection		QuickSort		MergeIter		MergeRecur
 * 	---------------------------------------------------------------------------------------------------------------------------------|
 * 10Random						|  	10.61283		|	0.3526		|	0.32096		|	0.37816		|	0.14846
 * 	---------------------------------------------------------------------------------------------------------------------------------|
 * 100Random					|  	7.23996		|	1.1847			|	0.99089		|	0.84573		|	0.4032
 * 	---------------------------------------------------------------------------------------------------------------------------------|
 * 1000Random					|  	23.4596	 	|	11.17936		|	6.40256		|	4.34243		|	2.09
 * 	---------------------------------------------------------------------------------------------------------------------------------|
 * 1000FewUnique			|  	9.3339		|	8.45693		|	6.53726		|	6.2977			|	2.15173
 * 	---------------------------------------------------------------------------------------------------------------------------------|
 * 1000NearlyOrdered		|  	7.9568		|	5.13443		|	5.52716		|	4.9322		|	2.03673
 * 	---------------------------------------------------------------------------------------------------------------------------------|
 * 1000ReverseOrder		|  	9.20726		|	10.2097		|	4.00106		|	4.93803		|	2.3589
 * 	---------------------------------------------------------------------------------------------------------------------------------|
 * 1000Sorted					|  	8.39646		|	5.38916		|	3.96626		|	2.1882			|	2.02213
 *	---------------------------------------------------------------------------------------------------------------------------------|
 * 
 * Questions:
 * a. Which of the sorting algorithms does the order of input have an impact on? Why?
 * 
 * 	Ans: QuickSort, More elements need to be moved
 * ------------------------------------------------------------------------
 * 
 * b. Which algorithm has the biggest difference between the best and worst performance, based
on the type of input, for the input of size 1000? Why?
 * 
 * Ans: Insertion Sort, Best case is O( N )
 * ------------------------------------------------------------------------
 * 
 * c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
based on the input size? Please consider only input files with random order for this answer.
 * 
 * Ans: Recursive Merge
 * ------------------------------------------------------------------------
 * 
 * d. Did you observe any difference between iterative and recursive implementations of merge
sort?
 * 
 * Ans: Yes the recursive implementation is ~ twice as fast
 * ------------------------------------------------------------------------
 * 
 * e. Which algorithm is the fastest for each of the 7 input files?
 * 
 * Ans: Recursive Merge Sort
 * ------------------------------------------------------------------------
 */



import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    
   // @Test
  //  public void testEmpty()
  //  {   	
  //  }
    
    @Test
	public void testInsertionSort() {
    	double a[] = {6,5,4,7,2,1,3};
    	double b[] = {};
    	double c[] = {-1, 0, 2};
    	double d[] = {5, 5, 2, 3, 3};
    	double e[] = {99};
    	
    	double aSorted[] = {1,2,3,4,5,6,7};
    	double bSorted[] = {};
    	double cSorted[] = {-1, 0, 2};
    	double dSorted[] = {2,3,3,5,5};
    	double eSorted[] = {99};
    	
    	assertTrue(Arrays.equals(aSorted, SortComparison.insertionSort(a)));
    	assertTrue(Arrays.equals(bSorted, SortComparison.insertionSort(b)));
    	assertTrue(Arrays.equals(cSorted, SortComparison.insertionSort(c)));
    	assertTrue(Arrays.equals(dSorted, SortComparison.insertionSort(d)));
    	assertTrue(Arrays.equals(eSorted, SortComparison.insertionSort(e)));

	}

	@Test
	public void testSelectionSort() {
		double a[] = {6,5,4,7,2,1,3};
    	double b[] = {};
    	double c[] = {-1, 0, 2};
    	double d[] = {5, 5, 2, 3, 3};
    	double e[] = {99};
    	
    	double aSorted[] = {1,2,3,4,5,6,7};
    	double bSorted[] = {};
    	double cSorted[] = {-1, 0, 2};
    	double dSorted[] = {2,3,3,5,5};
    	double eSorted[] = {99};
    	
    	assertTrue(Arrays.equals(aSorted, SortComparison.selectionSort(a)));
    	assertTrue(Arrays.equals(bSorted, SortComparison.selectionSort(b)));
    	assertTrue(Arrays.equals(cSorted, SortComparison.selectionSort(c)));
    	assertTrue(Arrays.equals(dSorted, SortComparison.selectionSort(d)));
    	assertTrue(Arrays.equals(eSorted, SortComparison.selectionSort(e)));
	}

	@Test
	public void testQuickSort() {
		double a[] = {6,5,4,7,2,1,3};
    	double b[] = {};
    	double c[] = {-1, 0, 2};
    	double d[] = {5, 5, 2, 3, 3};
    	double e[] = {99};
    	
    	double aSorted[] = {1,2,3,4,5,6,7};
    	double bSorted[] = {};
    	double cSorted[] = {-1, 0, 2};
    	double dSorted[] = {2,3,3,5,5};
    	double eSorted[] = {99};
    	
    	assertTrue(Arrays.equals(aSorted, SortComparison.quickSort(a)));
    	assertTrue(Arrays.equals(bSorted, SortComparison.quickSort(b)));
    	assertTrue(Arrays.equals(cSorted, SortComparison.quickSort(c)));
    	assertTrue(Arrays.equals(dSorted, SortComparison.quickSort(d)));
    	assertTrue(Arrays.equals(eSorted, SortComparison.quickSort(e)));
	}

	@Test
	public void testMergeSortIterative() {
		double a[] = {6,5,4,7,2,1,3};
    	double b[] = {};
    	double c[] = {-1, 0, 2};
    	double d[] = {5, 5, 2, 3, 3};
    	double e[] = {99};
    	
    	double aSorted[] = {1,2,3,4,5,6,7};
    	double bSorted[] = {};
    	double cSorted[] = {-1, 0, 2};
    	double dSorted[] = {2,3,3,5,5};
    	double eSorted[] = {99};
    	
    	assertTrue(Arrays.equals(aSorted, SortComparison.mergeSortIterative(a)));
    	assertTrue(Arrays.equals(bSorted, SortComparison.mergeSortIterative(b)));
    	assertTrue(Arrays.equals(cSorted, SortComparison.mergeSortIterative(c)));
    	assertTrue(Arrays.equals(dSorted, SortComparison.mergeSortIterative(d)));
    	assertTrue(Arrays.equals(eSorted, SortComparison.mergeSortIterative(e)));
	}

	@Test
	public void testMergeSortRecursive() {
		double a[] = {6,5,4,7,2,1,3};
    	double b[] = {};
    	double c[] = {-1, 0, 2};
    	double d[] = {5, 5, 2, 3, 3};
    	double e[] = {99};
    	
    	double aSorted[] = {1,2,3,4,5,6,7};
    	double bSorted[] = {};
    	double cSorted[] = {-1, 0, 2};
    	double dSorted[] = {2,3,3,5,5};
    	double eSorted[] = {99};
    	
    	assertTrue(Arrays.equals(aSorted, SortComparison.mergeSortRecursive(a)));
    	assertTrue(Arrays.equals(bSorted, SortComparison.mergeSortRecursive(b)));
    	assertTrue(Arrays.equals(cSorted, SortComparison.mergeSortRecursive(c)));
    	assertTrue(Arrays.equals(dSorted, SortComparison.mergeSortRecursive(d)));
    	assertTrue(Arrays.equals(eSorted, SortComparison.mergeSortRecursive(e)));
	}


    // --------------------------------------------------------------------------------------------------------------------------
	
	// --------------------------------------------------------------------------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     * @throws FileNotFoundException 
     *
     */
	
	public static double[] arrayToSort(String txt, int N) throws FileNotFoundException {
		double a[] = new double[N];
		File myFile = new File (txt);
		Scanner myScan = new Scanner(myFile);

		while (myScan.hasNext()) 
		{
			int i = 0;
		    String num = myScan.nextLine();
		    Scanner scanner = new Scanner(num);
		    a[i++] = Double.parseDouble(num); 
		}
		myScan.close();
		return a;
	}
		
	
    public static void main(String[] args) throws FileNotFoundException
    {
    	String text1 = "C:\\College\\2nd Year Trinity\\Algos\\Sem1 Ass1 input\\numbers10.txt";
    	String text2 = "C:\\College\\2nd Year Trinity\\Algos\\Sem1 Ass1 input\\numbers100.txt";
    	String text3 = "C:\\College\\2nd Year Trinity\\Algos\\Sem1 Ass1 input\\numbers1000.txt";
    	String text4 = "C:\\College\\2nd Year Trinity\\Algos\\Sem1 Ass1 input\\numbers1000Duplicates.txt";
    	String text5 = "C:\\College\\2nd Year Trinity\\Algos\\Sem1 Ass1 input\\numbersNearlyOrdered1000.txt";
    	String text6 = "C:\\College\\2nd Year Trinity\\Algos\\Sem1 Ass1 input\\numbersReverse1000.txt";
    	String text7 = "C:\\College\\2nd Year Trinity\\Algos\\Sem1 Ass1 input\\numbersSorted1000.txt";
    	String files[] = {text1, text2, text3, text4, text5, text6, text7};
    	double a[] = new double[10];
    	double b[] = new double[100];
    	double c[] = new double[1000];
    	double d[] = new double[1000];
    	double e[] = new double[1000];
    	double f[] = new double[1000];
    	double g[] = new double[1000];
    	int nums[] = {10, 100, 1000, 1000, 1000, 1000, 1000};
    	
    	
//-----------------------------------------------------------------------------------------------------
    	
    	//Insertion Sort
    	System.out.println("Insertion");
    	int sum = 0;
    	for(int i = 0; i < files.length; i++)
    	{
    		long startTime = System.nanoTime();
        	SortComparison.insertionSort(arrayToSort(files[i], nums[i]));
        	long endTime = System.nanoTime();
        	long duration = (endTime - startTime);
        	double time1 = duration/1000000.0;
        	
        	long startTime2 = System.nanoTime();
        	SortComparison.insertionSort(arrayToSort(files[i], nums[i]));
        	long endTime2 = System.nanoTime();
        	long duration2 = (endTime2 - startTime2);
        	double time2 = duration2/1000000.0;
        	
        	long startTime3 = System.nanoTime();
        	SortComparison.insertionSort(arrayToSort(files[i], nums[i]));
        	long endTime3 = System.nanoTime();
        	long duration3 = (endTime3 - startTime3);
        	double time3 = duration3/1000000.0;
        	
        	double avgTime = (time1 + time2 + time3) / 3;
        	System.out.println(avgTime);
    	}
    	
    	
    	//Selection Sort
    	System.out.println("\n Selection ");
    	for(int i = 0; i < files.length; i++)
    	{
    		long startTime = System.nanoTime();
        	SortComparison.selectionSort(arrayToSort(files[i], nums[i]));
        	long endTime = System.nanoTime();
        	long duration = (endTime - startTime);
        	double time1 = duration/1000000.0;
        	
        	long startTime2 = System.nanoTime();
        	SortComparison.selectionSort(arrayToSort(files[i], nums[i]));
        	long endTime2 = System.nanoTime();
        	long duration2 = (endTime2 - startTime2);
        	double time2 = duration2/1000000.0;
        	
        	long startTime3 = System.nanoTime();
        	SortComparison.selectionSort(arrayToSort(files[i], nums[i]));
        	long endTime3 = System.nanoTime();
        	long duration3 = (endTime3 - startTime3);
        	double time3 = duration3/1000000.0;
        	
        	double avgTime = (time1 + time2 + time3) / 3;
        	System.out.println(avgTime + " miliseconds");
    	}
    	
    	
    	//Quick Sort
    	System.out.println("\n Quick");
    	for(int i = 0; i < files.length; i++)
    	{
    		long startTime = System.nanoTime();
        	SortComparison.quickSort(arrayToSort(files[i], nums[i]));
        	long endTime = System.nanoTime();
        	long duration = (endTime - startTime);
        	double time1 = duration/1000000.0;
        	
        	long startTime2 = System.nanoTime();
        	SortComparison.quickSort(arrayToSort(files[i], nums[i]));
        	long endTime2 = System.nanoTime();
        	long duration2 = (endTime2 - startTime2);
        	double time2 = duration2/1000000.0;
        	
        	long startTime3 = System.nanoTime();
        	SortComparison.quickSort(arrayToSort(files[i], nums[i]));
        	long endTime3 = System.nanoTime();
        	long duration3 = (endTime3 - startTime3);
        	double time3 = duration3/1000000.0;
        	
        	double avgTime = (time1 + time2 + time3) / 3;
        	System.out.println(avgTime);
    	}
    	
    	
    	//Merge Iter Sort
    	System.out.println("\n Merge Iteration");
    	for(int i = 0; i < files.length; i++)
    	{
    		long startTime = System.nanoTime();
        	SortComparison.mergeSortIterative(arrayToSort(files[i], nums[i]));
        	long endTime = System.nanoTime();
        	long duration = (endTime - startTime);
        	double time1 = duration/1000000.0;
        	
        	long startTime2 = System.nanoTime();
        	SortComparison.mergeSortIterative(arrayToSort(files[i], nums[i]));
        	long endTime2 = System.nanoTime();
        	long duration2 = (endTime2 - startTime2);
        	double time2 = duration2/1000000.0;
        	
        	long startTime3 = System.nanoTime();
        	SortComparison.mergeSortIterative(arrayToSort(files[i], nums[i]));
        	long endTime3 = System.nanoTime();
        	long duration3 = (endTime3 - startTime3);
        	double time3 = duration3/1000000.0;
        	
        	double avgTime = (time1 + time2 + time3) / 3;
        	System.out.println(avgTime);
    	}
    	
    	
    	//Merge Recur Sort
    	System.out.println("\n Merge Recursive");
    	for(int i = 0; i < files.length; i++)
    	{
    		long startTime = System.nanoTime();
        	SortComparison.mergeSortRecursive(arrayToSort(files[i], nums[i]));
        	long endTime = System.nanoTime();
        	long duration = (endTime - startTime);
        	double time1 = duration/1000000.0;
        	
        	long startTime2 = System.nanoTime();
        	SortComparison.mergeSortRecursive(arrayToSort(files[i], nums[i]));
        	long endTime2 = System.nanoTime();
        	long duration2 = (endTime2 - startTime2);
        	double time2 = duration2/1000000.0;
        	
        	long startTime3 = System.nanoTime();
        	SortComparison.mergeSortRecursive(arrayToSort(files[i], nums[i]));
        	long endTime3 = System.nanoTime();
        	long duration3 = (endTime3 - startTime3);
        	double time3 = duration3/1000000.0;
        	
        	double avgTime = (time1 + time2 + time3) / 3;
        	System.out.println(avgTime);
    	}
  
    }

}


