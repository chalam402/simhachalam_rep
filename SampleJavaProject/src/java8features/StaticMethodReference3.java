package java8features;

import java.util.function.BiFunction;

class Arithmetic {
	public static int add(int a, int b) {
		return a + b;
	}
}

public class StaticMethodReference3 {
	public static void main(String[] args) {
		
		//Using Method Reference and overriding static methods
		BiFunction<Integer, Integer, Integer> adder = Arithmetic::add;
		int result = adder.apply(10, 20);
		System.out.println("Using Method Reference: "+result);
		
		//Using Lambda Expressions
		BiFunction<Integer, Integer, Integer> adder1 = (a, b)->{return (a+b);};
		int result1 = adder1.apply(54, 3453);
		System.out.println("Using Lambda Expressions: "+result1);
		
	}
}
