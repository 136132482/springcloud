package com.springcloud.provider.cache;


import net.sf.ehcache.Cache;

import java.net.URL;

/**
 * Created by odfly on 2017/4/4.
 */
public class EhcacheClient {

    private static final String path = "/ehcache.xml";
    private URL url;
    private CacheManager manager;
    private static EhcacheClient ehCache;

    private EhcacheClient() {

    }

    private EhcacheClient(String path) {
        url = getClass().getResource(path);
        manager = CacheManager.create(url);
    }

    public static EhcacheClient getInstance() {
       /* if (ehCache == null) {
            ehCache = new EhcacheClient(path);
        }
        return ehCache;*/
        if (ehCache == null) {
            ehCache = new EhcacheClient();
        }
        return ehCache;
    }

    public void set(String cacheName, String key, Object value) {
        /*Cache cache = manager.getCache(cacheName);
        Element element = new Element(key, value);
        cache.put(element);*/
        CacheManagerFactory.getInstance().set("ehcache" + key, value);
    }

    public void set(String key, Object value) {
        /*Cache cache = manager.getCache("qypms");
        Element element = new Element(key, value);
        cache.put(element);*/
        CacheManagerFactory.getInstance().set("ehcache" + key, value);
    }

    public Object get(String key) {
        try {
        /*Cache cache = manager.getCache("qypms");
        Element element = cache.get(key);
        return element == null ? null : element.getObjectValue();*/
            Object obj = CacheManagerFactory.getInstance().get("ehcache" + key);
            return obj == null ? null : obj;
        } catch (Exception e) {

        }
        return null;
    }

    public Object get(String cacheName, String key) {
        try {
           /* Cache cache = manager.getCache(cacheName);
            Element element = cache.get(key);
            return element == null ? null : element.getObjectValue();*/
            Object obj = CacheManagerFactory.getInstance().get("ehcache" + key);
            return obj == null ? null : obj;
        } catch (Exception e) {

        }
        return null;

    }

    public Cache getCache(String cacheName) {
        return manager.getCache(cacheName);
    }

    public void remove(String cacheName, String key) {
        //Cache cache = manager.getCache(cacheName);
        //cache.remove(key);
        CacheManagerFactory.getInstance().deleteByKey("ehcache" + key);
    }
}
