package threads;
class SampleThread extends Thread{
	@Override
	public void run() {
		
		super.run();
	}
}
public class ThreadsSampleTestClass {
	public static void main(String[] args) {
		SampleThread st = new SampleThread();
		st.start(); //we cannot set id for an thread
	}
}
