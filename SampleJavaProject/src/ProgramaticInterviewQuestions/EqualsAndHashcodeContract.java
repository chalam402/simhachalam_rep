package ProgramaticInterviewQuestions;

import java.util.HashMap;
import java.util.Map;

class EmployeeKey{
	String empId;
	String empDOB;
	public EmployeeKey(String theId, String theDOB) {
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
		EmployeeKey other = (EmployeeKey) obj;
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
public class EqualsAndHashcodeContract {
	public static void main(String[] args) {
		Map<EmployeeKey, String> mapObj = getEmployeeList();
		EmployeeKey ek_lookUp = new EmployeeKey("300", "4534");
		String empName = mapObj.get(ek_lookUp);
		System.out.println(empName);
	}
	static Map<EmployeeKey, String> getEmployeeList(){
		Map<EmployeeKey, String> empList = new HashMap<EmployeeKey, String>();
		EmployeeKey ek1 = new EmployeeKey("100", "2545");
		EmployeeKey ek2 = new EmployeeKey("200", "5453");
		EmployeeKey ek3 = new EmployeeKey("300", "4534");
		EmployeeKey ek4 = new EmployeeKey("400", "6834");
		empList.put(ek1, "Ram");
		empList.put(ek2, "Jani");
		empList.put(ek3, "Chalam");
		empList.put(ek4, "Pradeep");
		return empList;
	}
}
