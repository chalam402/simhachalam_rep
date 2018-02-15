package ProgramaticInterviewQuestions;

public class CodeInterviewQuestion5 {
	public void m1(String arg1){
		arg1 = "Am i going to disappear?";
	}
	public static void main(String[] args) {
		CodeInterviewQuestion5 obj = new CodeInterviewQuestion5();
		String iAmOfAnArgumentativeNature = "I am born new";
		obj.m1(iAmOfAnArgumentativeNature);
		System.out.println(iAmOfAnArgumentativeNature);
	}
}
/*
Compile :   Yes
Output  :   I am born new 
*/