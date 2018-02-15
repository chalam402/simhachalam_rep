package java8features;
import java.util.*;  
import java.util.stream.Collectors;  
class Product4{  
    int id;  
    String name;  
    float price;  
    public Product4(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
} 
public class JavaStreamExample5 {
	 public static void main(String[] args) {  
	        List<Product4> productsList = new ArrayList<Product4>();  
	        //Adding Products  
	        productsList.add(new Product4(1,"HP Laptop",25000f));  
	        productsList.add(new Product4(2,"Dell Laptop",30000f));  
	        productsList.add(new Product4(3,"Lenevo Laptop",28000f));  
	        productsList.add(new Product4(4,"Sony Laptop",28000f));  
	        productsList.add(new Product4(5,"Apple Laptop",90000f));  
	        // Using Collectors's method to sum the prices.  
	        double totalPrice3 = productsList.stream()  
	                        .collect(Collectors.summingDouble(product->product.price));  
	        System.out.println(totalPrice3);  
	          
	    }
}
