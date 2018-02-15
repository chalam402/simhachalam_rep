package CreationalDesignPattern;

public class SingletonPatternExample_1 {

	// Static member holds only one instance of the
    // SingletonExample class
    private static SingletonPatternExample_1 singletonInstance;
    // SingletonPatternExample_1 prevents any other class from instantiating
    private SingletonPatternExample_1() {
    }
    // Providing Global point of access
    public static SingletonPatternExample_1 getSingletonInstance() {
        if (null == singletonInstance) {
            singletonInstance = new SingletonPatternExample_1();
        }
        return singletonInstance;
    }
    public void printSingleton(){
        System.out.println("Inside print Singleton");
    }
    
    public static void main(String[] args) {
    	SingletonPatternExample_1.getSingletonInstance().printSingleton();
    	SingletonPatternExample_1.getSingletonInstance().printSingleton();
    	SingletonPatternExample_1.getSingletonInstance().printSingleton();
    	SingletonPatternExample_1.getSingletonInstance().printSingleton();
    }
    
}