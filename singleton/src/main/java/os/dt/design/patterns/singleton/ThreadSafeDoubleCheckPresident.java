package os.dt.design.patterns.singleton;

/**
 * 线程安全的双重检查方式
 * Created by songgr on 2019/10/17.
 */
public class ThreadSafeDoubleCheckPresident {

    // 必须加volatile
    private static volatile ThreadSafeDoubleCheckPresident INSTANCE;

    private ThreadSafeDoubleCheckPresident() {

    }

    public static ThreadSafeDoubleCheckPresident getInstance() {
        if (INSTANCE == null) {  // 这层判断是有必要的 大多数情况下INSTANCE不为null直接返回了，减少了加锁的操作
            System.out.println("getInstance");
            synchronized (ThreadSafeDoubleCheckPresident.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ThreadSafeDoubleCheckPresident();
                }
            }
        }

        return INSTANCE;
    }

}
