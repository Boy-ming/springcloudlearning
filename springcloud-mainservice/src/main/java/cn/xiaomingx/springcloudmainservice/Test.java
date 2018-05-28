package cn.xiaomingx.springcloudmainservice;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Ming
 * @PROJECT: springcloud
 * @Package cn.xiaomingx.springcloudmainservice
 * @date 2018/4/28 9:05
 * @Description: ${todo}
 */
public class Test {
    static int a = 0;    static int b = 0;    //原子性操作类
     static AtomicInteger atomicInt = new AtomicInteger(0);
     public static void main(String[] args) throws InterruptedException {
         for (int i = 0; i < 10; i++) {//创建10个线程
             Thread t = new Thread() {
                 @Override
                 public void run() {
                     for (int j = 0; j < 1000; j++) {//计算1000次
                         a = a + 1;
                         b++;
                         atomicInt.incrementAndGet();//自增的原子性方法
                          }
                 }
             };
             t.start();
         }        // 判断当前的活动线程是不是只有main线程，以确保10个计算线程执行完成。
          while (Thread.activeCount() > 1) {
             Thread.sleep(1000);        }
             System.out.println("a=a+1在多线程下的结果是：" + a);
         System.out.println("b++在多线程下的结果是：" + b);
         System.out.println("原子操作类AtomicInteger在多线程下的结果是：" + atomicInt.get());    }
}
