package endlessGraph;

import greedyA.GreedySuggestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import lib.Direction;

/**
 * 
 * @author L. Antonio Hidalgo R.
 * Graph that represents the different intersections in the Endless Game. The node's ids 
 * are created using the LehmerTerm class.
 */

public class Graph {
	/* The graph is represented by a list, where the only nodes that exist are the ones the player has
	 * visited.
	 */
	private List<Node> _CurrentGraphNodes = new ArrayList<>();
	
	// The root node is always the same, and is the first time an arc is added
	private Node _Root = new Node(1, 2);
	
	// Current nodes that can be returned to are added to this HashMap. Only 3 are added per key.
	private HashMap<Integer, List<Node>> _CurrentReturnNodes = new HashMap<Integer, List<Node>>();
	
	/* This HashMap addresses the "already visited nodes" problem. There are 4 lists that remember the
	 * last 4 paths the player has taken.
	 */
	private LinkedHashMap<Long, List<Node>> _VisitedPaths = new LinkedHashMap<Long, List<Node>>();
	
	/* This HashMap contains the Lehmer term associated with a level. Given the id, the level
	 * is the int value of that key. 
	 */
	private HashMap<Long, Integer> _Levels = new HashMap<>();
	
	/* This is the probability that a suggestion occurs for nodes of 2 or 3 children. */
	private final double SUGGESTIONPROB = 0.1;
	
	/* This constant is used to check the number of levels the player has passed. It can't be more than 60, because
	 * that would violate the amount of nodes the graph should have. 
	 */
	private final int MAXLEVELS = 60; 
	
	public Graph() {
		_CurrentGraphNodes.add(_Root);
	}
	
	public List<Node> getCurrentGraphNodes() {
		return _CurrentGraphNodes;
	}
	
	public HashMap<Integer, List<Node>> getCurrentReturnNodes() {
		return _CurrentReturnNodes;
	}
	
	public HashMap<Long, Integer> getLevels() {
		return _Levels;
	}

	private Node getLastNode() {
		return _CurrentGraphNodes.get(level() - 1);
	}
	
	public HashMap<Long, List<Node>> getVisitedPaths() {
		return _VisitedPaths;
	}
	
	private int level() {
		return _CurrentGraphNodes.size();
	}
	
	private synchronized void addReturnNodes(int pIndex, Node pNode) {
		List<Node> tempNodeList = _CurrentReturnNodes.get(pIndex); 
		
		if(tempNodeList == null) {
			tempNodeList = new ArrayList<Node>();
			_CurrentReturnNodes.put(pIndex, tempNodeList);
		}
		
		int listLength = _CurrentReturnNodes.get(pIndex).size();
		
		switch(listLength) {
			case 3:
				_CurrentReturnNodes.get(pIndex).remove(listLength - 1);
				_CurrentReturnNodes.get(pIndex).add(pNode);
				break;
			default:
				_CurrentReturnNodes.get(pIndex).add(pNode);
				break;
		}
	}
	
	/**
	 * Adds a connection between the current node and the next, depending on the direction
	 * the player chose (this updates the last node's direction, not the node being added to the graph).
	 * @param pDirection, the direction the player chose to follow
	 */
	public void addArc(Direction pDirection) {
		long newNodeId = LehmerTerm.nthTerm(level());
		int lastId = (int)((newNodeId + pDirection.getDirectionValue()) % 10);
		int numberOfChildren;
		Node nodeToAdd;
		Node lastNode = getLastNode();
		Direction returnDirection;
		
		if(checkLastLevel(level()))
				System.out.println("You have reached the end of the game! Congratulations!");
		
		if(!_Levels.containsKey(newNodeId))
			_Levels.put(newNodeId, level());
		
		numberOfChildren = GraphPaths.setChildrenFromDigit(lastId);
		
		if((numberOfChildren == 2 || numberOfChildren == 3) && Math.random() < SUGGESTIONPROB)
			GreedySuggestion.getSuggestion(lastNode, level() % 3, level());
//		System.out.println("Last id: " + lastId);
		
		lastNode.setDirectionTaken(pDirection);
		nodeToAdd = new Node(newNodeId, numberOfChildren);
		
		addNode(nodeToAdd);
		
		returnDirection = GraphPaths.returnDirection(lastNode);
		
//		System.out.println("Level: " + level());
		
		if(level() % 3 != 0)
			addReturnNodes(level() % 3, lastNode);
		else {
			System.out.println("Return direction: " + returnDirection);
			if(pDirection == returnDirection)
				GraphPaths.returnPath(newNodeId, _CurrentReturnNodes, _CurrentGraphNodes, _VisitedPaths);
		}
			
	}
	
	/**
	 * Sets the number of children of a node, taking into account the node's id (its level) and
	 * the direction taken to get there.
	 * @param pId
	 * @return the number of children a node has, based on pId
	 */
	
	private void addNode(Node pNewNode) {
		_CurrentGraphNodes.add(pNewNode);
	}
	
	private boolean checkLastLevel(int pLevel) {
		return (pLevel > MAXLEVELS);
	}
	
	public static void main(String[] args) {
		Graph gPrueba = new Graph();
		gPrueba.addArc(Direction.RIGHT2);
		gPrueba.addArc(Direction.LEFT2);
		gPrueba.addArc(Direction.CENTER3);
		
		gPrueba.addArc(Direction.RIGHT2);
		gPrueba.addArc(Direction.RIGHT3);
		gPrueba.addArc(Direction.LEFT2);
		//gPrueba.addArc(Direction.RIGHT3);
		//System.out.println(gPrueba.getLevels());
		
		System.out.println(gPrueba.getCurrentGraphNodes());
		System.out.println(gPrueba.getCurrentReturnNodes());
		System.out.println(gPrueba.getVisitedPaths());
	}
}
