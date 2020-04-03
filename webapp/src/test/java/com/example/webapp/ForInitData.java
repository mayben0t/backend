package com.example.webapp;

import com.example.api.model.UserProduct;
import com.example.webapp.dao.UserProductMapper;
import com.google.common.base.Joiner;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.omg.PortableServer.ThreadPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

//初始化tb_user_product表数据
public class ForInitData extends WebappApplicationTests{
    @Autowired
    private UserProductMapper userProductMapper;
    volatile int userId = 900000;
    @Test
    public void insert() throws InterruptedException {
        //需要一样的值 所以设置为线程不安全

        StopWatch stopWatch = new StopWatch("导入百万数据开始");
        stopWatch.start("开始导入");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,20,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(35),  new ThreadPoolExecutor.AbortPolicy());
        String s = "a,b,c,d,e,f,g,h";
        String[] split = s.split(",");
        List<String> collect = Arrays.stream(split).collect(Collectors.toList());
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 50; i++) {
            Runnable runnable = () -> {
                try {
                    List<UserProduct> us = Lists.newArrayList();
                    for (int x = 0; x < 20000; x++) {
                        UserProduct userProduct = new UserProduct();
                        userProduct.setUserId(userId++);
                        userProduct.setDesc(collect.get((int) (Math.random() * collect.size())));
                        us.add(userProduct);
                    }
                    userProductMapper.insertBatch(us);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                countDownLatch.countDown();
            };
            threadPoolExecutor.execute(runnable);
        }
        TimeUnit.SECONDS.sleep(10);
        threadPoolExecutor.shutdown();
        try {
            countDownLatch.await();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
            stopWatch.stop();
            System.out.println(stopWatch.getLastTaskName() + "用时:" + stopWatch.getLastTaskTimeMillis()+"ms");
            System.out.println(stopWatch.prettyPrint());
    }
}
