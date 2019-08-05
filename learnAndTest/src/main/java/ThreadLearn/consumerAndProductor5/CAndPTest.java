package ThreadLearn.consumerAndProductor5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class CAndPTest {

    public static void main(String[] args) {
        LinkedList<Integer> appleBox = new LinkedList<>();
        Integer boxSize = 5;
        AtomicInteger initNum = new AtomicInteger(0);
        AppleFactory appleFactory = new AppleFactory(appleBox,boxSize,initNum);
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        List<Producer> producers = new ArrayList<>();
        List<Consumer> consumers = new ArrayList<>();
        for (int i = 0 ; i  < 3 ; i++){
            Producer producer = new Producer("P_" + (i + 1),appleFactory);
            producers.add(producer);
            Consumer consumer = new Consumer("C_" + (i + 1),appleFactory);
            consumers.add(consumer);
            executorService.submit(producer);
            executorService.submit(consumer);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0 ; i  < 3 ; i++){
            producers.get(i).stopThread();
            consumers.get(i).stopThread();
        }
        executorService.shutdown();
    }
}

class Producer implements Runnable {

    private String name;

    private AppleFactory appleFactory;

    private boolean flag = true;

    Producer(String name, AppleFactory appleFactory) {
        this.name = name;
        this.appleFactory = appleFactory;
    }

    @Override
    public void run() {
        while (flag) {
            appleFactory.putApple();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread(){
        System.out.println("[ " + name +" 生产者 线程 "+ Thread.currentThread().getName() + " ] 停止了");
        this.flag = false;
    }

}

class Consumer implements Runnable {

    private String name;

    private AppleFactory appleFactory;

    private boolean flag = true;

    Consumer(String name, AppleFactory appleFactory) {
        this.name = name;
        this.appleFactory = appleFactory;
    }

    @Override
    public void run() {
        while (flag) {
            appleFactory.takeApple();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void stopThread(){
        System.out.println("[ " + name +" 消费者，线程："+ Thread.currentThread().getName() + " ] 停止了");
        this.flag = false;
    }
}

class AppleFactory{

    private LinkedList<Integer> appleBox;

    private Integer boxSize;

    private AtomicInteger appleCurrentNum;

    // 非满锁
    private final Semaphore notFull;
    // 非空锁
    private final Semaphore notEmpty;
    // 核心锁
    private final Semaphore mutex;


    public AppleFactory(LinkedList<Integer> appleBox, Integer boxSize, AtomicInteger appleCurrentNum) {
        this.appleBox = appleBox;
        this.boxSize = boxSize;
        this.appleCurrentNum = appleCurrentNum;
        this.mutex = new Semaphore(1);
        this.notFull = new Semaphore(boxSize);
        this.notEmpty = new Semaphore(0);
    }

    public void putApple(){
        try {
            notFull.acquire();
            mutex.acquire();
            int apple = appleCurrentNum.addAndGet(1);
            appleBox.addFirst(apple);
            System.out.print("生产者,线程：" + Thread.currentThread().getName() + " ] 生产了编号为-" + apple + "-号苹果，当前苹果有：" + appleBox.size() + "个");
            System.out.println();
            mutex.release();
            notEmpty.release();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void takeApple(){
        try {
            notEmpty.acquire();
            mutex.acquire();
            int apple = appleBox.removeFirst();
            System.out.print("消费者,线程：" + Thread.currentThread().getName() + " ] 消费了编号为-" + apple + "-号苹果，当前苹果有：" + appleBox.size() + "个");
            System.out.println();
            mutex.release();
            notFull.release();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public LinkedList<Integer> getAppleBox() {
        return appleBox;
    }

    public void setAppleBox(LinkedList<Integer> appleBox) {
        this.appleBox = appleBox;
    }

    public Integer getBoxSize() {
        return boxSize;
    }

    public void setBoxSize(Integer boxSize) {
        this.boxSize = boxSize;
    }

    public AtomicInteger getAppleCurrentNum() {
        return appleCurrentNum;
    }

    public void setAppleCurrentNum(AtomicInteger appleCurrentNum) {
        this.appleCurrentNum = appleCurrentNum;
    }


}


