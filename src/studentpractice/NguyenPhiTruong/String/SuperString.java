package studentpractice.NguyenPhiTruong.String;

public class SuperString {
	public String superString;

	public String getSuperString() {
		return superString;
	}

	public void setSuperString(String superString) {
		this.superString = superString;
	}
	
	public char getCharAt(int index) {
		return this.superString.charAt(index - 1);
	}
}
