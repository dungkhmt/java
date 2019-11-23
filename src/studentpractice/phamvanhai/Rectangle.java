
public class Rectangle {
	private int length;
	private int width;
	private int area;
	
	public Rectangle() {
		length = 0;
		width = 0;
	}
	public Rectangle(int l, int w) {
		length = l;
		width = w;
	}
	
	public void print() {
		System.out.println("Length = " + length + ", width = " + width);
	}
	public int area() {
		//co the truy cap, thao tac voi cac thuoc tinh
		area = length * width;
		return area;
	}
	
	public void printArea() {
		System.out.println("Area = " + area);
	}
	
	public void doubleLength() {
		length = length * 2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Start...");
		Rectangle R1 = new Rectangle();
		Rectangle R2 = new Rectangle(3,5);
		System.out.print("R1 = "); R1.print(); R1.area(); R1.printArea();
		System.out.print("R2 = "); R2.print(); R2.area(); R2.printArea();
		
		System.out.println("length R1 = " + R1.length);
	}

}
