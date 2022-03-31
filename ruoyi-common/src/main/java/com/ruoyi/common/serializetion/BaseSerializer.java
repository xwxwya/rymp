/**
 * 
 */
package com.ruoyi.common.serializetion;

/**
 *
 * @author xw
 * date:2021-10-19
 */
public abstract class BaseSerializer implements Serializer {
    /**
     * 序列化时间格式
     */
    protected String datePattern;

    /**
     * @param datePattern the dateFormat to set
     */
    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

}
