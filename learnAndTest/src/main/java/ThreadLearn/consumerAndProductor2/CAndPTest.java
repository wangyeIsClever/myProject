package ThreadLearn.consumerAndProductor2;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class CAndPTest {
    public static final Integer initBoxSize = 5;

    public static void main(String[] args) {
        BlockingDeque<Integer> appleBox = new LinkedBlockingDeque<>(5);
        AtomicInteger initNum = new AtomicInteger(0);

        Producer producer1 = new Producer("P_1",appleBox,initNum);
        Producer producer2 = new Producer("P_2",appleBox,initNum);
        Producer producer3 = new Producer("P_3",appleBox,initNum);
        Consumer consumer1 = new Consumer("C_1",appleBox);
        Consumer consumer2 = new Consumer("C_2",appleBox);
        Consumer consumer3 = new Consumer("C_3",appleBox);

        consumer1.start();
        consumer2.start();
        consumer3.start();
        producer1.start();
        producer2.start();
        producer3.start();
    }
}
class Producer extends Thread {

    private String name;

    private BlockingDeque<Integer> appleBox;

    private AtomicInteger appleCurrentNum;

    Producer(String name, BlockingDeque<Integer> appleBox, AtomicInteger appleCurrentNum) {
        this.name = name;
        this.appleBox = appleBox;
        this.appleCurrentNum = appleCurrentNum;
    }

    @Override
    public void run() {
        while (true) {
            int apple = appleCurrentNum.addAndGet(1);
            Integer thePutElement;
            try {

                appleBox.putFirst(apple);
                thePutElement = appleBox.peekLast();
                if (thePutElement != null){
                    System.out.println("[ " + name + " 生产者 线程：" +this.getName() + " ] 生产了编号为-" + apple + "-号苹果，当前苹果有：" + appleBox.size() + "个");
                } else{
                    System.out.println("[ " + name +" 生产者 线程 "+ this.getName() + " ] 正在生产苹果 ,但是队列已满等待消费者消费，当前苹果有：" + appleBox.size() +"个");
                }
                //Thread.sleep(new Random().nextInt(1000));


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Consumer extends Thread {

    private String name;

    private BlockingDeque<Integer> appleBox;

    Consumer(String name, BlockingDeque<Integer> appleBox) {
        this.name = name;
        this.appleBox = appleBox;
    }

    @Override
    public void run() {
        while (true) {
            Integer apple = 0;
            try {
                apple = appleBox.takeLast();
                if (apple == null){
                    System.out.println("[ " + name +" 消费者，线程： "+ this.getName() + "] 没有苹果可以消费，进入阻塞状态等待生产者生产，当前苹果有：" + appleBox.size() + "个");
                }else{
                    System.out.println("[ " + name +" 消费者，线程："+ this.getName() + " ] 消费了编号为-" + apple + "-号苹果，当前苹果有：" + appleBox.size() + "个");
                }
                    //Thread.sleep(new Random().nextInt(1000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


