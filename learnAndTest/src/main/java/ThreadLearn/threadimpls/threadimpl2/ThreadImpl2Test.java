package ThreadLearn.threadimpls.threadimpl2;


/**
 * 实现的第二种方式就是实现Runable接口
 * 这种实现方式有好处也有坏处。
 * 好处：接口能多实现，并且这样实现能继承一个其他的接口
 * 坏处：不能直接使用this。来获取线程id和线程名了，而是要使用Thread.currentThread().getId()
 */
class MyThread implements Runnable{

    @Override
    public void run(){
        for(int i = 1 ; i <= 1000 ; i++){
            System.out.println("线程-----" + Thread.currentThread().getId() + Thread.currentThread().getName() +"------输出：" + i);
        }
    }

}


public class ThreadImpl2Test {

    public static void main(String[] args){
        MyThread thread = new MyThread();
        Thread thread1 = new Thread(thread);
        Thread thread2 = new Thread(thread);
        thread1.start();
        thread2.start();

    }
}
