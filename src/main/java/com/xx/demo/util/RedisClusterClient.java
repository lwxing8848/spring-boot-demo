package com.xx.demo.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * redis工具类
 * @author Lwx
 */
@Component
public class RedisClusterClient {

    private static final Logger logger = LoggerFactory.getLogger(RedisClusterClient.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        logger.debug("jedisCluster set : key = " + key + " success");
    }

    public String get(String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        logger.debug("jedisCluster get : key = " + key + " success");
        return value;
    }

    public void del(String key) {
        stringRedisTemplate.delete(key);
        logger.debug("jedisCluster del : key = " + key + " success");
    }

    public void setexObject(int expireTime, String key, Object value) {
        String str =  JSON.toJSONString(value);
        stringRedisTemplate.opsForValue().set(key, str, expireTime, TimeUnit.SECONDS);
        logger.debug("jedisCluster set : key = " + key + " " + expireTime + " second success");
    }

    public void setexStr(int expireTime, String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
        logger.debug("jedisCluster set : key = " + key + " " + expireTime + " second success");
    }

    public void setexTime(int expireTime,String key){
        stringRedisTemplate.expire(key,expireTime , TimeUnit.SECONDS);
    }

    public void setObject(String key, Object object) {
        String value = JSON.toJSONString(object);
        stringRedisTemplate.opsForValue().set(key, value);
        logger.debug("jedisCluster setObject : key = " + key + " success");
    }

    public Object getObject(String key){
        String value = stringRedisTemplate.opsForValue().get(key);
        logger.debug("jedisCluster getObject : key = " + key + " success");
        return JSON.parseObject(value);
    }

    /**
     * hash 方式存储
     *
     * @param key   hashKey
     * @param field key
     * @param value value
     * @return
     * @throws Exception
     */
    public void hset(String key, String field, String value) {
        stringRedisTemplate.opsForHash().put(key, field, value);
        logger.debug("jedisCluster hset : key = " + key + " success");
    }

    public void hset(String key, String field, Integer value) {
        stringRedisTemplate.opsForHash().put(key, field, value);
        logger.debug("jedisCluster hset : key = " + key + " success");
    }

    public void hset(String key, String field, Object value) {
        stringRedisTemplate.opsForHash().put(key, field, value);
        logger.debug("jedisCluster hset : key = " + key + " success");
    }

    public void hsetAll(String key, Map<String,Integer> map) {
        stringRedisTemplate.opsForHash().putAll(key,map);
        logger.debug("jedisCluster hsetAll : key = " + key + " success");
    }

    public String hget(String key, String field) {
        logger.debug("jedisCluster hget : key = " + key + " success");
        return (String) stringRedisTemplate.opsForHash().get(key, field);
    }

    public void hdel(String key, String... field) {
        logger.debug("jedisCluster hdel : key = " + key + " success");
        stringRedisTemplate.opsForHash().delete(key, field);
    }

    public Boolean hasKey(String key, String field) {
        return stringRedisTemplate.opsForHash().hasKey(key, field);
    }

    public Boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    public Map<Object, Object> hget(String key) {
        return stringRedisTemplate.opsForHash().entries(key);
    }

}
