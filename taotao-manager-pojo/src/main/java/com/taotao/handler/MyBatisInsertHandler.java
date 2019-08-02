package com.taotao.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;


public class MyBatisInsertHandler  implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Date now = new Date();
        this.setFieldValByName("created", now, metaObject);
        this.setFieldValByName("updated", now, metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updated", new Date(), metaObject);

    }
}
