
//@Author : Franklin Ume Obiekwe

import java.io.*;
import java.util.*;

public class CompetitionDijkstra {

	double[][] graph; // Adjacency matrix
	int V;
	int E;
	int slowestWalkSpeed;
	boolean speedError;

	ArrayList<Double> vertices;
	ArrayList<Boolean> shortestPathSet;
	ArrayList<Road> graphAsEdges;

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 */
	CompetitionDijkstra(String filename, int sA, int sB, int sC) {
		try 
		{ 
			if (sA < 50 || sB < 50 || sC < 50 || sA > 100 || sB > 100 || sC > 100) speedError = true;
			else speedError = false;
	
			List<String> data = fileToArray(filename);
			if (data.size() < 3) {
				speedError = true;
				return;
			}

			graphAsEdges = new ArrayList<Road>(); // ARRAY TO CONTAIN EDGE OBJECTS
			vertices = new ArrayList<Double>(); // ARRAY TO CONTAIN VERTICES
			shortestPathSet = new ArrayList<Boolean>(); // ARRAY TO MARK WHAT VERTICES ARE IN OUR PATH

			V = Integer.parseInt(data.get(0)); // NUM VERTICES
			E = Integer.parseInt(data.get(1)); // NUM EDGES
			
			if (V < 1 || E < 1) {
				speedError = true;
				return;
			}

			graph = new double[V][V]; // SQUARE MATRIX

			for (int i = 2; i < data.size(); i++) // FOR EACH EDGE IN FILE
			{
				String s = data.get(i); // GET EDGE
				double[] road = roadInfo(s); // EDGE STRING TO Double ARRAY
				Road x = new Road(road[0], road[1], road[2]); // CREATE A ROAD FROM LINE
				graphAsEdges.add(x); // ADD ROAD TO GRAPHASEDGES
			}

			int slow;
			if (sA < sB)	slow = sA;
			else slow = sB;
			if (slow > sC)	slow = sC;
			slowestWalkSpeed = slow;

			for (Road x : graphAsEdges) {
				if (!vertices.contains(x.start))
					vertices.add(x.start);
			}
			for (Road x : graphAsEdges) {
				if (!vertices.contains(x.end))
					vertices.add(x.end);
			}

			
			
			
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					graph[i][j] = 0; // Set adjacency matrix to all equal 0
				}
			}

			for (int i = 0; i < graphAsEdges.size(); i++) {
				int a = vertices.indexOf(graphAsEdges.get(i).start);
				int b = vertices.indexOf(graphAsEdges.get(i).end);
				if (!graphAsEdges.isEmpty())
				{
					graph[a][b] = graphAsEdges.get(i).weight;
				}
			}
		} catch (IOException e) {
			speedError = true;
			// e.printStackTrace();
		}
	}

	/**
	 * @return int: minimum minutes that will pass before the three contestants can
	 *         meet
	 */
	public int timeRequiredforCompetition() {
		if (speedError)	return -1;
		ArrayList<Double> longest = new ArrayList<Double>();
		for (int i = 0; i < V; i++) 
		{
			longest.add(dijkstraLongestForSource((int) Math.round(vertices.get(i))));
		}

		double longestDist = -1;
		for (int i = 0; i < longest.size(); i++) {
			if (longest.get(i) == Integer.MAX_VALUE)
				return -1;
			else if (longest.get(i) > longestDist)
				longestDist = longest.get(i);
		
		}
		return (int) Math.ceil((longestDist*1000)/slowestWalkSpeed);
	}

	// ---------------------------------------------------------------------------------------------------------------------------
	int minDistance(double dist[]) {
		double min = Integer.MAX_VALUE ;
		int min_index = -1;

		for (int v = 0; v < V; v++)
			if (shortestPathSet.get(v) == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		return min_index;
	}

	double dijkstraLongestForSource(int src) {

		double distance[] = new double[V]; // The output array.dist[i] will hold the shortest dist from src to i
		shortestPathSet.clear();

		for (int i = 0; i < V; i++) { // Initialize all distances as INFINITE and stpSet[] as false
			distance[i] = Integer.MAX_VALUE;
			shortestPathSet.add(false);
		}

		distance[src] = 0; // Distance of source vertex from itself is always 0
		for (int count = 0; count < V; count++) // Find shortest path for all vertices
		{
			int vertexIndex = minDistance(distance); // Pick the minimum distance vertex from the set of vertices not yet processed
			shortestPathSet.set(vertexIndex, true); // Mark the picked vertex as processed

			for (int adjIndex = 0; adjIndex < V; adjIndex++) // Update distance value of the adjacent vertices of the picked vertex.
			{
				//boolean hasPathTo = false;
				
				//for (Road x : graphAsEdges) 
				//	if (x.start == vertices.get(vertexIndex) && x.end == vertices.get(adjIndex) ) hasPathTo = true;

				if (!shortestPathSet.get(adjIndex) 
				//	&& hasPathTo
					&& graph[vertexIndex][adjIndex] != 0
					&& distance[vertexIndex] != Integer.MAX_VALUE
					&& distance[vertexIndex] + graph[vertexIndex][adjIndex] < distance[adjIndex])
				{
					distance[adjIndex] = distance[vertexIndex] + graph[vertexIndex][adjIndex];
				}
			}
		}

		double longestDist = -1;
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] > longestDist)
				longestDist = distance[i];
		}

		return longestDist;
	}

	public List<String> fileToArray(String theFile) throws IOException {
		List<String> data = new ArrayList<String>();
		if (theFile == null || theFile == "") {
			speedError = true;
			return data;
		}
		BufferedReader reader = new BufferedReader(new FileReader(theFile));

		String s;
		while ((s = reader.readLine()) != null) {
			data.add(s);
			// System.out.println(s);
		}
		reader.close();
		return data;
	}

	public double[] roadInfo(String s) {
		String line = s.trim();
		String[] numStrings = line.split("\\s+");
		numStrings[0] = numStrings[0].trim();
		numStrings[1] = numStrings[1].trim();
		numStrings[2] = numStrings[2].trim();
		// Splits each spaced number into a String array.
		double[] nums = new double[numStrings.length];
		// Creates the integer array.
		for (int i = 0; i < nums.length; i++) {
			String x = numStrings[i].replaceAll("\\s+", "");
			nums[i] = Double.parseDouble(x);
		}
		return nums;
	}

	class Road {
		double start;
		double end;
		double weight;

		public Road(double startNode, double endNode, double theWeight) {
			start = startNode;
			end = endNode;
			weight = theWeight;
		}
	}

}
