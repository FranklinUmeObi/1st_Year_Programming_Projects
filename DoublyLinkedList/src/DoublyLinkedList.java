import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Franklin Ume Obiekwe :  18320505
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: O(3)
     *
     * Justification:
     *  We are comparing 2 variables to null and then returning either true or false
     */
    public boolean isEmpty()
    {
      if(head == null ) 
      {
    	  return true;
      }
      return false;
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: 3N
     *
     * Justification: In the add to tail case we call getSize which runs N times and in 
     * the normal case we call a get method that runs 2N times.
     *  
     */
    public void insertBefore( int pos, T data ) 
    {
    	DLLNode thisNode = null; 
        
      if(isEmpty()) //Empty Case
      {
    	  thisNode = new DLLNode(data, null, null);
    	  head = thisNode;
    	  tail = thisNode;
      }
      else if(pos <= 0)//Putting node at head
      {
    	  DLLNode oldHead = head;
    	  thisNode = new DLLNode(data, null, oldHead);
    	  oldHead.prev = thisNode;
    	  head = thisNode;
      }
      else if(pos >= getListSize())//Putting node at tail
      {
    	  DLLNode oldTail = tail;
    	  thisNode = new DLLNode(data, oldTail, null);
    	  oldTail.next = thisNode;
    	  tail = thisNode;
      }
      else//Putting node in normally
      {
    	  // DLLNode nodeToMoveForward = (DoublyLinkedList<T>.DLLNode) get(pos);
    	  DLLNode nodeToMoveForward = nodeToShift(pos);
    	  DLLNode theBefore = nodeToMoveForward.prev;
    	  thisNode = new DLLNode(data, theBefore, nodeToMoveForward);
    	  nodeToMoveForward.prev = thisNode;
    	  theBefore.next = thisNode;
    	  
      }
      return;
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: O(2N)
     *
     * Justification: The first  N comes from the while loop running until pos
     * is reached which in worst case is N times. The second N comes from the get List Size
     * 
     *  
     *
     */
    public T  get(int pos) 
    {
    	if(isEmpty()) return null;
    	if(pos < 0) return null;
    	if(pos > getListSize()-1) return null;
    	int nodePosition = 0;
    	DLLNode pointer = head;

    	while(nodePosition < pos )
    	{
    		pointer = pointer.next;
    		nodePosition++;
    	}
    	return    pointer.data;
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: O(4N)
     *
     * Justification: This method calls get list size twice  which has a run time of 2N in 
     * worse case scenario and nodeToShift which runs 2N times
     *  
     */
    public boolean deleteAt(int pos) 
    {
      if(pos < 0) return false; 
      if(pos >= getListSize()) return false;
  
	  	if(nodeToShift(pos) == null) return false;
	  	DLLNode nodeToRemove = nodeToShift(pos) ;
	  	DLLNode  nodeAfter = nodeToRemove.next;
	  	DLLNode nodePrev = nodeToRemove.prev;
	  	if(getListSize() == 1) // 1 node case
	  	{
	  		nodeToRemove = null;
	  		nodeAfter = null;
	  		nodePrev = null;
	  		head = null;
	  		tail = null;
	  	}
	  	else if(nodeAfter != null && nodePrev != null )// full case
	  	{
	  		nodeAfter.prev = nodePrev;
	  		nodePrev.next = nodeAfter;
	  	}
	  	else if(nodeToRemove == tail)// node was tail case
	  	{
	  		tail = nodePrev;
	  		nodePrev.next = null;
	  	}
	  	else if(nodeToRemove == head)// node was head case
	  	{
	  		head = nodeAfter;
	  		nodeAfter.prev = null;
	  	}
	  	return true;
  
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: //O(2N)
     *
     * Justification:  we call get size which is worst case N, and a while loop which runs N times
     *  
     */
    
     public void reverse()
    {
    	 if(isEmpty()) return;
    	 if(getListSize() == 1) return ;
    	 
    	 DLLNode tempStartNode = head; 
    	 head = tail;
    	 tail = tempStartNode;
    	 DLLNode pointer = head;
    	  while(pointer != null) 
    	   {
    		  tempStartNode=pointer.next; 
    	      pointer.next=pointer.prev;
    	      pointer.prev=tempStartNode;
    	      pointer = pointer.next;
    	   }
    }
     

 /*
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements unique.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: O(N( 2N + N ( 2N + 4N)))
     *
     * Justification: first while loop runs N times, in that loop we call get which runs 2N times,
     * and we have another while loop running N times and in that second loop we call 
     * get and delete which run 2N + 4N times.
     *  
     */
    public void makeUnique()
    {
    	 int i = 0 ;
    	 int j = 1 ;
    	 while( i < getListSize())
    	 {
    		 DLLNode nodeToCompare = nodeToShift(i) ;
    		 while( j < getListSize())
    		 {
    			 DLLNode nodeComparer = nodeToShift(j) ;
    			 if(nodeToCompare.data == nodeComparer.data)
    			 {
    				 deleteNode(nodeComparer);
    				 j--;
    			 }
    			 //end if
    			 j++;
    		 } 
    		 //end while2 
    		 i++;
    		 j=i+1;
      }
    	 //end while1
    }

     
     
     
     
     
     
     
     
     
     
     
     

    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: O(7)
     *
     * Justification:
     *  at maximum we run 7 lines of code
     */
    public void push(T item) 
    {
    	//DLLNode thisNode = (DoublyLinkedList<T>.DLLNode) item;
    	DLLNode thisNode = new DLLNode(item,null, null);
    	
    	 if(isEmpty()) //Empty Case
         {
       	  //thisNode = new DLLNode(thisNode.data, null, null);
       	  head = thisNode;
       	  tail = thisNode;
         }
    	 else
    	 {
    		 DLLNode oldHead = head;
    		 oldHead.prev = thisNode;
    		 head = thisNode;
    		 thisNode.next = oldHead;
    	 }
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: O(6N)
     *
     * Justification: nodetoshift runs N times and delete runs 4N times
     *  
     */
    public T pop() 
    {
    	if(isEmpty()) return null ;
    	DLLNode nodeToPop = nodeToShift(0);
    	deleteAt(0);
    	if(!isEmpty()) head = nodeToShift(0);
    	else head = null;
    	return nodeToPop.data;
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: O(6N)
     *
     * Justification:
     *  push has a run time of 6N
     */
    public void enqueue(T item) 
    {
      push(item);
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an enqueue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: 6N
     *
     * Justification: getlist size runs N times delete runs 4N times
     *  
     */
    public T dequeue() 
    {
    	if(isEmpty()) return null ;
    	else if(getListSize() == 1)
    	{
    		DLLNode nodeToPop = tail;
    		deleteNode(nodeToPop);
    		tail = null;
    		head = null;
    		return  nodeToPop.data;
    	}
    	else
    	{
    	DLLNode nodeToPop = tail;
    	DLLNode newTail = tail.prev;
    	deleteNode(nodeToPop);
    	tail = newTail;
    	return nodeToPop.data;
    	}
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }
    
    
    
    
    
    
    
    
    
    
    //-------------------------------------------------------------------------------------------------------------------
    //my methods
    int getListSize()
    {
    	if(isEmpty()) return 0 ;
    	int sizeOfList = 1;
    	if(head == tail) return 1;
    	DLLNode temptTail = tail;
    	while(temptTail.prev != null)
    	{
    		temptTail = temptTail.prev;
    		sizeOfList++;
    	}
    	
    	return sizeOfList;
    }
    
//----------------------------------------------------------------   
    DLLNode nodeToShift(int index)
    {
    	int nodePosition = 999;
    	if(!isEmpty()) nodePosition = 0;
    	else return null;
    	
    	DLLNode pointer = head;
    	if(index < 0) return null;
    	if(index > getListSize()+1) return null;
    	while(nodePosition < index )
    	{
    		//theNode = pointer;
    		pointer = pointer.next;
    		nodePosition++;
    	}
    	
    	return    pointer;
    }
    
//----------------------------------------------------------------   
    boolean deleteNode(DLLNode x)
    {
    	if(isEmpty()) return false;
    	if(x == null) return false;

    	
    	
    	DLLNode nodeToRemove = x;
        DLLNode nodeAfter = nodeToRemove.next;
        DLLNode nodePrev = nodeToRemove.prev;
        
        if(nodeAfter != null && nodePrev != null )// full case
	  	{
	  		nodeAfter.prev = nodePrev;
	  		nodePrev.next = nodeAfter;
	  	}
	  	else if(nodeToRemove == tail )// node was tail case
	  	{
	  		tail = nodePrev;
	  		if(nodePrev != null ) nodePrev.next = null;
	  	}
	  	else if(nodeToRemove == head)// node was head case
	  	{
	  		head = nodeAfter;
	  		if(nodeAfter != null )nodeAfter.prev = null;
	  	}
        return true ;
    }
    
}

