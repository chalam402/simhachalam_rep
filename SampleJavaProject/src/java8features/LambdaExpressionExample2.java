package java8features;

@FunctionalInterface  //It is optional  
interface Drawable{  
    public void draw(String demo);  
}  
  
public class LambdaExpressionExample2 {  
    public static void main(String[] args) {  
        int width=10;  
          
        //with lambda  
        Drawable d2=(demo)->{  
            System.out.println(demo+" Drawing Argumented Width = "+width); //Secondly control comes here  
        };  
        d2.draw("Simhachalam");  //First control comes here
        
    }  
}  