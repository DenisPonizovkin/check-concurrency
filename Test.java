import java.io.IOException;
import java.util.Arrays;

public class Test {
	static int n = 10;
	
	//static ArrayListSynch data = new ArrayListSynch(n);
	static ArrayListNotSynch data = new ArrayListNotSynch(n);

	static class TestThread implements Runnable {

		int mElement;

		public TestThread(int n) {
			mElement = n;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			data.add(mElement);
		}
	}
	
	public static void main(String args[]) throws IOException {
		System.out.println("Start");
		
		Thread[] threads = new Thread[n];	
		for (int i = 0; i < n; i++) {
            threads[i] = new Thread(new TestThread(i));
        }

		for (int i = 0; i < n; i++) {
            threads[i].start();
		}

		for (int i = 0; i < n; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		data.sort();
		data.printAndCheck();
		
		System.out.println("End");
	}
}
