/**
 * @author:hxd
 * @date:2020/4/4
 */
public class Demo {
    public static void main(String[] args) {
        Double a = 1d;
        Integer b = 1;
        Double c = 1.0;
        Float d = 1f;
        Long e = 1L;
        System.out.println(a.equals(b));
        System.out.println(b.equals(a));
        System.out.println(d.equals(a));
        System.out.println(e.equals(b));
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
