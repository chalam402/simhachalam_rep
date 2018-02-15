package java8features;


public class DefaultAndStaticMethodsInInterfacesImpl implements DefaultAndStaticMethodsInInterfaces1, DefaultAndStaticMethodsInInterfaces2 {

	@Override
	public void method2() {
		
	}

	@Override
	public void method1(String str) {
		
	}
	
	@Override
	public void log(String str){
		System.out.println("DefaultAndStaticMethodsInInterfacesImpl logging::"+str);
		DefaultAndStaticMethodsInInterfaces1.print("abc"); //calling static method in interface
	}
	
	public static void main(String[] args) {
		new DefaultAndStaticMethodsInInterfacesImpl().log("SimhaChalam Pydana");
		
	}
}
