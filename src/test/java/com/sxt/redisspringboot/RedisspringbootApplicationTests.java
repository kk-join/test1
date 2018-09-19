package com.sxt.redisspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisspringbootApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void contextLoads() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("name","zhangsan");
        String name = ops.get("name");
        System.out.println(name);
    }

    @Test
    public void test(){
        ValueOperations ops = redisTemplate.opsForValue();
        User user = new User("zhangshan","shenzhen");
        ops.set("1",user);
        User user1= (User)ops.get("1");
        System.out.println(user1);
    }
}
