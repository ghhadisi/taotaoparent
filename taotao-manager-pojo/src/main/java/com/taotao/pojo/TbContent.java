package com.taotao.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("TbContent")
public class TbContent {
    private Long id;

    @TableField("categoryId")
    private Long categoryId;

    private String title;

    @TableField("subTitle")
    private String subTitle;

    @TableField("titleDesc")
    private String titleDesc;

    private String url;

    private String pic;

    private String pic2;

    private Date created;

    private Date updated;

    private String content;

}