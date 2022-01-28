package com.example.delayqueen;

import com.example.delayqueen.common.RedisConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class TaskConsumer {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void consumer() {

        Executors.newSingleThreadExecutor().submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //取最小的score(时间戳最小代表最早过期，则最先出列),并查询出score大于0小于等于当前时间的队列
                    Set<String> taskIdSet = redisTemplate.opsForZSet().rangeByScore(RedisConst.DELAY_ZSET_KEY, 0, System.currentTimeMillis(), 0, 1);
                    if (taskIdSet == null || taskIdSet.isEmpty()) {
                        System.out.println("没有任务");
                    } else {
                        taskIdSet.forEach(id -> {
                            long result = redisTemplate.opsForZSet().remove(RedisConst.DELAY_ZSET_KEY, id);
                            if (result == 1L) {
                                System.out.println("从延时队列中获取到任务，taskId:" + id + " , 当前时间：" + System.currentTimeMillis());
                            }
                        });
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
