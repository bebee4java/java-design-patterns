package os.dt.design.patterns.factory.abstractFactory;

import os.dt.design.patterns.factory.simpleFactory.Iphone;
import os.dt.design.patterns.factory.simpleFactory.Phone;

/**
 * Created by songgr on 2020/05/31.
 */
public class AppleFactory implements AbstractFactory {
    public Phone makePhone() {
        return new Iphone();
    }

    public PC makePC() {
        return new MacBook();
    }
}
