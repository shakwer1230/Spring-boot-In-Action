package com.sun.jsp.config.redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/10
 * @
 */
@Configuration
@EnableCaching //注解来开启我们的项目支持缓存
public class RedisConfiguration  extends CachingConfigurerSupport{
    /**
     * 采用redisCacheManager作为缓存管理器
     * @param redisTemplate
     * @return
     */
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        return new RedisCacheManager(redisTemplate);
    }
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb=new StringBuilder();
                //追加类名
                sb.append(target.getClass().getName());
                // 追加方法名
                sb.append(method.getName());
                // 追加参数
                for (Object object :params){
                    sb.append(object.toString());
                }
                System.out.println("调用redis缓存key:"+sb.toString());
                return sb.toString();
            }
        };
    }
}
