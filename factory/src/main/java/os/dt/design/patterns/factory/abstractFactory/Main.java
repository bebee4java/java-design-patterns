package os.dt.design.patterns.factory.abstractFactory;

/**
 * Created by songgr on 2020/05/31.
 */
public class Main {
    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        appleFactory.makePC().play();
        appleFactory.makePhone().call();
    }
}
