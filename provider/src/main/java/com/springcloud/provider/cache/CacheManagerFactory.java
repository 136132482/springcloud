package com.springcloud.provider.cache;


/**
 * 缓存工厂类
 */
public class CacheManagerFactory {

    public static CacheManager getInstance() {
        CacheManager cm = getCacheManager("redis");
        return cm;
    }

    public static CacheManager getCacheManager(String name) {
        if ("redis".equals(name)) {
            return RedisClient.getInstance();
        } else {
            System.out.println("未指定缓存");
        }
        return null;
    }
}
