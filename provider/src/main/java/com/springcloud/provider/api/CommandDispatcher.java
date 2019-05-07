package com.springcloud.provider.api;

import com.springcloud.provider.exception.ParamException;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;

/*
连接第三方平台
 */
public class CommandDispatcher {

    @Autowired
    private ConnectorFactory  factory;

    @Autowired
    private IMeterClientKeyService clientKeyService;

    /**
     *
     * 根据设备品牌,获取第三方平台连接对象
     *
     * @param brand
     * @return
     * @throws ConnectorException
     */
    public Connector getConnector(String tenantId, MeterConstants.MeterBrandEnum brand) {

        ProviderConfig conf = this.getProviderConfig(tenantId, brand);
        LogManager.getLogger(CommandDispatcher.class).debug("load ProviderConfig: ", conf);


        try {
            return factory.createConnector(conf);
        } catch (Exception e) {
            LogManager.getLogger(CommandDispatcher.class).error("获取连接失败！config: {}, {}", tenantId, brand);
            LogManager.getLogger(CommandDispatcher.class).error("", e);

            throw new ParamException("获取第三方平台连接对象失败, config: " + conf, e);
        }
    }

    /**
     * 获取 设备供应商'授权账号' 配置
     * @param tenantId
     * @param brand
     * @return
     */
    private ProviderConfig getProviderConfig(String tenantId, MeterConstants.MeterBrandEnum brand) {
        ProviderConfig conf = new ProviderConfig(tenantId, brand);

        MeterClientKey keyPair = this.clientKeyService.getByTenantAndBrand(tenantId, brand.toString());
        if (keyPair == null) {
            throw new ParamException("没有配置设备供应商'授权账号'");
        }

        conf.setClientId(keyPair.getClientId());
        conf.setClientSecret(keyPair.getClientSecret());
        conf.setServerUrl(keyPair.getServerUrl());
        conf.setExtId1(keyPair.getExtId1());
        conf.setExtId2(keyPair.getExtId2());

        return conf;
    }
}
