package com.springcloud.provider.moudle.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import com.springcloud.provider.moudle.entity.Result;
import com.springcloud.provider.util.RequestUtil;
import lombok.Data;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Data
public class ParameterizedTypeImpl implements ParameterizedType {


    private static ObjectMapper mapper = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(MapperFeature.USE_ANNOTATIONS)
            //如果是空对象的时候,抛异常
            .configure(SerializationFeature.INDENT_OUTPUT, true)
            //反序列化的时候如果多了其他属性,不抛出异常
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


    private final Class raw;
    private final Type[] args;
    public ParameterizedTypeImpl(Class raw, Type[] args) {
        this.raw = raw;
        this.args = args != null ? args : new Type[0];
    }

    @Override
    public Type[] getActualTypeArguments() {
        return args;
    }

    @Override
    public Type getRawType() {
        return raw;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }

    //gson转对象
    public static <T> Result<T> fromJsonObject(String str, Class<T> clazz) {
        Type type = new ParameterizedTypeImpl(Result.class, new Class[]{clazz});
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new StringReader(str));
        return gson.fromJson(reader, type);
    }
    //gson转数组对象
    public static <T> Result<List<T>> fromJsonArray(String str, Class<T> clazz) {
        // 生成List<T> 中的 List<T>
        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        // 根据List<T>生成完整的Result<List<T>>
        Type type = new ParameterizedTypeImpl(Result.class, new Type[]{listType});
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new StringReader(str));
        return gson.fromJson(reader, type);
    }

    //判断json的data类型
   public static int booleanToJson(String str) {
        //转换
       JSONObject jsonObject = JSONObject.parseObject(str);
       //判断json的data类型
       Object object = null;
       try {
           object = new JSONTokener(jsonObject.getString("data")).nextValue();
       } catch (JSONException e) {
           e.printStackTrace();
       }

       if (object instanceof JSONArray){
           System.out.println("此为jsonArray类型");
           return 1 ;
       } else if (object instanceof JSONObject) {
           System.out.println("此为jsonObject类型");
           return 2;
       }
       return 0;
   }

   public static  Result booleanTomapperObject(String str){

       try {
           return mapper.readValue(str, Result.class);

       } catch (IOException e) {
           e.printStackTrace();
       }

       return null;
   }

   //httpRequsetservlet获取请求参数
    public static  String  getRequest(){
     return  (String) RequestUtil.getRequest().getAttribute("requestParams");
    }

    //json对象获取
    public static <T>T getData(Class<T> clazz){
        Result<T> tHttpResult = fromJsonObject(getRequest(), clazz);

        T data = tHttpResult.getData();

        return data;
    }

    //数组对象获取
    //json对象获取
    public static <T> List<T> getDataList(Class<T> clazz){
        Result<List<T>> listHttpResult = fromJsonArray(getRequest(), clazz);

        List<T> data = listHttpResult.getData();

        return data;
    }


    public static void main(String[] args) {
      Result httpResult = new Result();
      httpResult.setCode(200);
      httpResult.setMsg("成功");
//        Demo demo = new Demo();
//        demo.setId(UUID.randomUUID().toString());
//        demo.setName("哈哈");
//        demo.setPhone("132177782678");
//        demo.setUser("张撒");
//      httpResult.setData(demo);
//        String s = JSONObject.toJSONString(httpResult);
//        System.out.println(s);
//        HttpResult<Demo> httpResultHttpResult = fromJsonObject(s, Demo.class);
//        System.out.println(httpResultHttpResult.toString());
//        List<Demo>list = new ArrayList<>();
//        list.add(demo);
//        httpResult.setData(list);
//        String s1 = JSONObject.toJSONString(httpResult);
//        System.out.println(s1);
//        HttpResult<List<Demo>> listHttpResult = fromJsonArray(s1, Demo.class);
//        System.out.println(listHttpResult.toString());


    }
}
