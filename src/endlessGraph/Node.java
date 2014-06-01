package endlessGraph;

public class Node {
	private long _id;
	private int _numberOfChildren;
	
	public Node(long pId, int pNumberOfChildren) {
		super();
		_id = pId;
		_numberOfChildren = pNumberOfChildren;
	}
	
	public long getId() {
		return _id;
	}
	public void setId(long pId) {
		_id = pId;
	}
	public int getNumberOfChildren() {
		return _numberOfChildren;
	}
	public void setNumberOfChildren(int pNumberOfChildren) {
		_numberOfChildren = pNumberOfChildren;
	}
}
