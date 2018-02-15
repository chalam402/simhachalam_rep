package ProgramaticInterviewQuestions;

public class CodeInterviewQuestion3 {
	public static void JavaHungry(Exception s){
		System.out.println("Exception");
	}
	public static void JavaHungry(ArithmeticException o){
		System.out.println("ArithmeticException");
	}
	public static void JavaHungry(Object s){
		System.out.println("Object");	
	}
	
	public static void main(String[] args) {
		JavaHungry(null);
	}
}
/*
Compile :  Yes
Output  :   ArithmeticException
*/