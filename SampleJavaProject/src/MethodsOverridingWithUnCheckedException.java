
class SuperClass2{
	public String getMethod1() throws NullPointerException
	{
		return "";
	}
}
public class MethodsOverridingWithUnCheckedException extends SuperClass2{
	@Override
	public String getMethod1() throws RuntimeException {
		return super.getMethod1();
	}
}
//Method throws NullPointerException in super class, can we override it with a method which throws RuntimeException?
//Ans: Yes, We can override it with unchecked exception. But it will not happened with Checked Exception. 
