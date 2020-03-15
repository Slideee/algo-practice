package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Pink
 * @version : ConditionTest, v 0.1 2020年03月15日 0:42 Pink Exp $
 */
public class ConditionTest {

	static ReentrantLock lock = new ReentrantLock();
	static Condition condition = lock.newCondition();

	public static void main(String[] args) throws InterruptedException {
		//java.util.concurrent.locks.ReentrantLock@69d9c55[Unlocked]

		lock.lock();
		System.out.println("主线程等待通知");
		new Thread(new SignalThread()).start();
		try {
			condition.await();
		} finally {
			lock.unlock();
		}
		System.out.println("主线程恢复运行");
	}

	static class SignalThread implements Runnable {

		@Override
		public void run() {
			lock.lock();
			try {
				condition.signal();
				System.out.println("子线程通知");
			} finally {
				lock.unlock();
			}
		}
	}
}