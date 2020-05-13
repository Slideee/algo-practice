package proxy;

/**
 * static proxy
 * @author Pink
 * @version : StaicProxyImpl, v 0.1 2020年05月13日 11:25 Pink Exp $
 */
public class StaicProxyImpl implements Animal {

	private Cat cat;

	public StaicProxyImpl(Cat cat) {
		this.cat = cat;
	}

	@Override
	public void call() {
		System.out.println("before");
		cat.call();
		System.out.println("after");
	}

	public static void main(String[] args) {
		StaicProxyImpl impl = new StaicProxyImpl(new Cat());
		impl.call();
	}
}
