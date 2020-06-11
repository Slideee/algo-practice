package sync;

/**
 * 一个线程获取了该对象的锁之后，其他线程来访问其他synchronized实例方法现象
 * 
 * 所有的非静态同步方法用的都是同一把锁——实例对象本身
 *
 * @author Pink
 * @version : SynchronizedTest2, v 0.1 2020年06月11日 15:32 Pink Exp $
 */
public class SynchronizedTest2 {
	public synchronized void method1() {
		System.out.println("Method 1 start");
		try {
			System.out.println("Method 1 execute");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 1 end");
	}

	public synchronized void method2() {
		System.out.println("Method 2 start");
		try {
			System.out.println("Method 2 execute");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 2 end");
	}

	public static void main(String[] args) {

		final SynchronizedTest2 test = new SynchronizedTest2();
		new Thread(test::method1).start();
		new Thread(test::method2).start();

		// 不同实例不构成同步，因为两个线程作用于不同的对象，获得的是不同的锁，所以互相并不影响
		// final SynchronizedTest2 test1 = new SynchronizedTest2();
		// final SynchronizedTest2 test2 = new SynchronizedTest2();
		// new Thread(test1::method1).start();
		// new Thread(test2::method2).start();
	}

}
