/**
 * @author:hxd
 * @date:2020/8/6
 */
public interface Interceptor {
    public static final String s = "";

    void sayHello();

    static void staticMethod() {
        System.out.println("接口中的静态方法");
    }

    default void defaultMethod() {
        System.out.println("默认方法");
    }
}
