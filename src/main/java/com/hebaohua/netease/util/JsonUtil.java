package com.hebaohua.netease.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
 * json转换方面的工具类,全部为静态方法
 * 
 */
@SuppressWarnings({ "deprecation", "unchecked" })
public class JsonUtil {
	private static final Log log = LogFactory.getLog(JsonUtil.class);
	private static ObjectMapper mapper = new ObjectMapper();


	/**
	 * 将对象转换成json字符串,如果转换失败则返回null
	 * @author zhaoyunxiao
	 * @param o 需要转换为json的对象
	 * @return String 转换后的json字符串
	 * 
	 * 
	 * */
    public static String write2JsonStr(Object o){
    	String jsonStr = "";
    	try {
    		jsonStr = mapper.writeValueAsString(o);
		} catch (Exception e) {
			log.error("write2JsonStr() exception: " + e.getMessage());
		}
		return jsonStr;
    }
    
    /**
     * 将json转换为对象 如果对象模版为内部类会出现问题，所以不要使用内部类
     * @author zhaoyunxiao
     * @param json 要转换的json
//     * @param 要映射的类型
     * @return 转换成的目标对象，如果转换失败返回null
     * */
    public static Object json2Object(String json,Class<?> clazz){
    	try {
			 return mapper.readValue(json,clazz);
		} catch (JsonParseException e) {
			log.error("json2Object() parseException: " + e.getMessage());
		} catch (JsonMappingException e) {
			log.error("json2Object() mappingException: " + e.getMessage());
		} catch (IOException e) {
			log.error("json2Object() IOException: " + e.getMessage());
		}
    	return null;
    }
    

    /**
     * 将json数组转换为List<Map<String,Object>> json数组格式[{},{}]
     * @author zhaoyunxiao
//     * @param  需要转换的json数组
     * @return 转换后的列表   如果转换失败返回null
     * */
	public static List<Map<String,Object>> jsonArray2List(String jsonArray){
        try {
			return mapper.readValue(jsonArray, List.class);
		} catch (JsonParseException e) {
			log.error("jsonArray2List() exception, 异常字符串: " + jsonArray, e);
		} catch (JsonMappingException e) {
			log.error("jsonArray2List() exception, 异常字符串: " + jsonArray, e);
		} catch (IOException e) {
			log.error("jsonArray2List() exception",e);
		}
        return new ArrayList<Map<String,Object>>();
    }

   
}
