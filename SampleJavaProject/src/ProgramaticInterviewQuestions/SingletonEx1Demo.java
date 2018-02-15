package ProgramaticInterviewQuestions;

class SingletonEx1 {
	private static SingletonEx1 singletonex1 = new SingletonEx1( );

	   /* A private Constructor prevents any other
	    * class from instantiating.
	    */
	   private SingletonEx1() { }

	   /* Static 'instance' method */
	   public static SingletonEx1 getInstance( ) {
	      return singletonex1;
	   }

	   /* Other methods protected by singleton-ness */
	   protected static void demoMethod( ) {
	      System.out.println("demoMethod for singleton "+singletonex1);
	   }

}
public class SingletonEx1Demo{
	public static void main(String[] args) {
		SingletonEx1 tmp1 = SingletonEx1.getInstance( );
		tmp1.demoMethod( );
		SingletonEx1 tmp2 = SingletonEx1.getInstance( );
		tmp2.demoMethod( );
	}
}
