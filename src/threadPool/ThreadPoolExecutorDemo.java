package threadPool;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Pink
 * @version : ThreadPoolExecutorDemo, v 0.1 2020年02月27日 17:47 Pink Exp $
 */
public class ThreadPoolExecutorDemo {

	private static final int CORE_POOL_SIZE = 5;
	private static final int MAX_POOL_SIZE = 10;
	private static final int QUEUE_CAPACITY = 10;
	private static final Long KEEP_ALIVE_TIME = 1L;

	public static class MyRunnable implements Runnable {

		private String command;

		public MyRunnable(String s) {
			this.command = s;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
			processCommand();
			System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
		}

		private void processCommand() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Override
		public String toString() {
			return this.command;
		}

	}

	public static void main(String[] args) {

		// 使用阿里巴巴推荐的创建线程池的方式
		// 通过ThreadPoolExecutor构造函数自定义参数创建
		ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_CAPACITY),
				new ThreadPoolExecutor.CallerRunsPolicy());

		for (int i = 0; i < 30; i++) {
			// 创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
			Runnable worker = new MyRunnable("" + i);
			// 执行Runnable
			executor.execute(worker);
		}
		// 终止线程池
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}
}