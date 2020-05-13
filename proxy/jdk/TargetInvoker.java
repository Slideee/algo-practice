package proxy.jdk;

import proxy.Animal;
import proxy.Cat;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk
 * @author Pink
 * @version : TargetInvoker, v 0.1 2020年05月13日 11:37 Pink Exp $
 */
public class TargetInvoker implements InvocationHandler {
	// 代理中持有的目标类
	private Object target;

	public TargetInvoker(Object target) {
		this.target = target;
	}

	/**
	 * proxy 代理目标对象的代理对象，它是真实的代理对象。 method 执行目标类的方法 args 执行目标类的方法的参数
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before");
		Object result = method.invoke(target, args);
		System.out.println("after");
		return result;
	}
	/**
	 * loader 加载代理对象的类加载器
	 * interfaces 代理对象实现的接口，与目标对象实现同样的接口
	 * h 处理代理对象逻辑的处理器，即上面的 InvocationHandler 实现类。
	 */
	public static Object getProxy(Object object) {
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new TargetInvoker(object));
	}

	public static void main(String[] args) {
		Cat cat = new Cat();
		Animal proxy = (Animal) getProxy(cat);
		proxy.call();
	}
}
