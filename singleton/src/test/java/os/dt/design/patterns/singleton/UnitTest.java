package os.dt.design.patterns.singleton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 测试
 * Created by songgr on 2019/10/17.
 */

public class UnitTest {

    private List<Object> objs = null;

    class CreateObj implements Runnable {
        private Object obj = null;

        private Supplier function;
        public CreateObj(Supplier function) {
            this.function = function;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + ": I get a obj.");
            Object obj = function.get();
            objs.add(obj);
        }
    }

    @Before
    public void init() {
        objs = new ArrayList<Object>(4);
    }


    @Test
    public void hungryPresident() throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);

        /*Supplier function = () -> HungryPresident.getInstance();
        System.out.println(function.getClass());
        function.get();*/

        fixedThreadPool.submit(new CreateObj(() -> HungryPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> HungryPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> HungryPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> HungryPresident.getInstance()));

        fixedThreadPool.awaitTermination(4, TimeUnit.SECONDS);

    }

    @After
    public void check() {
        assert objs.size() > 1;
        objs.stream().reduce((a,b) -> a == b);
        objs.stream().forEach(a -> System.out.println(a.getClass()));
    }


}
