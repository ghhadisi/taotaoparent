package com.taotao.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("TbContentCategory")
public class TbContentCategory {
    private Long id;

    @TableField("parentId")
    private Long parentId;

    private String name;

    private Integer status;

    @TableField("sortOrder")
    private Integer sortOrder;

    @TableField("isParent")
    private Boolean isParent;

    @TableField(fill= FieldFill.INSERT)
    private Date created;

    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date updated;

}