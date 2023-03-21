package com.zz.test.utils;

import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author fanqiliu
 * @date 2021/10/21 10:12
 * @description
 */
public final class JsonUtils {

    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);
    public static final ObjectMapper objectMapper = new ObjectMapper();

    protected final static PrettyPrinter NULL_PRETTY_PRINTER = new MinimalPrettyPrinter();
    
    static {
    	
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.setTimeZone(TimeZone.getDefault());
		// 空值不序列化
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
		// 反序列化时，属性不存在的兼容处理
		objectMapper.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		// 反序列化时，空字符串转为NULL
		objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		// 设置实体无属性和json串属性对应时不会出错
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 序列化时，日期的统一格式
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		// 单引号处理
		objectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);
    }
    
    private JsonUtils() {}

    public static final <T> Optional<String> parse(T object) {
        //将对象序列化为json字符串
        String jsonString = "";
        try {
            jsonString = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return Optional.ofNullable(jsonString);
    }


    public static final <T> Optional<String> parseWithMinimalPrettyPrinter(T object) {
        String result = null;
        try {
            result = objectMapper.writer(NULL_PRETTY_PRINTER).writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return Optional.ofNullable(result);
    }
    
    public static final <T> Optional<T> parse(String jsonString, Class<T> clazz) {
        //将json反序列化为java对象
        T result = null;
        try {
            result = objectMapper.readValue(jsonString, clazz);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return Optional.ofNullable(result);
    }
    
    public static final <T> Optional<T> convertValue(Object fromValue, Class<T> toValueType) {
        T result = objectMapper.convertValue(fromValue, toValueType);
        return Optional.ofNullable(result);
    }
    
    public static final <T> Optional<T> convertValue(Object fromValue, TypeReference<T> toValueTypeRef) {
        T result = objectMapper.convertValue(fromValue, toValueTypeRef);
        return Optional.ofNullable(result);
    }

    public static final <T> Optional<T> parse(String jsonString, TypeReference<T> typeReference) {
        //将json反序列化为java对象
        T result = null;
        try {
            result = objectMapper.readValue(jsonString, typeReference);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(), e);
        }
        return Optional.ofNullable(result);
    }
}
