package FindDuplicates;

import java.util.HashSet;
import java.util.Set;

class ModelClass1{
    
    private String name;
    private int salary;
     
    public ModelClass1(String n, int s){
        this.name = n;
        this.salary = s;
    }
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

	@Override
	public String toString() {
		return "ModelClass1 [name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
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
		ModelClass1 other = (ModelClass1) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}
    
}

public class HashSetDuplicatsModelObjects {
	public static void main(String[] args) {
		Set<ModelClass1> set = new HashSet<ModelClass1>();
		ModelClass1 m1 = new ModelClass1("model1", 25);
		ModelClass1 m2 = new ModelClass1("model2", 25);
		ModelClass1 m3 = new ModelClass1("model1", 25);
		set.add(m1);
		set.add(m2);
		set.add(m3);
		System.out.println(set.size()+") "+set);
	}
	
}