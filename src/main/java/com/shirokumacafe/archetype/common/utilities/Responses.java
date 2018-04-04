package com.shirokumacafe.archetype.common.utilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
* 应答工具类
*
* @author lim
*/
public class Responses {
    //不允许被实例化
    private Responses(){};

    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private static JsonMapper objectMapper = new JsonMapper(JsonInclude.Include.ALWAYS);

    static{
        //设置时间格式
        objectMapper.getMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false).setDateFormat(threadLocal.get());
    }

    private final static String SUCCESS = "success";
    private final static String URL = "url";
    private final static String MSG = "msg";

    public static Map writeFailAndMsg(String error,String url){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put(SUCCESS,false);
        map.put(URL,url);
        map.put(MSG,error);
        return map;
    }

    public static Map writeFailAndMsg(String error){
        return writeFailAndMsg(error, null);
    }

    public static Map writeFail(){
        return writeFailAndMsg("系统出错！", null);
    }

    /**
     *
     * @param sign   0:该账户不存在，1：客户端唯一标识过期，请重新登录
     * @return
     */
    public static Map writeUnAuth(Integer sign){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put(SUCCESS,false);
        if(sign==0){
            map.put("msg","该账户不存在！");
            return map;
        }
        map.put("errorCode","00001");
        map.put("msg","登录密钥已失效，请重新登录！");
        return map;
    }

    public static Map writeSuccess(Object object,String name){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put(SUCCESS,true);
        map.put(name,object);
        return map;
    }

    public static Map writeSuccess(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put(SUCCESS,true);
        return map;
    }

    /**
     * 输出json
     */
    public static String writeJson(Object obj){
        return objectMapper.toJson(obj);
    }

    /**
     * 获得封装过的objectMapper
     */
    public static JsonMapper getJsonMapper() {
        return objectMapper;
    }
}
