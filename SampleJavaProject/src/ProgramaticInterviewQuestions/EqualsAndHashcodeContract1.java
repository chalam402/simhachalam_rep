package ProgramaticInterviewQuestions;

import java.util.HashSet;
import java.util.Set;

class EmployeeKey1{
	String empId;
	String empDOB;
	public EmployeeKey1(String theId, String theDOB) {
		 empId = theId;
		 empDOB = theDOB;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empDOB == null) ? 0 : empDOB.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeKey1 other = (EmployeeKey1) obj;
		if (empDOB == null) {
			if (other.empDOB != null)
				return false;
		} else if (!empDOB.equals(other.empDOB))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		return true;
	}
		
	@Override
	public String toString() {
		return "EmployeeKey [empId=" + empId + ", empDOB=" + empDOB + "]";
	}
}
public class EqualsAndHashcodeContract1 {
	public static void main(String[] args) {
		EmployeeKey1 ek1 = new EmployeeKey1("100", "2545");
		EmployeeKey1 ek2 = new EmployeeKey1("200", "5453");
		EmployeeKey1 ek3 = new EmployeeKey1("300", "4534");
		EmployeeKey1 ek4 = new EmployeeKey1("200", "5453");
		Set<EmployeeKey1> setObj  = new HashSet<EmployeeKey1>();
		setObj.add(ek1);
		setObj.add(ek2);
		setObj.add(ek3);
		setObj.add(ek4);
		System.out.println("Set Object Size : "+setObj.size());
		System.out.println(setObj);
		
	}
}
