package greedyA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lib.Direction;

import endlessGraph.LehmerTerm;
import endlessGraph.Node;

public class GreedySuggestion {
	
	// This greedy algorithm considers  
	public static Direction getSuggestion(Node pNode, int pDepth, int pLevel) {
		HashMap<Integer, Node> possibleSolutions = new HashMap<>(); 
		int children = pNode.getNumberOfChildren();
		Direction suggestion;
		
		possibleSolutions = makePaths(pNode, pDepth, pLevel);
		
		switch(children) {
			case 1:
				suggestion = Direction.CENTER1;
				break;
			default:
				suggestion = bestDirection(possibleSolutions, children);
				break;
		}
		System.out.println(suggestion);
		return suggestion;
	}
	
	private static HashMap<Integer, Node> makePaths(Node pNode, int pDepth, int pLevel) {
		List<Node> tempList = new ArrayList<>();
		tempList.add(pNode);
		HashMap<Integer, Node> listMap = new HashMap<>();
		
		//System.out.println(pNode.getNumberOfChildren());
		
		switch(pNode.getNumberOfChildren()) {
		case 1:
			fillPath(Direction.CENTER1, tempList, pDepth, pLevel);
			break;
		case 2:
			fillPath(Direction.LEFT2, tempList, pDepth, pLevel);
			fillPath(Direction.RIGHT2, tempList, pDepth, pLevel);
			break;
		case 3:
			fillPath(Direction.LEFT3, tempList, pDepth, pLevel);
			fillPath(Direction.RIGHT3, tempList, pDepth, pLevel);
			fillPath(Direction.CENTER3, tempList, pDepth, pLevel);
			break;
		}
		
		long lastNodeId = LehmerTerm.nthTerm(pDepth + pLevel);
		//System.out.println(lastNodeId);
		int mapIndex = 0;
		
		for(Node importantNode : tempList) {
			if(importantNode.getId() == lastNodeId) {
				listMap.put(mapIndex, importantNode);
				mapIndex++;
			}
		}
			
		//System.out.println(tempList);
		System.out.println(listMap);
		return listMap;
	}
	
	private static void fillPath(Direction pDirection, List<Node> pPath, int pDepth, int pLevel) {
		long newNodeId = LehmerTerm.nthTerm(pLevel);
		int lastId = (int)((newNodeId + pDirection.getDirectionValue()) % 10);
		int numberOfChildren;
		Node nodeToAdd;
		Node lastNode = pPath.get(pPath.size() - 1);
		
		numberOfChildren = setChildrenFromDigit(lastId);
		//System.out.println(pDirection);
		lastNode.setDirectionTaken(pDirection);
		nodeToAdd = new Node(newNodeId, numberOfChildren);
		
		pPath.add(nodeToAdd);
		if(pDepth == 0)
			return;
		
		switch(numberOfChildren) {
			case 1:
				fillPath(Direction.CENTER1, pPath, pDepth - 1, pLevel + 1);
				break;
			case 2:
				fillPath(Direction.LEFT2, pPath, pDepth - 1, pLevel + 1);
				fillPath(Direction.RIGHT2, pPath, pDepth - 1, pLevel + 1);
				break;
			case 3:
				fillPath(Direction.LEFT3, pPath, pDepth - 1, pLevel + 1);
				fillPath(Direction.RIGHT3, pPath, pDepth - 1, pLevel + 1);
				fillPath(Direction.CENTER3, pPath, pDepth - 1, pLevel + 1);
				break;
		}
		
			
	}
	
	private static int setChildrenFromDigit(int pId) {
		int numberOfChildren;
		
		switch(pId) {
			case 1: case 2: case 3: case 4:
				numberOfChildren = 2;
				break;
			case 5: case 6: case 7: case 8: case 9:
				numberOfChildren = 3;
				break;
			default:
				numberOfChildren = 1;
		}
		
		return numberOfChildren;
	}
	
	private static Direction bestDirection(HashMap<Integer, Node> pNodes, int pChildren) {
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		Direction bestDirection;
		
		for(int key = 0; key < pNodes.size(); key ++) {
			switch(key % pChildren) {
				case 0:
					if(pNodes.get(key).getNumberOfChildren() == 3)
						count0++;
					break;
				case 1:
					if(pNodes.get(key).getNumberOfChildren() == 3)
						count1++;
					break;
				case 2:
					if(pNodes.get(key).getNumberOfChildren() == 3)
						count2++;
					break;
			}
		}
		
		if(pChildren == 2 && count0 >= count1)
			bestDirection = Direction.LEFT2;
		else
			bestDirection = Direction.RIGHT2;
		
		if(pChildren == 3) { 
				if(count0 > count1 && count0 > count2)
					bestDirection = Direction.LEFT3;
				else if(count1 >= count0 && count1 >= count2)
					bestDirection = Direction.RIGHT3;
				else if(count2 >= count0 && count2 >= count2)
					bestDirection = Direction.CENTER3;
		}
		return bestDirection;	
	}
	
	public static void main(String[] args) {
		Node pNode = new Node(1, 3);
		GreedySuggestion.getSuggestion(pNode, 3, 1);
	}
}
