package com.springcloud.provider.api;

import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * 智能水电表常量
 * @author brett.chen
 * @date 22/08/2018
 **/
public interface MeterConstants {

    /**
     * uri 前缀
     * api path prefix
     */
    String PUBLIC_PATH = "/public";

    /**
     * Module smart meter path
     */
    String SMARTMETER_PATH = "/meter";


    /**
     * 设备类型
     */
    enum MeterTypeEnum {
        // 设备类型
        WATER("水表"), HOT_WATER("热水表"), GAS("燃气表"),
        WATT_HOUR("电表"), RECLAIMED_WATER("中水表")
        ;

        private String desc;

        MeterTypeEnum(String desc) {
            this.desc = desc;
        }


        public String getDesc(){
            return this.desc;
        }

        public static MeterTypeEnum parse(String name) {
            MeterTypeEnum[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (values[i].getDesc().equals(name.trim())) {
                    return values[i];
                }
            }
            throw new RuntimeException("设备类型转换错误");
        }

        public static LinkedHashMap<Serializable, Serializable> toMap(){
            LinkedHashMap<Serializable, Serializable> map = new LinkedHashMap();
            MeterTypeEnum[] values = values();
            for (int i = 0; i < values.length; i++) {
                map.put(values[i].name(), values[i].getDesc());
            }
            return map;
        }
    }



    /**
     * 付款状态，0：预付；1：成功；2：处理中；3：失败；4：超时关单；
     */
    enum PayStatusEnum {

        Prepare,
        Succ,
        Processing,
        Fail,
        Closed,

    }

    /**
     * 品牌
     */
    enum MeterBrandEnum {
        COMMON("普通表(非智能)"),
        DDING("丁盯"),
        CJOY("超仪"),
        POWERBEE("蜂电"),
        YMSINO("亿玛信诺"),
        DANBAY("蛋贝"),

        ;

        private String desc;

        MeterBrandEnum(String desc) {
            this.desc = desc;
        }


        public static LinkedHashMap<Serializable, Serializable> toMap(){
            LinkedHashMap<Serializable, Serializable> map = new LinkedHashMap();
            MeterBrandEnum[] values = values();
            for (int i = 0; i < values.length; i++) {
                map.put(values[i].name(), values[i].desc);
            }
            return map;
        }
    }

    /**
     * 抄表类型
     */
    enum ReadType {
        manual, job
    }

    /**
     * 付费方式
     */
    enum PaymentMethod {
        // 预付费-1，后付费-2
        PREPAYMENT("1"),
        POSTPAID("2");

        private String value;

        PaymentMethod(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
