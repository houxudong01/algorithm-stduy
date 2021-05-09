/**
 * @author:hxd
 * @date:2020/8/6
 */
public class App2 {
    public static void main(String[] args) {
        Interceptor.staticMethod();
        InterceptorImpl interceptor = new InterceptorImpl();
        interceptor.defaultMethod();
    }
}
