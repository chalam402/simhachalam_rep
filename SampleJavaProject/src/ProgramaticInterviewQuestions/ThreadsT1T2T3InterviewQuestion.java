package ProgramaticInterviewQuestions;
class ThreadClass implements Runnable{
	private String name;
	public ThreadClass(String name){
		this.name = name;
	}
	@Override
	public void run() {
		for(int i=0;i<2;i++){
			System.out.println(name+ " is UP: "+i);
			try {
	            Thread.sleep(1000);
	        } catch (InterruptedException ex) {
	            ex.printStackTrace();
	        }
		}
		System.out.println(name + " End.");
	}
}

public class ThreadsT1T2T3InterviewQuestion {
	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadClass("Thread1"));
		Thread t2= new Thread(new ThreadClass("Thread2"));
		Thread t3= new Thread(new ThreadClass("Thread3"));
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
