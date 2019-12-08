package studentpractice.DuongHueLinh;

public class Rectangle {
	private int width,length;
	public Rectangle(){
		
	}
	public Rectangle(int w,int l){
		length=l;
		width=w;
	}
   public void print(){
	   System.out.println("length="+length+",width="+width);
	   
   }
   public void doublesize(){
	   length=length*2;
	   width=width*2;
   }
   public static void main(String[] args){
	   Rectangle r1=new Rectangle(22,9);
	   r1.print();
	   r1.doublesize();
	   r1.print();
   }
}
