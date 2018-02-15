package ProgramaticInterviewQuestions;
final class Employee{
	final String pancardNumber; 
	public Employee(String pancardNumber){  
		this.pancardNumber=pancardNumber;  
	}  
	public String getPancardNumber(){  
		return pancardNumber;  
	}  
}
public class ImmutableMainWithFinal {
	public static void main(String[] args) {
		System.out.println(new Employee("RREEDT45874"));
		System.out.println(new Employee("RREEDT45874"));
	}
}
