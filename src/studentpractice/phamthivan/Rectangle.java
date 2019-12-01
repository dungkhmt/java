package studentpractice.phamthivan;

public class Rectangle {
	private int length;
	private int width;
	
	public Rectangle(){
		
	}
	
	public void doublesize(){
		length = length*2;
		width = width*2;
		
	}
	public Rectangle(int l, int w){
		length = l; width = w;
	}
	public void print(){
		System.out.println("length = "+ length + ",width = "+ width);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r1 = new Rectangle(2,6);
		Rectangle r2 = new Rectangle(3,4);
		
		r1.print();
		r2.print();
		
		r1.doublesize();
		r1.print();
		

	}

}
