package ThreadLearn.consumerAndProductor3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CAndPTest {
    public static final Integer initBoxSize = 5;

    public static void main(String[] args) {
        LinkedList<Integer> appleBox = new LinkedList<>();
        Integer boxSize = 5;
        AtomicInteger initNum = new AtomicInteger(0);
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        List<Producer> producers = new ArrayList<>(3);
        List<Consumer> consumers = new ArrayList<>(3);
        for (int i = 0 ; i< 3 ;i++){
            Producer producer = new Producer("P_" + (i + 1),appleBox,boxSize,initNum,lock,condition);
            producers.add(producer);
            producer.start();
            Consumer consumer = new Consumer("C_" + (i + 1),appleBox,boxSize,lock,condition);
            consumers.add(consumer);
            consumer.start();
        }
        try {
            Thread.sleep(15000);
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

    private LinkedList<Integer> appleBox;

    private Integer boxSize;

    private AtomicInteger appleCurrentNum;

    private Boolean flag = true;

    private Lock lock;

    private Condition condition;

    Producer(String name, LinkedList<Integer> appleBox, Integer boxSize, AtomicInteger appleCurrentNum, Lock lock,Condition condition) {
        this.name = name;
        this.appleBox = appleBox;
        this.boxSize = boxSize;
        this.appleCurrentNum = appleCurrentNum;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (flag) {
            lock.lock();
            //System.out.println("[ " + name + " 生产者 线程：" +this.getName() + " ] 开始生产");
            try {
                if (appleBox.size() < boxSize) {

                    Integer apple = appleCurrentNum.addAndGet(1);
                    appleBox.addFirst(apple);
                    System.out.println("[ " + name + " 生产者 线程：" +this.getName() + " ] 生产了编号为-" + apple + "-号苹果，当前苹果有：" + appleBox.size() + "个");
                    Thread.sleep(100);
                    condition.signalAll();//唤醒其他所有的线程
                    condition.await(); // 线程等待
                } else {
                    System.out.println("[ " + name +" 生产者 线程 "+ this.getName() + " ] 正在生产苹果 ,但是队列已满等待消费者消费，当前苹果有：" + appleBox.size() +"个");
                    condition.await(); // 线程等待
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public void shutdownThread(){
        System.out.println("[ " + name + " 生产者 线程：" +this.getName() + " ] 停止");
        this.flag = false;
    }

}


class Consumer extends Thread {

    private String name;

    private LinkedList<Integer> appleBox;

    private Integer boxSize;

    private Boolean flag = true;

    private Lock lock;

    private Condition condition;

    Consumer(String name, LinkedList<Integer> appleBox, Integer boxSize,Lock lock,Condition condition) {
        this.name = name;
        this.appleBox = appleBox;
        this.boxSize = boxSize;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        while (flag) {
            //System.out.println("[ " + name +" 消费者，线程： "+ this.getName() + "] 开始消费");
            lock.lock();
            try{
                if (appleBox.isEmpty()) {
                    System.out.println("[ " + name +" 消费者，线程： "+ this.getName() + "] 没有苹果可以消费，进入阻塞状态等待生产者生产，当前苹果有：" + appleBox.size() + "个");
                    condition.await();
                } else {
                    Integer apple = appleBox.removeLast();
                    System.out.println("[ " + name +" 消费者，线程："+ this.getName() + " ] 消费了编号为-" + apple + "-号苹果，当前苹果有：" + appleBox.size() + "个");
                    Thread.sleep(100);
                    condition.signalAll(); //首先唤醒其他的线程，然后下面生产一个就释放锁，让其他的线程有竞争锁运行机会
                    condition.await();
                }
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void shutdownThread(){
        System.out.println("[ " + name +" 消费者，线程： "+ this.getName() + "] 停止");
        this.flag = false;
    }
}

