package java8features;

import java.util.Arrays;

public class LambdaExpressions {
	public static void main(String[] args) {
		Arrays.asList( "a", "b", "d" ).forEach( e -> System.out.println("First "+e ) );
		System.out.println("================================================");
		Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println("Second "+e ) );
		System.out.println("================================================");
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ));
	}
}
