package com.springcloud.provider.api;



/**
 * <p>
 * 智能设备授权账号表 服务类
 * </p>
 *
 * @author brett.chen
 * @since 2018-08-23
 */
public interface IMeterClientKeyService  {

    /**
     * 加缓存，先从缓存取 MeterClientKey
     * @param tenantId
     * @param brand
     * @return
     */
    MeterClientKey getByTenantAndBrand(String tenantId, String brand);

}
