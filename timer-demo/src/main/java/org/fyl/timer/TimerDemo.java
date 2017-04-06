package org.fyl.timer;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author yiling.feng
 */
public class TimerDemo {
    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + "定时执行 当前时间十秒之后执行，只执行一次");
            }
        };

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + "指定当前时间十秒后开始，每隔15秒执行一次");
            }
        };

        TimerTask task3 = new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + "延时5秒后执行 只执行一次");
            }
        };

        TimerTask task4 = new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + "5秒后开始执行，每隔两秒执行一次");
            }
        };

        Calendar calendar = Calendar.getInstance();

        //1. 定时执行 当前时间十秒之后执行，只执行一次
        //schedule(TimerTask task, Date time)
        calendar.add(Calendar.SECOND, 10);
        Date time = calendar.getTime();
//        System.out.println("1." + new Date());
//        timer.schedule(task1, time);

        //2. 指定当前时间十秒后开始，每隔15秒执行一次
        //schedule(TimerTask task, Date firstTime, long period)
//        System.out.println("2." + new Date());
//        timer.schedule(task2, time, 1000 * 15);

        //3. 延时5秒后执行 只执行一次
        //schedule(TimerTask task, long delay)
//        timer.schedule(task3, 5 * 1000);

        //4. 5秒后开始执行，每隔两秒执行一次
        //schedule(TimerTask task, long delay, long period)
//        System.out.println("4." + new Date());
//        timer.schedule(task4, 5 * 1000, 2 * 1000);

        //5. 5秒后开始执行，每隔两秒执行一次
//        System.out.println("5." + new Date());
//        timer.scheduleAtFixedRate(task4, 5 * 1000, 2 * 1000);

        //6. 指定当前时间十秒后开始，每隔15秒执行一次
//        System.out.println("6." + new Date());
//        timer.scheduleAtFixedRate(task2, time, 1000 * 15);
    }
}
