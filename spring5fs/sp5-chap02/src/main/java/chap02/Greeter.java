package chap02;

public class Greeter {
	
	private String format; // = "%s, 안녕하세요"
	
	public String greet(String guest) {
		return String.format(format, guest);
	}
	
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Greeter greeter = new Greeter();
		greeter.setFormat

	}*/

}
