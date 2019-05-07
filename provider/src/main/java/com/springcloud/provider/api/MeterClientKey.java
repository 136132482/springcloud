package com.springcloud.provider.api;

import com.springcloud.provider.persistence.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 智能设备授权账号表
 * </p>
 *
 * @author brett.chen
 * @since 2018-08-23
 */
@Data
@Accessors(chain = true)
@ApiModel(value="MeterClientKey对象", description="智能设备授权账号表")
@ToString
public class MeterClientKey  {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "智能表品牌（厂家）")
    private String meterBrand;

    @ApiModelProperty(value = "账号")
    private String clientId;

    @ApiModelProperty(value = "密钥")
    private String clientSecret;

    @ApiModelProperty(value = "扩展属性1(如：超仪的回调地址；蜂电配置appid)")
    private String extId1;

    @ApiModelProperty(value = "扩展属性2(备用)")
    private String extId2;

    @ApiModelProperty(value = "厂家云平台接口地址")
    private String serverUrl;

    @ApiModelProperty(value = "备注")
    private String remark;



}
