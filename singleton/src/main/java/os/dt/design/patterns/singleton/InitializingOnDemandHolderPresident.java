package os.dt.design.patterns.singleton;

/**
 * 静态内部类方式
 * JVM保持单例 （JVM加载类只加载一次）
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 * Created by songgr on 2019/10/17.
 */
public class InitializingOnDemandHolderPresident {

    private InitializingOnDemandHolderPresident(){

    }

    // 可以做到延迟加载
    private static class SingletonHolder {
        private static final InitializingOnDemandHolderPresident INSTANCE =
                new InitializingOnDemandHolderPresident();
    }

    public static InitializingOnDemandHolderPresident getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
