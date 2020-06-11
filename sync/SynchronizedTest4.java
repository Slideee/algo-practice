package sync;

/**
 * @author Pink
 * @version : SynchronizedTest4, v 0.1 2020年06月11日 16:07 Pink Exp $
 */
public class SynchronizedTest4 implements Runnable {
	static SynchronizedTest4 instance = new SynchronizedTest4();
	static int i = 0;

	@Override
	public void run() {
		// 省略其他耗时操作....
		// 使用同步代码块对变量i进行同步操作,锁对象为instance
//		synchronized (instance) {
//			for (int j = 0; j < 10000; j++) {
//				i++;
//			}
//		}
//		//this,当前实例对象锁
//		synchronized(this){
//			for(int j=0;j<10000;j++){
//				i++;
//			}
//		}
		//class对象锁
		synchronized(SynchronizedTest4.class){
			for(int j=0;j<10000;j++){
				i++;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}

}
