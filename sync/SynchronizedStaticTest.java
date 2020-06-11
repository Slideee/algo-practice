package sync;

/**
 * @author Pink
 * @version : SynchronizedStaticTest, v 0.1 2020年06月11日 15:40 Pink Exp $
 */
public class SynchronizedStaticTest implements Runnable {
	// 共享资源
	static int i = 0;

	/**
	 * synchronized 修饰实例方法
	 */
	public static synchronized void increase() {
		i++;
	}

	@Override
	public void run() {
		for (int j = 0; j < 10000; j++) {
			increase();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		// 两个线程实例化两个不同的对象，但是访问的方法是静态的，两个线程发生了互斥（即一个线程访问，另一个线程只能等着），
		// 因为静态方法是依附于类而不是对象的，当synchronized修饰静态方法时，锁是class对象。
		// 一个类中的两个 synchronized static 方法之间是否构成同步？构成同步。
		Thread t1 = new Thread(new SynchronizedStaticTest());
		Thread t2 = new Thread(new SynchronizedStaticTest());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}

}
