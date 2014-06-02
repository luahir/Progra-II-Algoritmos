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
	private List<Direction> _DirectionsList = new ArrayList<>();
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
	
	public void addArc(Direction pDirection) {
		long newNodeId = LehmerTerm.nthTerm(level());
		int lastId = (int)(newNodeId + pDirection.getDirectionValue()) % 10;
		int numberOfChildren;
		
		_DirectionsList.add(pDirection);
		
		switch(lastId) {
			case 1: case 3: case 7: case 9:
				numberOfChildren = 2;
				break;
			case 5:
				numberOfChildren = 1;
				break;
			default:
				numberOfChildren = 3;
		}
		
		addNode(new Node(newNodeId, numberOfChildren));
	}
	
	private void addNode(Node pNewNode) {
		_CurrentGraphNodes.add(pNewNode);
	}
	public static void main(String[] args) {
		Graph gPrueba = new Graph();
		gPrueba.addArc(Direction.RIGHT2);
		gPrueba.addArc(Direction.RIGHT3);
		System.out.println(gPrueba.getCurrentGraphNodes());
		System.out.println(gPrueba.getDirectionsList());
	}
}
