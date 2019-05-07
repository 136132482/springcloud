package com.springcloud.provider.api;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;


/**
 * @author brett.chen
 * @date 28/08/2018
 **/
@Data
@ToString
@EqualsAndHashCode
public class ProviderConfig implements Serializable {

    String tenantId;
   MeterConstants.MeterBrandEnum brand;

    String clientId;
    String clientSecret;

    private String serverUrl;

    /**
     * 备用字段，如：超仪的回调地址；蜂电的appid；
     */
    private String extId1;

    private String extId2;

    public ProviderConfig(String tenantId, MeterConstants.MeterBrandEnum brand) {
        this.tenantId = tenantId;
        this.brand = brand;
    }

    public String prefix(){
        return tenantId + brand + clientId;
    }

    public String identifier() {
        return prefix() + new String(   clientSecret + serverUrl + extId1 + extId2).hashCode();
    }
}
