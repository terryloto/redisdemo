package com.lvtaoo.redisdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvtaoo.redisdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.redis.core.RedisTemplate;
import com.lvtaoo.redisdemo.utils.RedisUtil;

@SpringBootTest
class RedisdemoApplicationTests {


    @Autowired
    private RedisTemplate redisTemplate;
   @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {

        //redisTemplate 操作不同的数据类型
        //opsForValue  操作字符串 类似String
        //opsForList 操作list 类似list
        //opsForSet 操作

        //除了基本的操作，我们常用的操作可以直接通过redisTemplate

        redisTemplate.opsForValue().set("name","loto");
        System.out.println(redisTemplate.opsForList().leftPush("age",20));


        Object name = redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }



    @Test
    public  void  test() throws JsonProcessingException {

        User user = new User("terry",18);
        redisTemplate.opsForValue().set("user",user);
        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",jsonUser);

//        redisUtil.set("test","loto");
//        System.out.println(redisUtil.get("test"));

        System.out.println(redisTemplate.opsForValue().get("user"));


    }
    @Test
    public void test2(){
     redisUtil.set("wode","wenti");

//     redisUtil.lSet("left","happy");
        System.out.println(redisUtil.get("wode"));
//        System.out.println(redisUtil.get("left"));



    }

}