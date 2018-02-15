package java8features;

import java.util.function.BiFunction;
import java.util.function.LongToIntFunction;

class Arithmetic1 {
	public static int add(int a, int b) {
		return a + b;
	}

	public static float add(int a, float b) {
		return a + b;
	}

	public static float add(float a, float b) {
		return a + b;
	}
	
	public static int add(long a) {
		return (int) (long)a;
	}
}

public class StaticMethodReference4 {
	public static void main(String[] args) {
		//override static methods by referring methods
		BiFunction<Integer, Integer, Integer> adder1 = Arithmetic1::add;
		BiFunction<Integer, Float, Float> adder2 = Arithmetic1::add;
		BiFunction<Float, Float, Float> adder3 = Arithmetic1::add;
		
		LongToIntFunction longToInt = Arithmetic1::add;
		
		int result1 = adder1.apply(10, 20);
		float result2 = adder2.apply(10, 20.0f);
		float result3 = adder3.apply(10.0f, 20.0f);
		
		int result4 = longToInt.applyAsInt(1234L);
		
		System.out.println("int add(int a, int b) "+result1);
		System.out.println("float add(int a, float b) "+result2);
		System.out.println("float add(float a, float b) "+result3);
		
		System.out.println("int add(long a) "+result4);
	}
}
