/* 
 * @(#)scheduleAndScheduleAtFixedRateDemo.java    2017/4/6
 * 
 * Copyright © 2006-2016 YONGHUI SUPERSTORES, All Rights Reserved.
 * YONGHUI SUPERSTORES PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package org.fyl.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author yiling.feng
 */
public class scheduleAndScheduleAtFixedRateDemo {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = sdf.parse("2017/4/6 16:30:00");

        Timer timer = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + "scheduleAtFixedRate() 每隔三分钟执行一次");
            }
        };

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date() + "schedule() 每隔三分钟执行一次");
            }
        };

        System.out.println(new Date());
        // 更注重保持执行频率的稳定, 当假设当前时间是2017/4/6 16:40:00，如果第一次执行时间是过去的时间，
        // 如2017/4/6 16:30:00，那么当第一次执行schedulerAtFixedRate时，会从2017/4/6 16:30:00开始，
        // 每隔三分钟，即当2017/4/6 16:30:00，2017/4/6 16:33:00，2017/4/6 16:36:00，2017/4/6 16:39:00，
        // 总共执行4次。下一次执行时间则是2017/4/6 16:42:00
        timer.scheduleAtFixedRate(task1, date, 3 * 60 * 1000);

        System.out.println(new Date());
        // 更注重保持间隔时间的稳定, 当假设当前时间是2017/4/6 16:40:00，如果第一次执行时间是过去的时间，
        // 如2017/4/6 16:30:00，当第一次执行scheduler时，会从当前时间开始，只执行一次，之后每隔三分钟
        // 执行一次，下一次执行时间为（执行时间+3分钟）
        timer.schedule(task2, date, 3 * 60 * 1000);
    }

}
