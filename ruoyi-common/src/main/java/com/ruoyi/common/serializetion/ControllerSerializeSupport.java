/**
 * 
 */
package com.ruoyi.common.serializetion;

import com.ruoyi.common.annotation.SerializationFilter;
import com.ruoyi.common.annotation.SerializationFilters;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.Method;

/**
 *
 * @author xw
 * date:2021-10-19
 * 控制器数据序列化
 */
public class ControllerSerializeSupport {
    /**
     * 时间格式
     */
    @Value("yyyy-MM-dd HH:mm:ss")
    private String datePattern;

    /**
     * json 序列化器
     */
    @Value("com.ruoyi.common.serializetion.GsonSerializer")
    private Class<? super BaseJsonSerializer> jsonSerializerClass;

    /**
     * xml 序列化器
     */
    private Class<? super BaseXmlSerializer> xmlSerializerClass;

    /**
     * json 序列化器(实例)
     */
    private BaseJsonSerializer jsonSerializer;

    /**
     * xml 序列化器(实例)
     */
    private BaseXmlSerializer xmlSerializer;

    public Object doAround(Object obj, Method method) {
        SerializationFilters fs = method.getAnnotation(
                SerializationFilters.class);
        SerializationFilter f = method.getAnnotation(
                SerializationFilter.class);
        Filter[] filters = null;
        String pattern = null;
        if (null != fs) {
            pattern = fs.filters()[0].datePattern();
            filters = new Filter[fs.filters().length];
            for (int i = 0; i < fs.filters().length; i++) {
                filters[i] = Filter.create(fs.filters()[i]);
            }
        } else if (null != f) {
            pattern = f.datePattern();
            filters = new Filter[] { Filter.create(f) };
        } else {
            // 没有json注解则直接返回
            return obj;
        }
        BaseJsonSerializer jsonSerializer = getJsonSerializer();
        jsonSerializer.setDatePattern(pattern);
        String json = jsonSerializer.serialize(obj, filters);
        obj = json;
        return obj;
    }

    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = pjp.proceed();
        MethodSignature msig = (MethodSignature) pjp.getSignature();
        SerializationFilters fs = msig.getMethod().getAnnotation(
                SerializationFilters.class);
        SerializationFilter f = msig.getMethod().getAnnotation(
                SerializationFilter.class);
        Filter[] filters = null;
        if (null != fs) {
            filters = new Filter[fs.filters().length];
            for (int i = 0; i < fs.filters().length; i++) {
                filters[i] = Filter.create(fs.filters()[i]);
            }
        } else if (null != f) {
            filters = new Filter[] { Filter.create(f) };
        } else {
            // 没有json注解则直接返回
            return obj;
        }
        String json = getJsonSerializer().serialize(obj, filters);
        obj = json;
        return obj;
    }



    /**
     * @return the jsonSerializer
     */
    public BaseJsonSerializer getJsonSerializer() {
        if (null == jsonSerializer) {
            try {
                jsonSerializer = (BaseJsonSerializer) jsonSerializerClass.newInstance();
//                jsonSerializer.setDatePattern(datePattern);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return jsonSerializer;
    }


    /**
     * @return the xmlSerializer
     */
    public BaseXmlSerializer getXmlSerializer() {
        if (null == xmlSerializer) {
            try {
                xmlSerializer = (BaseXmlSerializer) xmlSerializerClass.newInstance();
                xmlSerializer.setDatePattern(datePattern);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return xmlSerializer;
    }


    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }



    /**
     * @param jsonSerializerClass the jsonSerializerClass to set
     */
    public void setJsonSerializerClass(
            Class<? super BaseJsonSerializer> jsonSerializerClass) {
        this.jsonSerializerClass = jsonSerializerClass;
    }



    /**
     * @param xmlSerializerClass the xmlSerializerClass to set
     */
    public void setXmlSerializerClass(
            Class<? super BaseXmlSerializer> xmlSerializerClass) {
        this.xmlSerializerClass = xmlSerializerClass;
    }
    
}
