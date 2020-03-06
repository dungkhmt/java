package studentpractice.phamducdat.Graph;

public class Arc<T> implements Comparable<Arc> {
	public Node begin;
	public Node end;
	public int w;
	public Arc(Node begin, Node end, int w) {
		super();
		this.begin = begin;
		this.end = end;
		this.w = w;
	}
	
	
	public Arc() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String toString() {
		
		return "(" + begin.getId() + ", " + end.getId() + ", " + w + ")";
	}


	@Override
	public int compareTo(Arc o) {
		if(this.w > o.w) {
			return 1;
		}
		if(this.w < o.w)
			return -1;
		else
			return 0;
	}

}
