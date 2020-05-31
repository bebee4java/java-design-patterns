package os.dt.design.patterns.factory.factoryMethod;

/**
 * Created by songgr on 2020/05/30.
 */
public class Main {
    public static void main(String[] args) {

        new AppleFactory().makePhone().call();
        new LenovoFactory().makePhone().call();
    }
}