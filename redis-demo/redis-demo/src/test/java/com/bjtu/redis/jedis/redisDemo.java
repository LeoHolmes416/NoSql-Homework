package com.bjtu.redis.jedis;

import com.bjtu.redis.pojo.User;
import com.bjtu.redis.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: HE LONG CAN
 * @description:
 * @date: 2020-12-08 21:49
 */
@SpringBootTest
public class redisDemo {

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void basicUse() {
        redisUtil.set("key",1,30);
    }


    @Test
    public void RedisList() {
        redisUtil.lSet("site-list","Runoob",30);
        redisUtil.lSet("site-list","Google",30);
        redisUtil.lSet("site-list","Taobao",30);

        List<Object> list = redisUtil.lGet("site-list", 0, redisUtil.lGetListSize("site-list"));

        assert list != null;
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void RedisIncr() {
        redisUtil.incr("key",1);

        Object key = redisUtil.get("key");
        System.out.println(key);
    }


    @Test
    public void RedisMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("test","success");
        redisUtil.hmset("mymap",map);
    }


    @Test
    public void RedisJsonTest() {
        User user = new User(100,"小明",18);
        redisUtil.set("user",user);
        Object user1 = redisUtil.get("user");
        System.out.println(user1);
    }




}
