package os.dt.design.patterns.factory.factoryMethod;

import os.dt.design.patterns.factory.simpleFactory.Lenovo;
import os.dt.design.patterns.factory.simpleFactory.Phone;

/**
 * Created by songgr on 2020/05/31.
 */
public class LenovoFactory implements AbstractFactory {

    public Phone makePhone() {
        return new Lenovo();
    }
}
