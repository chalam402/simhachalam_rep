package modifierpack1;


class ParentClass1{
	
}
public class AccessClass1 extends ParentClass1{
	public static void main(String[] args) {
		//cannot access SharedClass private variable outside the class
		System.out.println(SharedClass.fullAddress);
		System.out.println(SharedClass.accountNo);
		System.out.println(SharedClass.city);
	}
}
