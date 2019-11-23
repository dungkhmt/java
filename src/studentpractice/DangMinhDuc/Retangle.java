package studentpractice.DangMinhDuc;

public class Retangle {
	private int length;
	private int width;

	public Retangle(int l, int w) {
		length = l ; width = w;
	}
	public void print() {
		System.out.println("length = " + length + ", width = " + width);
	}
	public void doublesize() {
		length = length*2;
		width = width*2;
	}
	public static void main(String[] args) {
				// TODO Auto-generated method stub
		Retangle r1 = new Retangle(2,3);
		Retangle r2 = new Retangle(1,4);
		
		r1.print();
		r2.print();
		r1.doublesize();
		r1.print();
		
	}

}
