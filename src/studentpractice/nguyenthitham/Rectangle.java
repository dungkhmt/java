package studentpractice.nguyenthitham;

public class Rectangle {
	
	private int length, width;
	
	// constructor 1
	public Rectangle(){
			
		}
	// constructor 2
	public Rectangle(int l, int w){
		length =l;
		width =w;
	}
	
	public void print(){
		System.out.println("length= "+length +", width= "+width);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r1 = new Rectangle(2, 4);
		Rectangle r2 = new Rectangle(10000000, 10000000);
		r1.print(); r2.print();
	}

}
