package com.taotao.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName("TbItem")
@Data
public class TbItem implements Serializable{
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String title;

    @TableField("sellPoint")
    private String sellPoint;

    private Long price;

    private Integer num;

    private String barcode;

    private String image;

    private Long cid;

    private Byte status;

    @TableField(fill= FieldFill.INSERT)
    private Date created;

    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date updated;

}