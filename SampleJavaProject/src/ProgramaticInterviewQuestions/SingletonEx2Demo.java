package ProgramaticInterviewQuestions;

class SingletonEx2 {
	private static SingletonEx2 instance = null;
	   private SingletonEx2() {
	      // Exists only to defeat instantiation.
	   }

	   public static SingletonEx2 getInstance() {
	      if(instance == null) {
	         instance = new SingletonEx2();
	      }
	      return instance;
	   }
}
public class SingletonEx2Demo{
	public static void main(String[] args) {
		SingletonEx2 tmp1 = SingletonEx2.getInstance( );
		System.out.println(tmp1);
		SingletonEx2 tmp2 = SingletonEx2.getInstance( );
		System.out.println(tmp2);
	}
}

