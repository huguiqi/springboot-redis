package com.example.demo;

import com.example.delayqueen.TaskConsumer;
import com.example.delayqueen.TaskProducer;
import com.example.demo.bean.House;
import com.example.demo.service.PersonDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo1Application.class)
public class DelayQueenTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(DelayQueenTests.class);


	@Autowired
	private TaskProducer taskProducer;

	@Autowired
	private TaskConsumer taskConsumer;


	@Test
	public void testDelayQueen_query(){
		//创建 3个任务，并设置超时间为 10s 5s 20s
		taskProducer.produce(1, System.currentTimeMillis() + 10000);
		taskProducer.produce(2, System.currentTimeMillis() + 5000);
		taskProducer.produce(3, System.currentTimeMillis() + 20000);

		System.out.println("等待任务执行===========");

		//消费端从redis中消费任务
		taskConsumer.consumer();

		try {
			TimeUnit.MILLISECONDS.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}

}
