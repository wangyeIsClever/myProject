package ThreadLearn.consumerAndProductor;


import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class Producer extends Thread {

    private String name;

    private LinkedList<Integer> appleBox;

    private Integer boxSize;

    private AtomicInteger appleCurrentNum;

    Producer(String name, LinkedList<Integer> appleBox, Integer boxSize, AtomicInteger appleCurrentNum) {
        this.name = name;
        this.appleBox = appleBox;
        this.boxSize = boxSize;
        this.appleCurrentNum = appleCurrentNum;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (appleBox) {
                if (appleBox.size() < boxSize) {
                    Integer apple = appleCurrentNum.addAndGet(1);
                    appleBox.addFirst(apple);
                    System.out.println("[ " + name + " 生产者 线程：" +this.getName() + " ] 生产了编号为-" + apple + "-号苹果，当前苹果有：" + appleBox.size() + "个");
                    try {
                        //模拟生产者生产过程，sleep不会释放锁
                        Thread.sleep(new Random().nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //唤醒消费者
                    appleBox.notifyAll();//随机生产和消费，但是不会立即释放锁，要等到下面的代码执行完才释放锁
                    //如果加了下面这个，生产者就不会生产到满，消费者就可能会消费了，更适合实际情况，其他的生产者线程也会有生产的机会
                    try {
                        //生产之后进入立刻阻塞状态，让消费者消费
                        appleBox.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        appleBox.notifyAll();//如果发生异常，唤醒其他线程继续执行
                    }
                } else {
                    try {
                        System.out.println("[ " + name +" 生产者 线程 "+ this.getName() + " ] 正在生产苹果 ,但是队列已满等待消费者消费，当前苹果有：" + appleBox.size() +"个");
                        //队列已满，进入阻塞状态，等待消费者消费
                        appleBox.wait();//随机生产和消费
                    } catch (InterruptedException e) {
                        appleBox.notifyAll();
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
class Consumer extends Thread {

        private String name;

        private LinkedList<Integer> appleBox;

        private Integer boxSize;

        Consumer(String name, LinkedList<Integer> appleBox, Integer boxSize) {
            this.name = name;
            this.appleBox = appleBox;
            this.boxSize = boxSize;

        }

        @Override
        public void run() {
            while (true) {
                synchronized (appleBox) {
                    //如果队列是空的，消费者进入阻塞状态,等待生产者生产并唤醒
                    if (appleBox.isEmpty()) {
                        System.out.println("[ " + name +" 消费者，线程： "+ this.getName() + "] 没有苹果可以消费，进入阻塞状态等待生产者生产，当前苹果有：" + appleBox.size() + "个");
                        try {
                            //进入阻塞状态释放队列锁，因为只有两个线程，所以生产者一定会获取到队列锁执行
                            appleBox.wait();//随机生产和消费
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            //如果发送异常，主动唤醒生产者线程执行
                            appleBox.notifyAll();
                        }
                    } else {
                        //如果队列不空，就消费产品，并唤醒生产者
                        //注意唤醒生产者，在消费者执行完毕释放锁之后，不一定生产者就会获得锁，也许消费者会继续获取锁执行
                        //但是如果不唤醒生产者，那么如果生产者处于阻塞状态，当队列为空，消费者也进入阻塞状态那么就没有线程可以获取锁继续执行了
                        appleBox.notifyAll();//随机生产和消费,这里可能唤醒的是生产者，有可能唤醒的是消费者，但是不会马上释放锁，要等到下面的代码执行完才释放
                        try {
                            //模拟消费者消费过程，sleep不会释放锁
                            Thread.sleep(new Random().nextInt(10));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Integer apple = appleBox.removeLast();
                        System.out.println("[ " + name +" 消费者，线程："+ this.getName() + " ] 消费了编号为-" + apple + "-号苹果，当前苹果有：" + appleBox.size() + "个");
                        //如果加了下面这个，消费者者就不会消费到完，生产者者就可能会生产了，更适合实际情况，其他的消费者线程也会有消费的机会
                        try {
                            //消费之后立刻进入阻塞状态，让生产者生产
                            appleBox.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            appleBox.notifyAll();
                        }
                    }
                }

            }
        }
}

public class conusmerAndProductTest {

    public static void main(String[] args) {
        LinkedList<Integer> appleBox = new LinkedList<>();
        Integer boxSize = 5;
        AtomicInteger initNum = new AtomicInteger(0);
        Producer producer1 = new Producer("P_1",appleBox,boxSize,initNum);
        Producer producer2 = new Producer("P_2",appleBox,boxSize,initNum);
        Producer producer3 = new Producer("P_3",appleBox,boxSize,initNum);
        Consumer consumer1 = new Consumer("C_1",appleBox,boxSize);
        Consumer consumer2 = new Consumer("C_2",appleBox,boxSize);
        Consumer consumer3 = new Consumer("C_3",appleBox,boxSize);

        consumer1.start();
        consumer2.start();
        consumer3.start();
        producer1.start();
        producer2.start();
        producer3.start();

    }

}
