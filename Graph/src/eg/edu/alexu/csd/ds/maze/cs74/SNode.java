package eg.edu.alexu.csd.ds.maze.cs74;

public class SNode {

	private Object SData;
	private SNode Slink;

	public SNode() {
		Slink = null;
	}

	public SNode(Object value, SNode n) {
		SData = value;
		Slink = n;
	}

	public void setlink(SNode n) {
		Slink = n;
	}

	public SNode getLink() {
		return Slink;
	}

	public void setData(Object n) {
		SData = n;
	}

	public Object getData() {
		return SData;
	}

}
