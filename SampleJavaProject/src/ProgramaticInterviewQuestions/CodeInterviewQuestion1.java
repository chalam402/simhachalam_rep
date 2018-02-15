package ProgramaticInterviewQuestions;

public class CodeInterviewQuestion1 {
	public static void JavaHungry(String s){
		System.out.println("String");
	}
	public static void JavaHungry(Object o){
		System.out.println("Object");
	}
	public static void main(String[] args) {
		JavaHungry(null);
	}
}

/*
Compile :  Yes    
Output   :  String 
*/