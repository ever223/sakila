package com.xg.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-21 19:13.
 * @DESCRIPTION:
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    @Value("${redis.hostName}")
    private String redisHostName;
    @Value("${redis.port}")
    private int redisPort;

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
        redisConnectionFactory.setHostName(redisHostName);
        redisConnectionFactory.setPort(redisPort);
        return redisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory rcf) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(rcf);
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        // 设置缓存生存时间
        redisCacheManager.setDefaultExpiration(3000);
        return redisCacheManager;
    }

    // 自定义键生成器
    @Bean
    public KeyGenerator customKeyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object object : objects) {
                    sb.append(object.toString());
                }
                return sb.toString();
            }
        };
    }
}
