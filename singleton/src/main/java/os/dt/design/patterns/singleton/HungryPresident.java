package os.dt.design.patterns.singleton;

/**
 * 饿汉式写法
 * Created by songgr on 2019/10/17.
 */
public class HungryPresident {

    private static final HungryPresident INSTANCE = new HungryPresident();

    // 私有化构造方法
    private HungryPresident(){

    }

    public static HungryPresident getInstance() {
        System.out.println("getInstance");
        return INSTANCE;
    }
}
