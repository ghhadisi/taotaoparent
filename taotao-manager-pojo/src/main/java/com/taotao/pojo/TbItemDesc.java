package com.taotao.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;
@Data
public class TbItemDesc {
    private Long itemId;

    @TableField(fill= FieldFill.INSERT)
    private Date created;

    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date updated;

    private String itemDesc;

}