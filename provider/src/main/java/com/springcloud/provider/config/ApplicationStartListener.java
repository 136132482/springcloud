package com.springcloud.provider.config;



import com.springcloud.provider.cache.CacheManagerFactory;
import com.springcloud.provider.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by odfly on 2017/2/12.
 */
@Component
public class ApplicationStartListener implements ApplicationListener<ApplicationReadyEvent> {
    private static final String QYPMS_START = "demo_start";
    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
        //初始化Redis连接
        try {
            CacheManagerFactory.getInstance().set(QYPMS_START, true);
            if (CacheManagerFactory.getInstance().get(QYPMS_START).equals(true)) {
                logger.info("redis连接成功!");
            } else {
                logger.info("redis连接失败...请检查缓存是否开启");
            }
        } catch (Exception e) {
            StringUtil.getStackMsg(e);
            logger.info("redis连接失败...请检查缓存是否开启");
        }
    }
}
