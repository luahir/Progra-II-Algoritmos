package endlessGraph;

import java.util.ArrayList;
import java.util.List;

import lib.Direction;

/**
 * 
 * @author L. Antonio Hidalgo R.
 * Graph that represents the different intersections in the Endless Game. The node's ids are created using the LehmerTerms class.
 */

public class Graph {
	/* List that holds the player's movement choices. It has to hold a maximum of 60 choices at a time.
	 * The level coincides with the element's index. 
	 */
	private List<Direction> _DirectionsList = new ArrayList<>();
	
	/* The graph is represented by a list, where the only nodes that exist are the ones the player has
	 * visited.
	 */
	private List<Node> _CurrentGraphNodes = new ArrayList<>();
	private Node _Root = new Node(1, 2);
	
	public Graph() {
		_CurrentGraphNodes.add(_Root);
	}
	
	public List<Direction> getDirectionsList() {
		return _DirectionsList;
	}

	public List<Node> getCurrentGraphNodes() {
		return _CurrentGraphNodes;
	}
	
	private Node getLastNode() {
		return _CurrentGraphNodes.get(level() - 1);
	}
	
	private int level() {
		return _CurrentGraphNodes.size();
	}
	
	/**
	 * Adds a connection between the current node and the next, depending on the direction
	 * the player chose.
	 * @param pDirection, the direction the player chose to follow
	 */
	public void addArc(Direction pDirection) {
		long newNodeId = LehmerTerm.nthTerm(level());
		System.out.println(newNodeId+ pDirection.getDirectionValue());
		int lastId = (int)((newNodeId + pDirection.getDirectionValue()) % 10);
		int numberOfChildren;
		System.out.println(lastId);
		_DirectionsList.add(pDirection);
		
		switch(lastId) {
			case 1: case 2: case 3: case 4:
				numberOfChildren = 2;
				break;
			case 5: case 6: case 7: case 8:
				numberOfChildren = 3;
				break;
			default:
				numberOfChildren = 1;
		}
		
		addNode(new Node(newNodeId, numberOfChildren));
	}
	
	private void addNode(Node pNewNode) {
		_CurrentGraphNodes.add(pNewNode);
	}
	
	public void returnPath() {
	// Return to a previously visited node. 	
	}
	public static void main(String[] args) {
		Graph gPrueba = new Graph();
		gPrueba.addArc(Direction.RIGHT2);
		gPrueba.addArc(Direction.LEFT2);
		gPrueba.addArc(Direction.RIGHT2);
		gPrueba.addArc(Direction.RIGHT2);
		gPrueba.addArc(Direction.CENTER3);
		System.out.println(gPrueba.getCurrentGraphNodes());
		System.out.println(gPrueba.getDirectionsList());
	}
}
