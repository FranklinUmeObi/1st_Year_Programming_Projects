//Test3 tests if there is an intersection that can not be reached
//Test4 has negative numbers and 0
//Test99 doesn't exist
//Test100 is empty


/*
 * For My Dijkstra's Implementation, I used Dijkstra's implementation,  which when given a source, 
 * finds all the shortest paths to the other vertices. It does this by using to sets of vertices, visited and not visited.
 * When we visit a node we update the distances to its adjacent vertices if it is quicker to go via the current node.
 * when every node has been marked as visited i then return the longest distance and add it to an array of distances.
 * I repeat this for every vertex of the graph. This is not particularly efficient as you have to reset variables and sets.
 * The runtime of this method is O(V3)
 * 
 * For the Flloyd Warshall Algorithm is for solving the All Pairs Shortest Path problem. The problem 
 * is to find shortest distances between every pair of vertices in a given edge weighted directed Graph.
 * This is much more efficient for his problem we are using the algorithm just once and returning the largest number.
 * This is also O(V3) but there's less work with variables and resetting and uses less storage space, therefore that makes
 * this algorithm superior to Dijkstra for this assignment
 */




import static org.junit.Assert.*;

import org.junit.Test;

public class CompetitionTests {

    @Test
    public void testDijkstraConstructor()
    {
    
    	CompetitionDijkstra test1 = new CompetitionDijkstra("input-B.txt" , 50, 80, 60);
    	assertNotEquals(-1,test1.timeRequiredforCompetition());
    	CompetitionDijkstra test2 = new CompetitionDijkstra("input-C.txt" , 50, 80, 60);
    	assertEquals(-1,test2.timeRequiredforCompetition());
    	/*
    	CompetitionDijkstra test3 = new CompetitionDijkstra("input-I.txt" , 60, 70, 84);
    	assertEquals(200,test3.timeRequiredforCompetition());
    	CompetitionDijkstra test4 = new CompetitionDijkstra("input-I.txt" , 70, 72, 65);
    	assertEquals(185,test4.timeRequiredforCompetition());
    	*/
    	CompetitionDijkstra test = new CompetitionDijkstra("Test.txt" , 50, 80, 60);
    	assertEquals(38,test.timeRequiredforCompetition());
    	CompetitionDijkstra testA = new CompetitionDijkstra("Test.txt" , 60, 70, 80);
    	assertEquals(31,testA.timeRequiredforCompetition());
    	CompetitionDijkstra testB = new CompetitionDijkstra("Test.txt" , 70, 51, 60);
    	assertNotEquals(-1,testB.timeRequiredforCompetition());
    	CompetitionDijkstra testC = new CompetitionDijkstra("Test.txt" , 60, 90, 80);
    	assertNotEquals(-1,testC.timeRequiredforCompetition());
    	//CompetitionDijkstra testD = new CompetitionDijkstra("Test2.txt" , 60, 51, 90);
    	//assertNotEquals(-1,testD.timeRequiredforCompetition());
    	
    	CompetitionDijkstra testE = new CompetitionDijkstra("Test3.txt" , 90, 90, 90);
    	assertEquals(-1,testE.timeRequiredforCompetition());
    	CompetitionDijkstra testF = new CompetitionDijkstra("Test.txt" , 9, 90, 90);
    	assertEquals(-1,testF.timeRequiredforCompetition());
    	CompetitionDijkstra testG = new CompetitionDijkstra("Test.txt" , 90, 9, 90);
    	assertEquals(-1,testG.timeRequiredforCompetition());
    	CompetitionDijkstra testH = new CompetitionDijkstra("Test.txt" , 90, 90, 9);
    	assertEquals(-1,testH.timeRequiredforCompetition());
    	CompetitionDijkstra testI = new CompetitionDijkstra("Test.txt" , 119, 90, 90);
    	assertEquals(-1,testI.timeRequiredforCompetition());
    	CompetitionDijkstra testJ = new CompetitionDijkstra("Test.txt" , 90, 119, 90);
    	assertEquals(-1,testJ.timeRequiredforCompetition());
    	CompetitionDijkstra testK = new CompetitionDijkstra("Test.txt" , 90, 90, 119);
    	assertEquals(-1,testK.timeRequiredforCompetition());
    	CompetitionDijkstra testL= new CompetitionDijkstra("Test99.txt" , 90, 90, 80);
    	assertEquals(-1,testL.timeRequiredforCompetition());
    	CompetitionDijkstra testM= new CompetitionDijkstra("Test100.txt" , 90, 90, 80);
    	assertEquals(-1,testM.timeRequiredforCompetition());
    	CompetitionDijkstra testN= new CompetitionDijkstra("" , 90, 90, 80);
    	assertEquals(-1,testN.timeRequiredforCompetition());
    	CompetitionDijkstra testO= new CompetitionDijkstra(null , 90, 90, 80);
    	assertEquals(-1,testO.timeRequiredforCompetition());
    	CompetitionDijkstra testP= new CompetitionDijkstra("Test4.txt", 90, 90, 80);
    	assertEquals(-1,testP.timeRequiredforCompetition());
    	
    	
    }

