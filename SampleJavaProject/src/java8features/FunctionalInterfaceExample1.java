package java8features;

@FunctionalInterface  
interface sayable1{  
    void say(String msg);  
}  
public class FunctionalInterfaceExample1 implements sayable1{  
    public void say(String msg){  
        System.out.println(msg);  
    }  
    public static void main(String[] args) {  
        FunctionalInterfaceExample1 fie = new FunctionalInterfaceExample1();  
        fie.say("Hello there");  
    }  
}  