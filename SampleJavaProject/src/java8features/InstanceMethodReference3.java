package java8features;

import java.util.function.BiFunction;

class Arithmetic2 {
	public int add(int a, int b) {
		return a + b;
	}
}
//In the following example, we are using BiFunction interface(Functional Interface) with only one method. 
//It is a predefined interface and contains a functional method apply(). Here, we are referring add method to apply method.
public class InstanceMethodReference3 {
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> adder = new Arithmetic2()::add;
		int result = adder.apply(10, 20);
		System.out.println(result);
	}
}