    @Test
    public void testFWConstructor()  {
    	CompetitionFloydWarshall test1 = new CompetitionFloydWarshall("input-B.txt" , 50, 80, 60);
    	assertNotEquals(-1,test1.timeRequiredforCompetition());
    	CompetitionFloydWarshall test2 = new CompetitionFloydWarshall("input-C.txt" , 50, 80, 60);
    	assertEquals(-1,test2.timeRequiredforCompetition());
    	
    	CompetitionFloydWarshall test3 = new CompetitionFloydWarshall("input-I.txt" , 60, 70, 84);
    	assertEquals(200,test3.timeRequiredforCompetition());
    	CompetitionFloydWarshall test4 = new CompetitionFloydWarshall("input-I.txt" , 70, 72, 65);
    	assertEquals(185,test4.timeRequiredforCompetition());

    	CompetitionFloydWarshall testA = new CompetitionFloydWarshall("Test.txt" , 50, 60, 70);
    	assertEquals(38,testA.timeRequiredforCompetition());
    	CompetitionFloydWarshall testB = new CompetitionFloydWarshall("Test.txt" , 70, 51, 60);
    	assertNotEquals(-1,testB.timeRequiredforCompetition());
    	CompetitionFloydWarshall testC = new CompetitionFloydWarshall("Test.txt" , 60, 90, 80);
    	assertNotEquals(-1,testC.timeRequiredforCompetition());
    	//CompetitionFloydWarshall testD = new CompetitionFloydWarshall("Test2.txt" , 60, 51, 90);
    	//assertNotEquals(-1,testD.timeRequiredforCompetition());
    	CompetitionFloydWarshall testE = new CompetitionFloydWarshall("Test3.txt" , 90, 90, 90);
    	assertEquals(-1,testE.timeRequiredforCompetition());
    	CompetitionFloydWarshall testF = new CompetitionFloydWarshall("Test.txt" , 9, 90, 90);
    	assertEquals(-1,testF.timeRequiredforCompetition());
    	CompetitionFloydWarshall testG = new CompetitionFloydWarshall("Test.txt" , 90, 9, 90);
    	assertEquals(-1,testG.timeRequiredforCompetition());
    	CompetitionFloydWarshall testH = new CompetitionFloydWarshall("Test.txt" , 90, 90, 9);
    	assertEquals(-1,testH.timeRequiredforCompetition());
    	CompetitionFloydWarshall testI = new CompetitionFloydWarshall("Test.txt" , 119, 90, 90);
    	assertEquals(-1,testI.timeRequiredforCompetition());
    	CompetitionFloydWarshall testJ = new CompetitionFloydWarshall("Test.txt" , 90, 119, 90);
    	assertEquals(-1,testJ.timeRequiredforCompetition());
    	CompetitionFloydWarshall testK = new CompetitionFloydWarshall("Test.txt" , 90, 90, 119);
    	assertEquals(-1,testK.timeRequiredforCompetition());
    	CompetitionFloydWarshall testL= new CompetitionFloydWarshall("Test99.txt" , 90, 90, 80);
    	assertEquals(-1,testL.timeRequiredforCompetition());
    	CompetitionFloydWarshall testM= new CompetitionFloydWarshall("Test100.txt" , 90, 90, 80);
    	assertEquals(-1,testM.timeRequiredforCompetition());
    	CompetitionFloydWarshall testN= new CompetitionFloydWarshall("" , 90, 90, 80);
    	assertEquals(-1,testN.timeRequiredforCompetition());
    	CompetitionFloydWarshall testO= new CompetitionFloydWarshall(null , 90, 90, 80);
    	assertEquals(-1,testO.timeRequiredforCompetition());
    	CompetitionFloydWarshall testP= new CompetitionFloydWarshall("Test4.txt", 90, 90, 80);
    	assertEquals(-1,testP.timeRequiredforCompetition());
    	
    	
    }
    
    
}