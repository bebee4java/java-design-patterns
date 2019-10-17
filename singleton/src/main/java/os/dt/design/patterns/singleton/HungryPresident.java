package os.dt.design.patterns.singleton;

/**
 * 饿汉式写法
 * （简单实用，比较推荐）
 * 类加载到内存后，只实例化一个实例，JVM保证线程安全的
 * 缺点：实例不管后续有没有使用，类加载实就完成实例化 （但是话说如果这个类不用的话，你也没必要加载呀）
 *
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
