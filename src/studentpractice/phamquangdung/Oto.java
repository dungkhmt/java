package studentpractice.phamquangdung;

public class Oto {
	private Banhxe[] banh;
	private Cua[] cua;
	
	public Oto(){
		banh = new Banhxe[4];
		cua = new Cua[2];
		
		for(int i = 0; i < 4; i++)
			banh[i] = new Banhxe(7);
		
		for(int i = 0; i < 2; i++)
			cua[i] = new Cua(3,7);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
