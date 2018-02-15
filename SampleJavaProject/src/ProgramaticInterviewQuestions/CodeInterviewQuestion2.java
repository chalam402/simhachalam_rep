package ProgramaticInterviewQuestions;

public class CodeInterviewQuestion2 {
	public static void JavaHungry(String s){
		System.out.println("String");
	}
	public static void JavaHungry(Object o){
		System.out.println("Object");
	}
	public static void JavaHungry(Integer s){
		System.out.println("Integer");	
	}
	public static void main(String[] args) {
		//JavaHungry(null); //CTE
	}
}
/*
Compile :  No   , Error at  line 14
Reason  :   Method is ambiguous 
*/