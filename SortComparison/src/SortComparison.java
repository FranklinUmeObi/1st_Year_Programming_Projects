// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Franklin
 *  @version HT 2020
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[])
    {
    	int length = a.length; 
        for (int i = 1; i < length; ++i) 
        { 
        	double numToSort = a[i]; 
            int leftIndex = i - 1; 
            while (leftIndex >= 0 && a[leftIndex] > numToSort) 
            { 
                a[leftIndex + 1] = a[leftIndex]; 
                leftIndex = leftIndex - 1; 
            } 
            a[leftIndex + 1] = numToSort; 
        } 
        return a;
    }//end insertion sort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[])
    {
    	int length = a.length; 
    	
        for (int i = 0; i < length-1; i++) 
        { 
            int minIndex = i; 
            for (int j = i+1; j < length; j++) 
            {
            	if (a[j] < a[minIndex])  minIndex = j;
            }	 
            double temp = a[minIndex]; 
            a[minIndex] = a[i]; 
            a[i] = temp; 
        } 
        return a;
    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [ ] quickSort (double a[ ]){
    	int startIndex = 0;
    	int endIndex = a.length - 1;
    	sortInQuick(a, startIndex, endIndex) ;
    	return a;
    }//end quick sort
    static int partition(double a[ ], int startIndex, int endIndex) 
    { 
        double pivot = a[endIndex];
        int i = (startIndex-1); 
        for (int j = startIndex; j < endIndex; j++) 
        { 
            if (a[ j ] < pivot) 
            { 
                i++; 
                double temp = a[i]; 
                a[ i ] = a[ j ]; 
                a[ j ] = temp; 
            } 
        } 
        double temp = a[ i+1 ]; 
        a[ i+1 ] = a[endIndex]; 
        a[endIndex] = temp; 
  
        return i+1; 
    } 
    static void sortInQuick(double array[], int startIndex, int endIndex) 
    { 
        if (startIndex < endIndex) 
        { 
            int partitionIndex = partition(array, startIndex, endIndex); 
            sortInQuick(array, startIndex, partitionIndex-1); 
            sortInQuick(array, partitionIndex+1, endIndex); 
        } 
    }
    
    
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) 
    {
    	int N = a.length;
    	double aux[ ] = new double[N];
    	
    	for (int size = 1; size < N; size = size + size) 
    	{
    		for (int lo = 0; lo < N-size; lo += size + size) 
    		{
    			
    			merge(a, aux, lo, lo+size-1, Math.min(lo + size + size - 1,  N-1));
    		}
    	}
    	return a;
    }	//end merge sort Iterative
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) 
    {
    	double aux[] = new double[a.length];
    	sort(a, aux, 0, a.length-1) ;
    	return a;
   }	//end mergeSortRecursive
 
    
    static void merge(double array[ ], double aux[], int startIndex, int midIndex, int endIndex) 
    { 
    	for( int k = startIndex; k <= endIndex; k++) aux[k] = array[k];
	    
    	int i = startIndex, j = midIndex + 1;
	    for (int k = startIndex; k  <= endIndex;  k++) 
	    {
			if			( i > midIndex) 				array[k] = aux[ j++ ];
			else if ( j > endIndex) 				array[k] = aux[ i++ ];
			else if	( aux[j] <= aux[i]) 	array[k] = aux[ j++ ];
			else 							 				array[k] = aux[ i++ ];
		}
    }
    static void sort(double array[ ], double aux[], int startIndex, int endIndex)
    {
    	if ( endIndex <= startIndex) return;
    	int mid = startIndex + (endIndex - startIndex) / 2;
    	sort ( array, aux, startIndex, mid);
    	sort ( array, aux, mid + 1, endIndex);
    	merge(array, aux, startIndex, mid, endIndex);
    }
    
//---- My Methods ----------------------------------------------------------------------------------------
    public static void printArray(double a[])
    {
    	for (int i = 0; i < a.length; i++) System.out.print(a[i]+ ", ");
    	System.out.print( "\n");
    }
    
    public static void testInsert()
    {
    	System.out.print( "InsertionSort \n");
    	double a[] = {6,5,4,7,2,1,3};
        printArray(a);
        double aSort[] = insertionSort(a);
        printArray(aSort);
        System.out.print( "\n");
    }
    public static void testSelection()
    {
    	System.out.print( "SelectionSort \n");
    	double a[] = {6,5,4,7,2,1,3};
        printArray(a);
        double aSort[] = selectionSort(a);
        printArray(aSort);
        System.out.print( "\n");
    }
    public static void testQuick()
    {
    	System.out.print( "QuickSort \n");
    	double a[] = {6,5,4,7,2,1,3};
        printArray(a);
        double aSort[] = quickSort(a);
        printArray(aSort);
        System.out.print( "\n");
    }
    public static void testMergeIter()
    {
    	System.out.print( "MergeSort Iterative \n");
    	double a[] = {6,5,4,7,2,1,3};
        printArray(a);
        double aSort[] = mergeSortIterative(a);
        printArray(aSort);
        System.out.print( "\n");
    }
    public static void testMergeRecur()
    {
    	System.out.print( "MergeSort Recursive \n");
    	double a[] = {6,5,4,7,2,1,3};
        printArray(a);
        double aSort[] = mergeSortRecursive(a);
        printArray(aSort);
        System.out.print( "\n");
    }

    public static void main(String[] args) 
    {
    	testInsert();
    	testSelection();
    	testQuick();
    	testMergeIter();
    	testMergeRecur();
    }

 }//end class

