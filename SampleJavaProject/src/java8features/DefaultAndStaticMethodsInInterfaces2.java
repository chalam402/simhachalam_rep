package java8features;

@FunctionalInterface
public interface DefaultAndStaticMethodsInInterfaces2 {
	
	void method2();
	
	default void log(String str){
		System.out.println("I2 logging::"+str);
	}

}
