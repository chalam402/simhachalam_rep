package java8features;

interface Doable1{  
    default void doIt(){  
        System.out.println("Do it now");  
    }  
}  
@FunctionalInterface  
interface Sayable3 extends Doable1{  
    void say(String msg);   // abstract method  
}  
public class ExtendingNonFunctionalInterface implements Sayable3{  
    public void say(String msg){  
        System.out.println(msg);  
    }  
    public static void main(String[] args) {  
    	ExtendingNonFunctionalInterface fie = new ExtendingNonFunctionalInterface();  
        fie.say("Hello there");  
        fie.doIt();  
    }  
}  