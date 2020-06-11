package sync;

/**
 * 一个类中的两个 synchronized static 方法之间是否构成同步？构成同步
 * 
 * @author Pink
 *
 * @version $Id: SynchronizedStaticTest2, v 0.1 2020年06月11日 16:03:25  Pink Exp $
 */
public class SynchronizedStaticTest2 {
	public static synchronized void method1() {
		System.out.println("Method 1 start");
		try {
			System.out.println("Method 1 execute");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 1 end");
	}

	public static synchronized void method2() {
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

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				SynchronizedStaticTest2.method1();
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				SynchronizedStaticTest2.method2();
			}
		});
		thread1.start();
		thread2.start();
	}

}
