package com.ruoyi.framework.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
* @Description:   实体类公共字段自动注入
* @Author: Steerforth
* @Date: 2018/7/2 0002
*/
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = getFieldValByName("createTime", metaObject);//mybatis-plus版本2.0.9+
        if (createTime == null) {
            setFieldValByName("createTime", new Date(), metaObject);//mybatis-plus版本2.0.9+
        }

        Object updateTime = getFieldValByName("updateTime", metaObject);//mybatis-plus版本2.0.9+
        if (updateTime == null) {
            setFieldValByName("updateTime", new Date(), metaObject);//mybatis-plus版本2.0.9+
        }

        Object status = getFieldValByName("status", metaObject);//mybatis-plus版本2.0.9+
        if (status == null) {
            setFieldValByName("status", 0, metaObject);//mybatis-plus版本2.0.9+
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateTime = getFieldValByName("updateTime", metaObject);//mybatis-plus版本2.0.9+
        if (updateTime == null) {
            setFieldValByName("updateTime", new Date(), metaObject);//mybatis-plus版本2.0.9+
        }
    }
}
