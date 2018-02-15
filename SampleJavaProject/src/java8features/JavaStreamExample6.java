package java8features;
import java.util.*;  
class Product5{  
    int id;  
    String name;  
    float price;  
    public Product5(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  
public class JavaStreamExample6 {
	public static void main(String[] args) {  
        List<Product5> productsList = new ArrayList<Product5>();  
        //Adding Products  
        productsList.add(new Product5(1,"HP Laptop",25000f));  
        productsList.add(new Product5(2,"Dell Laptop",30000f));  
        productsList.add(new Product5(3,"Lenevo Laptop",28000f));  
        productsList.add(new Product5(4,"Sony Laptop",28000f));  
        productsList.add(new Product5(5,"Apple Laptop",90000f));  
        // max() method to get max Product price   
        Product5 productA = productsList.stream()  
                        .max((product1, product2) -> product1.price > product2.price ? 1: -1).get();  
          
        System.out.println(productA.price);  
        // min() method to get min Product price  
        Product5 productB = productsList.stream()  
                .max((product1, product2) -> product1.price < product2.price ? 1: -1).get();  
        System.out.println(productB.price);  
          
    }  
}
