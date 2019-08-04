package ThreadLearn.consumerAndProductor2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CAndPTest {
    public static final Integer initBoxSize = 5;

    public static void main(String[] args) {
        BlockingDeque<Integer> appleBox = new LinkedBlockingDeque<>(5);
        AtomicInteger initNum = new AtomicInteger(0);
        List<Producer> producers = new ArrayList<>(3);
        List<Consumer> consumers = new ArrayList<>(3);

        for (int i = 0 ; i< 3 ;i++){
            Producer producer = new Producer("P_1",appleBox,initNum);
            producers.add(producer);
            producer.start();
            Consumer consumer = new Consumer("C_1",appleBox);
            consumers.add(consumer);
            consumer.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0 ; i < 3 ;i++){
            producers.get(i).shutdownThread();
            consumers.get(i).shutdownThread();
        }

    }
}
class Producer extends Thread {

    private String name;

    private BlockingDeque<Integer> appleBox;

    private AtomicInteger appleCurrentNum;

    private Boolean flag = true;

    Producer(String name, BlockingDeque<Integer> appleBox, AtomicInteger appleCurrentNum) {
        this.name = name;
        this.appleBox = appleBox;
        this.appleCurrentNum = appleCurrentNum;
    }

    @Override
    public void run() {
        while (flag) {
            int apple = appleCurrentNum.addAndGet(1);
            Integer thePutElement;
            try {
                boolean isOffer = appleBox.offer(apple,2, TimeUnit.SECONDS);
                if (isOffer){
                    System.out.println("[ " + name + " 生产者 线程：" +this.getName() + " ] 生产了编号为-" + apple + "-号苹果，当前苹果有：" + appleBox + "");
                } else{
                    System.out.println("[ " + name +" 生产者 线程 "+ this.getName() + " ] 正在生产苹果 ,但是队列已满等待消费者消费，当前苹果有：" + appleBox +"");
                }
                Thread.sleep(new Random().nextInt(1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdownThread(){
        this.flag = false;
    }
}

class Consumer extends Thread {

    private String name;

    private BlockingDeque<Integer> appleBox;

    private Boolean flag = true;

    Consumer(String name, BlockingDeque<Integer> appleBox) {
        this.name = name;
        this.appleBox = appleBox;
    }

    @Override
    public void run() {
        while (flag) {
            Integer apple = 0;
            try {
                apple = appleBox.poll(2,TimeUnit.SECONDS);
                //下面的代码可能不会立刻紧接着poll执行，因为poll之后已经释放了锁了，那么大家所看到的输出很可能就是看起来不是
                if (apple == null){
                    //因为toString()不是阻塞的，所以在输出容易的时候，大家可能不会觉得这是线程安全的，但是实际上，这就是线程安全的
                    System.out.println("[ " + name +" 消费者，线程： "+ this.getName() + "] 没有苹果可以消费，进入阻塞状态等待生产者生产，当前苹果有：" + appleBox);
                }else{
                    System.out.println("[ " + name +" 消费者，线程："+ this.getName() + " ] 消费了编号为-" + apple + "-号苹果，当前苹果有：" + appleBox);
                }
                Thread.sleep(new Random().nextInt(1000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void shutdownThread(){
        this.flag = false;
    }

}


