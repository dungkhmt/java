package studentpractice.phamthiduyen;

public class rectangle {
    private int length ;
    private int width;
    public rectangle(int l , int v){
    	length = l;
        width = v;
        	
    }
    public void sizex2(){
    	length = length * 2;
    	width = length * 2;
    }
    
    public void print(){
    	System.out.println("length=" + length +", width=" + width);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        rectangle r1 = new rectangle(2, 3);
        rectangle r2 = new rectangle(5,6);
        
        r1.print();
        r2.print();
        r1.sizex2();
        r1.sizex2();
	}

}
