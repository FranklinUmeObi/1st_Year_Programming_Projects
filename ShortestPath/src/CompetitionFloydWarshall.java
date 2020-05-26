import java.io.*;
import java.util.*;


public class CompetitionFloydWarshall {

	double[][] graph; // Adjacency matrix
	int V;
	int E;
	int slowestWalkSpeed;

	ArrayList<Double> vertices;
	boolean speedError;

	/**
	 * @param filename: A filename containing the details of the city road network
	 * @param sA, sB, sC: speeds for 3 contestants
	 */
	CompetitionFloydWarshall(String filename, int sA, int sB, int sC) {
		if (sA < 50 || sB < 50 || sC < 50 || sA > 100 || sB > 100 || sC > 100)
			speedError = true;
		else
			speedError = false;

		List<String> data;
		try {
			data = fileToArray(filename);
			if (data.size() < 3) {
				speedError = true;
				return;
			}

			ArrayList<Road> graphAsEdges = new ArrayList<Road>(); // ARRAY TO CONTAIN EDGE OBJECTS
			vertices = new ArrayList<Double>(); // ARRAY TO CONTAIN VERTICES

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

			for (int i = 0; i < V; i++) 
				for (int j = 0; j < V; j++) 
					graph[i][j] = Integer.MAX_VALUE; // Set adjacency matrix to all equal infinity
				
			for (int i = 0; i < V; i++) 
				graph[i][i] = 0; 

			for (int i = 0; i < graphAsEdges.size(); i++) 
			{
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
		if (speedError) return -1;
		
		double ans = FloydWarshallLongestForSource();
		
			if (ans == -1 ) return -1;
		return (int) Math.ceil((ans * 1000) / slowestWalkSpeed);
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	double FloydWarshallLongestForSource() 
	{
		for (int k = 0; k < V; k++) 
			for (int i = 0; i < V; i++) 
				for (int j = 0; j < V; j++) 
					if (graph[i][k] + graph[k][j] < graph[i][j])
						graph[i][j] = graph[i][k] + graph[k][j]; 		//Flloyd marshal algo

		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++) 
				if (graph[i][j] == Integer.MAX_VALUE)
					return -1;		// check if a node is not reached
		
		double longestD = -1;
		for (int i = 0; i < V; i++) 
			for (int j = 0; j < V; j++) 
				if (graph[i][j] > longestD && graph[i][j] < Integer.MAX_VALUE )					
					longestD = graph[i][j];   // find largest weight

		return longestD;

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
