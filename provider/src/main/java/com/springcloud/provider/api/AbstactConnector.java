package com.springcloud.provider.api;

import com.springcloud.provider.exception.ParamException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Data
public abstract class AbstactConnector  {

    protected Logger log = LogManager.getLogger(this.getClass());

    /**
     * 客户公司安全码
     */
    protected String tenantId;

    /**
     * 品牌厂家
     */
    protected String brand;

    /**
     * 设备厂家服务地址
     */
    protected String serverUrl;
    /**
     * 设备厂家开放平台登录账号
     */
    protected String clientId;
    protected String clientSecret;

    public AbstactConnector(Logger log, String tenantId, String brand, String serverUrl, String clientId, String clientSecret) {
        this.log = log;
        if (
                StringUtils.isEmpty(tenantId) ||
                        StringUtils.isEmpty(serverUrl) ||
                        StringUtils.isEmpty(clientId) ||
                        StringUtils.isEmpty(clientSecret)
        ) {
            LogManager.getLogger(this.getClass()).debug(
                    "{} - config[tenantId={}, serverUrl={}, clientId={}, clientSecret={}]", this.brand, tenantId, serverUrl, clientId, clientSecret);
            throw new ParamException(this.brand +
                    " - 请检查配置参数：[tenantId, serverUrl, clientId, clientSecret]", null);
        }
        this.tenantId = tenantId;
        this.brand = brand;
        this.serverUrl = serverUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }
}
