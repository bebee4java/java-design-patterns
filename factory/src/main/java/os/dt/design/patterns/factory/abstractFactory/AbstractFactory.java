package os.dt.design.patterns.factory.abstractFactory;

import os.dt.design.patterns.factory.simpleFactory.Phone;

public interface AbstractFactory {
    Phone makePhone();
    PC makePC();
}
