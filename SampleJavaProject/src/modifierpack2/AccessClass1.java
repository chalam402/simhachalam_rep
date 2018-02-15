package modifierpack2;

import modifierpack1.SharedClass;
class ParentClass1{
	
}
public class AccessClass1 extends ParentClass1{
	public static void main(String[] args) {
		//cannot access SharedClass private variable outside the class
		
		//cannot access SharedClass default variable outside the package
		//System.out.println(SharedClass.fullAddress);
		
		//cannot access SharedClass protected variable outside the package
		//System.out.println(SharedClass.accountNo);
		System.out.println(SharedClass.city);
	}
}
