package endlessGraph;

import lib.Direction;

/**
 * 
 * @author L. Antonio Hidalgo R.
 *
 */
public class Node {
	private long _Id;
	private int _NumberOfChildren;
	Direction _DirectionTaken;
	
	public Node(long pId, int pNumberOfChildren, Direction pDirectionTaken) {
		_Id = pId;
		_NumberOfChildren = pNumberOfChildren;
		setDirectionTaken(pDirectionTaken);
	}
	
	public Node(long pId, int pNumberOfChildren) {
		_Id = pId;
		_NumberOfChildren = pNumberOfChildren;
	}
	
	public Node() {
		
	}
	
	public long getId() {
		return _Id;
	}
	
	public void setId(long pId) {
		_Id = pId;
	}
	
	public int getNumberOfChildren() {
		return _NumberOfChildren;
	}
	
	public void setNumberOfChildren(int pNumberOfChildren) {
		_NumberOfChildren = pNumberOfChildren;
	}
	
	public Direction getDirectionTaken() {
		return _DirectionTaken;
	}
	
	public void setDirectionTaken(Direction pDirection) {
		if(checkValidDirection(pDirection))
			_DirectionTaken = pDirection;
		//else
			//System.out.println("Invalid direction entered. " + getNumberOfChildren() + " children " + "direction: " + pDirection);
	}
	
	private boolean checkValidDirection(Direction pDirection) {
		boolean valid = false;
		
		switch(pDirection) {
			case CENTER1:
				if(_NumberOfChildren == 1)
					valid = true;
				break;
			case LEFT2: case RIGHT2:
				if(_NumberOfChildren == 2)
					valid = true;
				break;
			default:
				if(_NumberOfChildren == 3)
					valid = true;
				break;
		}
		
		return valid;
	}
	
	public String toString() {
		String nodeInfo;
		nodeInfo = "Id: " + _Id;
		nodeInfo += "; " + _NumberOfChildren + " children";
		nodeInfo += "; " + _DirectionTaken + " direction";
		return nodeInfo;
		
	}
}
