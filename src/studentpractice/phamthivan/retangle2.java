package studentpractice.phamthivan;

public class retangle2 {
	private int length;
	private int width;
	
	public retangle2(){
		
	}
	public void sizex2(){
		
	}
	public retangle2(int l, int w){
		length = l; width = w;
	}
	public void print(){
		System.out.println("length = "+ length +", width = " + width);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		retangle2 r1 = new retangle2(2,3);
		retangle2 r2 = new retangle2(5,6);
		
		r1.print();
		r2.print();
		
		

	}
	
	}


