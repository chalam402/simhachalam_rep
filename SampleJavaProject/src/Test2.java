
public class Test2 {
	public static String foo(){
		System.out.println("Test foo called");
		return "";
	}
	
	public static void main(String args[]){
		Test2 obj = null;
		System.out.println(obj.foo());
	}
}