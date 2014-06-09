package endlessGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lib.Direction;

/**
 * 
 * @author L. Antonio Hidalgo R.
 * Utilitarian class that implements the path methods to maintain the HashMap of nodes that have been visited already and cut
 * the current path short.
 */
public class GraphPaths {
	
	/**
	 * 
	 * @param pId the id of the latest node that was added to the graph.  
	 * @param pCurrentReturnNodes the list of the nodes saved in the HashMap, that the player could return to.
	 * @param pCurrentGraphNodes the nodes in the current graph. 
	 * @param pVisitedPaths the latest four paths that the player has traversed.
	 * @param pLevels the HashMap that contains the pair <Lehmer term, level>
	 */
	public static void returnPath(long pId, HashMap<Integer, List<Node>> pCurrentReturnNodes, List<Node> pCurrentGraphNodes, 
									HashMap<Long, List<Node>> pVisitedPaths) {
		// Return to a previously visited node.
		int key = (int) (pId % 3);
		int entryNumber;
//		System.out.println("Key: " + key);
//		System.out.println("Current return Nodes: " + pCurrentReturnNodes);
		
		// If the key has no value, there is no return path and the player keeps going.
		if(pCurrentReturnNodes.get(key) != null) {
			entryNumber = (int) (pId % pCurrentReturnNodes.get(key).size());
			Node chosenNode = pCurrentReturnNodes.get(key).get(entryNumber);
			saveVisitedPath(chosenNode, pCurrentGraphNodes, pVisitedPaths);
			cutCurrentGraph(chosenNode, pCurrentGraphNodes);
		}
	}
	
	public static Direction returnDirection(Node pNode) {
		int numberOfDirections = pNode.getNumberOfChildren();
		int lastDigit = (int)((pNode.getId() + numberOfDirections) % 10);
		Direction directionThatReturns = Direction.CENTER1;
		
		
		switch(numberOfDirections) {
			case 1:
				directionThatReturns = Direction.CENTER1;
				break;
			case 2:
				if(lastDigit % 2 == 0)
					directionThatReturns = Direction.LEFT2;
				else
					directionThatReturns = Direction.RIGHT2;
				break;
			default:
				switch(lastDigit) {
					case 0: case 1: case 2:
						directionThatReturns = Direction.LEFT3;
						break;
					case 3: case 4: case 5: case 9:
						directionThatReturns = Direction.CENTER3;
						break;
					case 6: case 7: case 8:
						directionThatReturns = Direction.RIGHT3;
						break;
				}
				break;
		}
		
		return directionThatReturns;
	}
	
	/**
	 * Saves a path that has been already visited.
	 * @param pNode
	 * @param pCurrentGraphNodes
	 * @param pVisitedPaths
	 * @param pLevels
	 */
	private static void saveVisitedPath(Node pNode, List<Node> pCurrentGraphNodes, HashMap<Long, List<Node>> pVisitedPaths) {
		int saveFromIndex = pCurrentGraphNodes.indexOf(pNode);
		List<Node> tempList = new ArrayList<>();
		
//		System.out.println("Saving... ");
		
		for(; saveFromIndex < pCurrentGraphNodes.size(); saveFromIndex++) {
//			System.out.println("Start index: " + saveFromIndex);
			tempList.add(pCurrentGraphNodes.get(saveFromIndex));
//			System.out.println("Node temp list: " + tempList);
		}
		
		pVisitedPaths.put(pNode.getId(), tempList);
		checkPaths(pVisitedPaths);
	}
	
	/**
	 * 
	 * @param pNode, the last node added to the graph, and the first to be cut when the player goes back.
	 * @param pCurrentGraphNodes, the graph's current nodes, that will be cut after this operation.
	 */
	private static void cutCurrentGraph(Node pNode, List<Node> pCurrentGraphNodes) {
		int cullIndex = pCurrentGraphNodes.indexOf(pNode);
		int listEnd = pCurrentGraphNodes.size() - cullIndex;
		
//		System.out.println("Current Graph before cut: " + pCurrentGraphNodes);
//		
//		System.out.println("Cutting... ");
//		System.out.println("Size: " + pCurrentGraphNodes.size());
		
		for(int times = 0; times < listEnd; times++) {
//			System.out.println("Cut index: " + cullIndex);
			pCurrentGraphNodes.remove(cullIndex);
		}
		
//		System.out.println("Current Graph " + pCurrentGraphNodes);
	}
	
	/**
	 * Checks the current visited paths to determine the number that have been saved.
	 * If more than 4, it erases the one on the lowest level.
	 * @param pPaths the HashMap that contains the last 4 visited paths.
	 * @param pLevels the HashMap that relates a Lehmer term with its respective level.
	 */
	private static void checkPaths(HashMap<Long, List<Node>> pPaths) {
		int savedPaths = pPaths.size();
		long key;
		
		if(savedPaths > 4) {
			key = pPaths.entrySet().iterator().next().getKey();
			pPaths.remove(key);
		}
	}
}
