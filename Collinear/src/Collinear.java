// -------------------------------------------------------------------------
/**
 *  This class contains only two static methods that search for points on the
 *  same line in three arrays of integers. 
 *
 *  @author franklin ume obiekwe : 18320505 
 *  @version 18/09/18 12:21:09
 */
class Collinear
{

   // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
     * A non-horizontal line will have to cross all three of these lines. Thus
     * we are looking for 3 points, each in a1, a2, a3 which lie on the same
     * line.
     *
     * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
     * 
     * x1(y2âˆ’y3)+x2(y3âˆ’y1)+x3(y1âˆ’y2)=0 
     *
     * In our case y1=1, y2=2, y3=3.
     *
     * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)
     *
     * ----------------------------------------------------------
     *
     * 
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of growth: N^3
     *
     *  Explanation: its a for loop looping N-2 times in a for loop looping 
     *  N-1 times in a for loop looping N times in, therefore (N*N*N) if N tends to infinity
     *   
     */
    static int countCollinear(int[] a1, int[] a2, int[] a3)
    {
    	int count = 0;
        for (int i = 0 ;i< a1.length ; i++ )
        {
          for (int j = 0 ;j< a1.length ; j++ )
          {
            for (int k = 0 ;k< a1.length ; k++ )
            {
              if ((a1[i] * (2 - 3)) +  (a2[j] * (3 - 1)) +  (a3[k] * (1 - 2)) == 0)
              {
                count++;
              }
            }
          }
        }
        return count;
    }

    // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
     * The performance of this method should be much better than that of the above method.
     *
     *
     *  Order of Growth: N^2+(N^2LogN)
     *
     *  Explanation: N^2 from sort + (N^2 from loops * LogN from binarysearch)
     *
     *
     */
    static int countCollinearFast(int[] a1, int[] a2, int[] a3)
    {
      int count = 0;
      sort(a3);
      for (int i = 0 ;i< a1.length ; i++ )
      {
        for (int j = 0 ;j< a1.length ; j++ )
        {
        	int numToFind = (-a1[i]) + (2 * a2[j]) ; //the third number to binary search for: derived from original collinear equation
        	
        	if (binarySearch(a3, numToFind))
            {
              count++;
            }
        }
      }
      return count;
    }

    // ----------------------------------------------------------
    /**
     * Sorts an array of integers according to InsertionSort.
     * This method is static, thus it can be called as Collinear.sort(a)
     * @param a: An UNSORTED array of integers. 
     * @return after the method returns, the array must be in ascending sorted order.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: N^2
     *
     *  Explanation: Two linear for-loops.
     *
     */
    static void sort(int[] a)
    {
      for ( int j = 1; j<a.length; j++)
      {
        int i = j - 1;
        while(i>=0 && a[i]>a[i+1])
        {
          int temp = a[i];
          a[i] = a[i+1];
          a[i+1] = temp;
          i--;
        }
      }
    }

    // ----------------------------------------------------------
    /**
     * Searches for an integer inside an array of integers.
     * This method is static, thus it can be called as Collinear.binarySearch(a,x)
     * @param a: A array of integers SORTED in ascending order.
     * @param x: An integer.
     * @return true if 'x' is contained in 'a'; false otherwise.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: LogN
     *
     *  Explanation: The order of growth is logarithmic as we are cutting n in half every loop
     *
     */
    static boolean binarySearch(int[] a, int x)
    {
    	//This code doesn't belong to me, it was found on the lecture slides found at
        //https://www.scss.tcd.ie/Vasileios.Koutavas/teaching/csu22010/s1-2019-20/data/uploads/lecture4.pdf
        int lo = 0, hi = a.length-1;
        while (lo <= hi)
        {
          int mid = lo + (hi - lo) / 2;
          if (x < a[mid]) hi = mid - 1;
          else if (x > a[mid]) lo = mid + 1;
          else return true;
        }
        return false;
    }

}
