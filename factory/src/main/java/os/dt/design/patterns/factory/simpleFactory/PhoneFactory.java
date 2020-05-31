package os.dt.design.patterns.factory.simpleFactory;

/**
 * Created by songgr on 2020/05/30.
 */
public class PhoneFactory {

    public static Iphone makeIphone() {
        return new Iphone();
    }

    public static Lenovo makeLenovo() {
        return new Lenovo();
    }

    public Phone makePhone(String phoneType) {
        if(phoneType.equalsIgnoreCase("iphone")){
            return new Iphone();
        }
        else if(phoneType.equalsIgnoreCase("lenovo")) {
            return new Lenovo();
        }
        return null;
    }
}
