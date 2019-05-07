package com.springcloud.provider.api;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.*;

@Component
public class ConnectorFactory {


    private static Map<String, Connector> connectorCache = Collections.synchronizedMap(new HashMap<>());


    /**
     *  创建 Connector。 如果缓存已存在，则从缓存取。
     * @param config
     * @return
     * @throws ConnectorException
     */
    public Connector createConnector(ProviderConfig config) throws ConnectorException {

        String tenantId = config.getTenantId();
        MeterConstants.MeterBrandEnum brand = config.getBrand();
        String clientId = config.getClientId();
        String clientSecret = config.getClientSecret();
        String serverUrl = config.getServerUrl();

        String identifier = config.identifier();
        Connector connr = connectorCache.get(identifier);
        if (connr == null) {
            synchronized (connectorCache) {

                switch (brand) {
                    case COMMON: //普通表(非智能)
                        throw new ConnectorException("暂未支持非智能表 ", null);
//                    case DDING: //丁盯
//                        connr = new DdingMeterConnector(tenantId, serverUrl, clientId, clientSecret);
//                        break;
//                    case CJOY: // 超仪
//                        // extId1 为 回调地址
//                        connr = new JoyMeterConnector(tenantId, serverUrl, clientId, clientSecret, config.getExtId1());
//                        break;
//                    case POWERBEE:// 蜂电
//                        // extId1 为 appid
//                        connr = new PowerbeeMeterConnector(tenantId, serverUrl, clientId, clientSecret, config.getExtId1());
//                        break;
//                    case YMSINO:// 亿玛信诺, 厂家提供 "部门编号xq"应对应 clientid 字段
//                        connr = new YmsinoMeterConnector(tenantId, serverUrl, clientId);
//                        break;
//                    case DANBAY:// 蛋贝
//                        connr = new DanbayMeterConnector(tenantId, serverUrl, clientId, clientSecret);
//                        break;
                }

                // 移出无效对象
                this.evict(config.prefix());

                connectorCache.put(identifier, connr);
            }
        }

        return connr;
    }

    /**
     * 检查客户密钥的变化，从缓存中移出
     */
    private void evict(String prefix) {
        List<String> list = new ArrayList<>();

        //  密码等配置修改，需要移出对象
        connectorCache.forEach((key, val) -> {
            if (key.startsWith(prefix)) {
                list.add(key);
            }
        });

        list.forEach(key -> connectorCache.remove(key));
    }


    @PreDestroy
    public void destroy() {
        synchronized (connectorCache) {
            connectorCache.forEach((k,connr) -> {
                connr.destroy();
            });
        }
    }

}
