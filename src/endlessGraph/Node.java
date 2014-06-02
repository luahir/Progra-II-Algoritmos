package endlessGraph;

/**
 * 
 * @author L. Antonio Hidalgo R.
 *
 */
public class Node {
	private long _Id;
	private int _NumberOfChildren;
	
	public Node(long pId, int pNumberOfChildren) {
		_Id = pId;
		_NumberOfChildren = pNumberOfChildren;
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
	
	public String toString() {
		String nodeInfo;
		nodeInfo = "Id: " + _Id;
		nodeInfo += "; " + _NumberOfChildren + " children";
		return nodeInfo;
		
	}
}
