package os.dt.design.patterns.factory.simpleFactory;

/**
 * Created by songgr on 2020/05/30.
 */
public class Main {

    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory();

        phoneFactory.makePhone("iphone").call();
        phoneFactory.makeLenovo().call();
    }
}
