package os.dt.design.patterns.singleton;

/**
 * 枚举式
 * 不仅线程安全，还可以反序列化
 * （有点别扭）
 * Created by songgr on 2019/10/17.
 */
public enum  EnumPresident {
    INSTANCE;

    public void run(){
        System.out.println("EnumPresident run ...");
    }

}
