package com.taotao.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;
@Data
public class TbOrder {
    private String orderId;

    private String payment;

    private Integer paymentType;

    private String postFee;

    private Integer status;

    @TableField(fill= FieldFill.INSERT)
    private Date created;

    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date updated;

    private Date paymentTime;

    private Date consignTime;

    private Date endTime;

    private Date closeTime;

    private String shippingName;

    private String shippingCode;

    private Long userId;

    private String buyerMessage;

    private String buyerNick;

    private Integer buyerRate;

}