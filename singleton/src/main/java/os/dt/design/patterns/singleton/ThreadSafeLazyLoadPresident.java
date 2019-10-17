package os.dt.design.patterns.singleton;

/**
 * 线程安全的懒汉写法
 * 缺点每次获取对象都得加锁，效率低下
 * Created by songgr on 2019/10/17.
 */
public class ThreadSafeLazyLoadPresident {

    private static ThreadSafeLazyLoadPresident INSTANCE;

    private ThreadSafeLazyLoadPresident() {

    }

    public static synchronized ThreadSafeLazyLoadPresident getInstance() {
        if (INSTANCE == null) {
            System.out.println("getInstance");
            INSTANCE = new ThreadSafeLazyLoadPresident();
        }
        return INSTANCE;
    }
}
