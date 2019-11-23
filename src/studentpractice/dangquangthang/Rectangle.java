
public class Rectangle {
	private int length;
	private int width;
    private  Rectangle sub + new Rectangle();

	public Rectangle() {
		length = 0;
		width = 0;
	}

	public Rectangle(int L, int W) {
		length = L;
		width = W;

	}

	public void print() {
		System.out.print("Length =" + length + ", width =" + width);
	}

	public int area() {
		return length * width;
	}

	public void doubleLength() {
		length = length * 2;
	}
        
	public static void main(String[] args) {
		System.out.print("start...");
		Rectangle R1;
		Rectangle R2;
		R1 = new Rectangle();
		R2 = new Rectangle(3, 5);

		System.out.print(" R1=");
		R1.print();
		System.out.print(" R1=");
		R2.print();
        
		System.out.print("length R1 = " + R1.length);
	
	}
}
