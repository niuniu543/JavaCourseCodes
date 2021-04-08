package java0.conc0303;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class Homework03 {

/*    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        new Thread(() -> {
            int result =sum();
            System.out.println("线程执行结果："+result);
        }).start();
        Thread.sleep(3000);
        System.out.println("main线程结束。。。");
    }*/
//第二种方法
/*public static void main(String[] args) throws Exception {
    Thread thread = new Thread(() -> {
        int result = sum();
        System.out.println("线程执行结果：" + result);
    });
    thread.start();
    thread.join();
    System.out.println("main线程结束。。。");
}*/

    /**
     *第三种方法
     */
/*    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            int result = sum();
            System.out.println("线程执行结果：" + result);
        });
        Homework03 homework03=new Homework03();
        thread.start();
        synchronized (homework03){
            homework03.wait(400);
        }
        System.out.println("main线程结束。。。");
    }*/

    /**
     *第四种
     */
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch=new CountDownLatch(2);
        Thread thread = new Thread(() -> {
            int result = sum();
            System.out.println("线程执行结果：" + result);
        });
        thread.start();
        countDownLatch.await(4, TimeUnit.SECONDS);
        System.out.println("main线程结束。。。");
    }


    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
