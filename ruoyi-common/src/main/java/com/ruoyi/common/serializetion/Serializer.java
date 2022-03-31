package com.ruoyi.common.serializetion;

/**
 *
 * @author xw
 * date:2021-10-19
 * 序列化规范
 */
public interface Serializer {
   
    /**
     * 序列化
     * @param obj 序列化对象
     * @return 序列化结果
     */
    String serialize(Object obj);
    
    
    /**
     * 
     * @param obj 序列化对象
     * @param filters 过滤配置
     * @return
     */
    String serialize(Object obj, Filter[] filters);
}
