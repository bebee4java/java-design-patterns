package os.dt.design.patterns.singleton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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
            System.out.println(obj.hashCode());
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

    @Test
    public void lazyLoadPresident() throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);

        fixedThreadPool.submit(new CreateObj(() -> LazyLoadPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> LazyLoadPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> LazyLoadPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> LazyLoadPresident.getInstance()));

        fixedThreadPool.awaitTermination(4, TimeUnit.SECONDS);

    }

    @Test
    public void threadSafelazyLoadPresident() throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);

        fixedThreadPool.submit(new CreateObj(() -> ThreadSafeLazyLoadPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> ThreadSafeLazyLoadPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> ThreadSafeLazyLoadPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> ThreadSafeLazyLoadPresident.getInstance()));

        fixedThreadPool.awaitTermination(4, TimeUnit.SECONDS);

    }

    @Test
    public void threadSafeDoubleCheckPredident() throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);

        fixedThreadPool.submit(new CreateObj(() -> ThreadSafeDoubleCheckPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> ThreadSafeDoubleCheckPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> ThreadSafeDoubleCheckPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> ThreadSafeDoubleCheckPresident.getInstance()));

        fixedThreadPool.awaitTermination(4, TimeUnit.SECONDS);

    }


    @Test
    public void initializingOnDemandHolderPresident() throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);

        fixedThreadPool.submit(new CreateObj(() -> InitializingOnDemandHolderPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> InitializingOnDemandHolderPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> InitializingOnDemandHolderPresident.getInstance()));
        fixedThreadPool.submit(new CreateObj(() -> InitializingOnDemandHolderPresident.getInstance()));

        fixedThreadPool.awaitTermination(4, TimeUnit.SECONDS);

    }


    @Test
    public void enumPresident() throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);

        EnumPresident.INSTANCE.run();

        fixedThreadPool.submit(new CreateObj(() -> EnumPresident.INSTANCE));
        fixedThreadPool.submit(new CreateObj(() -> EnumPresident.INSTANCE));
        fixedThreadPool.submit(new CreateObj(() -> EnumPresident.INSTANCE));
        fixedThreadPool.submit(new CreateObj(() -> EnumPresident.INSTANCE));

        fixedThreadPool.awaitTermination(4, TimeUnit.SECONDS);

    }




    @After
    public void check() {
        assert objs.size() == 4;

        for (int i=0; i<objs.size()-1; i++){
            for (int j=i+1; j<objs.size(); j++){
                assert objs.get(i) == objs.get(j);
            }
        }

        objs.stream().forEach(a -> System.out.println(a.getClass() + " " + a.hashCode()));
    }


}
