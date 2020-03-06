package pc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Pink
 * @version : ProducerConsumer, v 0.1 2020年03月06日 10:25 Pink Exp $
 */
public class ProducerConsumer {
	private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

	private static class Producer extends Thread {
		@Override
		public void run() {
			try {
				queue.put("product");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Producer");
		}
	}

	private static class Consumer extends Thread {

		public void run() {
			try {
				String product = queue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("consumer");
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			Producer pro = new Producer();
			pro.start();
		}
		for (int i = 0; i < 5; i++) {
			Consumer con = new Consumer();
			con.start();
		}
		for (int i = 0; i < 3; i++) {
			Producer pro = new Producer();
			pro.start();
		}
	}

}
