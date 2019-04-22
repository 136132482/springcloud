package com.springcloud.provider.moudle.entity;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.springcloud.provider.excel.annotation.ExcelField;
import com.springcloud.provider.persistence.DataEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 
 * 
 * 
 **/
@Data
@Accessors(chain = true)
@Table(name = "demo")
public class Demo extends DataEntity<Demo> {

	/****/
	@Column(name = "id_")
	private String id;

	/****/
	@ExcelField(title = "name_",name = "name")
	@Column(name = "name_")
	private String name;

	/****/
	@ExcelField(title = "user_",name = "user")
	@Column(name = "user_")
	private String user;

	/****/
	@ExcelField(title = "phone_",name = "phone")
	@Column(name = "phone")
	private String phone;





	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public JSONObject toJSONObjcet() throws JSONException{
		JSONObject json = new JSONObject();
		json.put("id", null == id ? "" : id);
		json.put("name", null == name ? "" : name);
		json.put("user", null == user ? "" : user);
		json.put("phone", null == phone ? "" : phone);
		return json;
	}
}
