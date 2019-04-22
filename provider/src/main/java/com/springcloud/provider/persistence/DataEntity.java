
package com.springcloud.provider.persistence;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.odfly.demo.util.IdGen;
import com.odfly.demo.util.StringUtil;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 数据Entity类
 */
public abstract class DataEntity<T> extends BaseEntity {

    public DataEntity() {
        super();
    }

    /**
     * 是否删除（0：删除；1：正常；）默认为1  ，房源相关除外（段文康写的逻辑正好相反）
     */
    public T setId(String id) {
        return (T) this;
    }

    public String getId() {
        return "";
    }

    public T setCt(Date ct) {
        return (T) this;
    }

    public Date getCt() {
        return new Date();
    }

    public T setEt(Date et) {
        return (T) this;
    }

    public Date getEt() {
        return new Date();
    }

    public T setIsDelete(Integer isDelete) {
        return (T) this;
    }

    public Integer getIsDelete() {
        return 1;
    }

    public T setGcid(String gcid) {
        return (T) this;
    }

    public String getGcid() {
        return "";
    }

    public String getEtId() {
        return "";
    }

    public T setEtId(String etId) {
        return (T) this;
    }

    public String getCtId() {
        return "";
    }

    public T setCtId(String ctId) {
        return (T) this;
    }

    /**
     * <p>
     * 新增数据前调用
     * </P>
     */
    public T preInsert() {
        if (StringUtil.isEmpty(this.getId())) {
            this.setId(IdGen.uuid());
        }
        if (null == this.getCt()) {
            this.setCt(new Date());//创建时间
        }
        this.setEt(new Date());//修改时间


        //this.preInsertIsDelete();//是否删除
        return (T) this;
    }

    /**
     * <p>
     * 修改数据前执行
     * </p>
     */
    public T preUpdate() {
        this.setEt(new Date());//修改时间

        return (T) this;
    }

    /**
     * <p>
     * 逻辑删除前执行
     * </p>
     */
    public T preDeleteLogic() {
        this.setEt(new Date());

        this.preDeleteIsDelete();
        return (T) this;
    }

    public void preInsertIsDelete() {
        //有效
        if ("House".equals(this.getClass().getSimpleName())
                || "HouseFuzeren".equals(this.getClass().getSimpleName())
                || "HouseShouding".equals(this.getClass().getSimpleName())
                || "HouseShoudingFzr".equals(this.getClass().getSimpleName())
                || "HouseUser".equals(this.getClass().getSimpleName())
                || "Chengzu".equals(this.getClass().getSimpleName())
                || "QianYue".equals(this.getClass().getSimpleName())
                || "ChengzuFzr".equals(this.getClass().getSimpleName())
                || "Pic".equals(this.getClass().getSimpleName())
                // || this.getClass().getSimpleName().equals("HousePeiZhi")房屋配置（资产）不参与这件事--杨冠宇
                || "ZiDian".equals(this.getClass().getSimpleName())
                || "PayConfig".equals(this.getClass().getSimpleName())) {
            this.setIsDelete(IS_DELETE);//强制把默认1变成0  ，因为段文康写的为1有效，0删除，调整为0有效1删除
        } else {
            this.setIsDelete(IS_DELETE_NORMAL);
        }
    }

    public void preDeleteIsDelete() {
        //删除
        if ("House".equals(this.getClass().getSimpleName())
                || "HouseFuzeren".equals(this.getClass().getSimpleName())
                || "HouseShouding".equals(this.getClass().getSimpleName())
                || "HouseShoudingFzr".equals(this.getClass().getSimpleName())
                || "HouseUser".equals(this.getClass().getSimpleName())
                || "Chengzu".equals(this.getClass().getSimpleName())
                || "QianYue".equals(this.getClass().getSimpleName())
                || "ChengzuFzr".equals(this.getClass().getSimpleName())
                || "Pic".equals(this.getClass().getSimpleName())
                || "ZiDian".equals(this.getClass().getSimpleName())) {
            this.setIsDelete(IS_DELETE_NORMAL);//强制把默认1变成0  ，因为段文康写的为1有效，0删除，调整为0有效1删除
        } else {
            this.setIsDelete(IS_DELETE);
        }
    }

    /**
     * <p>
     * 向页面输出数据
     * </p>
     *
     * @return
     * @throws JSONException
     */
    public JSONObject toJSONObjcet() throws JSONException {
        JSONObject json = new JSONObject();
        return json;
    }

    /**
     * <p>
     * 向页面输出数据
     * </p>
     *
     * @return
     * @throws JSONException
     */
    public JSONObject toSimpleJSONObjcet() throws JSONException {
        JSONObject json = new JSONObject();
        return json;
    }

    /**
     * <p>
     * 逻辑删除标记（0：删除；1：正常；） ，房源相关除外（段文康写的逻辑正好相反）
     * </p>
     */
    public static final Integer IS_DELETE_NORMAL = 1;
    public static final Integer IS_DELETE = 0;

    /**
     * 复制当前对象
     *
     * @param targetObject 返回新对象
     * @return
     */
    public T copyBean(T targetObject) {
        BeanUtils.copyProperties(this, targetObject);
        return targetObject;
    }

    /**
     * 复制当前对象,自动过滤来源为NULL的属性
     *
     * @param targetObject 返回新对象
     * @return
     */
    public T copyBeanFilterNullValue(T targetObject) {
        List<String> nullFieldList = new ArrayList();
        try {
            for (Field f : this.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(this) == null) { //判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
                    nullFieldList.add(f.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(this, targetObject, nullFieldList.toArray(new String[nullFieldList.size()]));
        return targetObject;
    }
}
