package studentpractice.NguyenPhiTruong.String;

public class SubString {
	public String subString;

	public String getSubString() {
		return subString;
	}

	public void setSubString(String subString) {
		this.subString = subString;
	}
	public char getCharAt(int index) {
		return this.subString.charAt(index - 1);
	}
}
