package things.before.java8;

public class RunnableUsingImplement implements Runnable {
	@Override
	public void run() {
		System.out.println("Output Using Implemenmt");
	}
}

class UsingRunnable {

	public static void main(String[] args) {
		RunnableUsingImplement runnable = new RunnableUsingImplement();
		Thread thread = new Thread(runnable);
		thread.start();
	}
}