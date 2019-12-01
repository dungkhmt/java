package studentpractice.phamquangdung;

public class Rectangle {
	private int length;
	private int width;
	
	public Rectangle(){
		
	}
	public Rectangle(int l, int w){
		length = l; width = w;
	}
	public void print(){
		System.out.println("length = " + length + ", width = " + width);
	}
	public void doubleSize(){
		length = length*2;
		width = width*2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r1 = new Rectangle(2,3);
		Rectangle r2 = new Rectangle(5,6);
		
		r1.print();
		r2.print();
		
		r1.doubleSize();
		r1.print();
		
	}

}
