package studentpractice.phamducdat.MaxflowNetwork;

public class Arc implements Comparable<Arc> {

	public Node begin;
	public Node end;
	public int d,w;
	
	
	public Arc(Node begin, Node end, int d, int w) {
		super();
		this.begin = begin;
		this.end = end;
		this.d = d;
		this.w = w;
	}
	
	public String toString() {
		return "( " + this.begin.getId() + " , " + this.end.getId() + " : " + this.d + " / " +this. w + " )";
	}

	public Arc() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Arc o) {
		if(this.w > o.w) 
			return 1;
		if(this.w < o.w)
			return -1;
		else
			return 0;
	}
	
	
	
}
