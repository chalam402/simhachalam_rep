import java.io.IOException;


class SuperClass3{
	public String getMethod1() throws IOException
	{
		return "";
	}
}
 

public class MethodsOverridingWithCheckedException extends SuperClass3{
	@Override
	public String getMethod1() throws IOException {
		// TODO Auto-generated method stub
		return super.getMethod1();
	}
}	
