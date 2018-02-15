package ProgramaticInterviewQuestions;

import java.util.HashSet;
import java.util.Set;

public class SetFindsDuplicatesIn_S1_S2 {
	public static void main(String[] args) {
		String s1 = "Simhachalam";String s2 = new String("Simhachalam");
		Set<String> setObj = new HashSet<String>();
		setObj.add(s1);
		setObj.add(s2);
		System.out.println(setObj);
	}
}	
