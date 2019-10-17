package os.dt.design.patterns.singleton;

/**
 * 懒汉式写法
 * 虽然不用在类加载是实例化做到了按需去初始化，但实例线程不安全
 * Created by songgr on 2019/10/17.
 */
public class LazyLoadPresident {

    private static LazyLoadPresident INSTANCE;

    private LazyLoadPresident() {

    }

    public static LazyLoadPresident getInstance() {

        if (INSTANCE == null) {
            System.out.println("getInstance");
            INSTANCE = new LazyLoadPresident();
        }

        return INSTANCE;
    }
}
