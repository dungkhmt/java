package studentpractice.daothuhuong;

public class rectangle {
	private int length;
	private int width;
	public rectangle(){
		
	}
	public rectangle(int l,int w){
		length=l;width = w;
	}
	public void print(){
		System.out.println("length = "+ length + ", width = " + width);
	}
	public void doublesize(){
		length = length*2;
		width= width *2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rectangle r1 = new rectangle(2,3);
		rectangle r2 =new rectangle(5,6);
		r1.print();
		r2.print();
		

	}
}
