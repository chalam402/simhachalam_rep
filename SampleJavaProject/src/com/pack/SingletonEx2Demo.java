package com.pack;

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
		SingletonEx1 tmp1 = SingletonEx1.getInstance( );
		tmp1.demoMethod( );
		SingletonEx1 tmp2 = SingletonEx1.getInstance( );
		tmp2.demoMethod( );
	}
}

