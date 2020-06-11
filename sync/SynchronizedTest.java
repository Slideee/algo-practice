package sync;

/**
 * 多个线程访问同一个对象的同一个方法
 *
 * @author Pink
 *
 * @version $Id: synchronizedTest, v 0.1 2020年06月11日 15:29:33  Pink Exp $
 */
public class SynchronizedTest implements Runnable {
	//共享资源
	static int i =0;
	/**
	 * synchronized 修饰实例方法
	 */
	public synchronized void increase(){
		i++;
	}
	@Override
	public void run(){
		for (int j =0 ; j<10000;j++){
			increase();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		SynchronizedTest test = new SynchronizedTest();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
}
