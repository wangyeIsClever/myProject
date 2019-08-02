package ThreadLearn.threadimpls.threadimpl1;


/**
 * 实现的第一种方式就是继承自Thread类
 */
class MyThread extends Thread{
    @Override
    public void run(){
        for(int i = 0 ; i <= 1000 ; i++){
            System.out.println("线程-----"+ this.getId() + "------输出：" + i);
        }
    }
}


public class ThreadImpl1Test {
    public static void main(String[] args){
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
    }
}
