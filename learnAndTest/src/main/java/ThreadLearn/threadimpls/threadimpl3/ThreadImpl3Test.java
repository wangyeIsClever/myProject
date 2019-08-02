package ThreadLearn.threadimpls.threadimpl3;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现的第三种方式就是实现 Callable<V> 接口,其中V是call()方法的返回值类型
 */
class MyThread implements Callable<Long>{

    @Override
    public Long call() throws Exception {
        long sum = 0L;
        for(long i = 1 ; i <= 1000L ; i++){
            System.out.println("线程-----" + Thread.currentThread().getId() + Thread.currentThread().getName() +"------加了：" + i);
            sum = sum + i;
        }
        return sum;
    }
}


public class ThreadImpl3Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread thread = new MyThread();
        FutureTask<Long> result1 = new FutureTask<>(thread);
        FutureTask<Long> result2 = new FutureTask<>(thread);
        Thread thread1 = new Thread(result1);
        Thread thread2 = new Thread(result2);
        thread1.start();
        thread2.start();
        Long sum1 = result1.get();// 获取返回值
        Long sum2 = result2.get();// 获取返回值
        System.out.println(sum1);
        System.out.println(sum2);
    }
}
